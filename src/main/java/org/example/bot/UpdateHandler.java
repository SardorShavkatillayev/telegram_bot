package org.example.bot;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.example.order.Order;
import org.example.order.OrderService;
import org.example.product.Product;
import org.example.product.ProductService;
import org.example.user.PhoneNumberValidator;
import org.example.user.User;
import org.example.user.UserService;
import org.example.user.UserState;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.swing.border.Border;
import java.util.List;

import static org.example.user.UserState.HOME;

@AllArgsConstructor
public class UpdateHandler {

    private final MyBot bot;
    private final MessageBuilder messageBuilder = new MessageBuilder();
    private final UserService userService = new UserService();
    private final ProductService productService = new ProductService();
    private final OrderService orderService = new OrderService();


    @SneakyThrows
    public void handler(Update update) {
        if (update.hasMessage()) {
            handleMessage(update);
        } else if (update.hasCallbackQuery()) {
            handleCollbackQuery(update);
        }
    }

    @SneakyThrows
    public void handleMessage(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        User user = userService.findByIdOrElseCreated(update, chatId);
//           bot.execute(messageBuilder.getHello(user));

        switch (user.getUserState()) {
            case NEW -> {
                bot.execute(messageBuilder.requstPhoneNumber(user));
                user.setUserState(UserState.PHONE_NUMBER_REQUSTED);
            }
            case PHONE_NUMBER_REQUSTED -> {
                String phoneNumber = update.getMessage().getText();
                if (update.getMessage().hasContact()) {
                    phoneNumber = update.getMessage().getContact().getPhoneNumber();
                }
                boolean isValid = PhoneNumberValidator.validate(phoneNumber);
                if (isValid) {
                    user.setUserState(HOME);
                    user.setPhoneNumber(phoneNumber);
                    bot.execute(messageBuilder.confirmPhoneNumber(user));
                    bot.execute(messageBuilder.buildHome(user));
                } else {
                    bot.execute(messageBuilder.requstPhoneNumber(user));

                }

            }
            case HOME -> {
                bot.execute(messageBuilder.requstPhoneNumber(user));
            }
            case LOCATION_REQUST -> {
                if (update.getMessage().hasLocation()) {
                    List<Product> products = productService.getAll();
                    Order order = orderService.createOrder(update.getMessage().getLocation(),user);
                    bot.execute(messageBuilder.showProduct(user,products));

                } else {


                    if (update.getMessage().getText().equals("Orqaga")) {
                        user.setUserState(HOME);
                        bot.execute(messageBuilder.returnedhome(user));
                        bot.execute(messageBuilder.buildHome(user));
                    } else {
                        bot.execute(messageBuilder.requestLocation(user));
                    }
                }

            }
        }
    }


    @SneakyThrows
    public void handleCollbackQuery(Update update) {

        User user = userService.findByIdOrElseCreated(update, update.getCallbackQuery().getFrom().getId().toString());

        String data = update.getCallbackQuery().getData();

        switch (data) {
            case CallbackData.CUSTOMER_ORDER -> {
                user.setUserState(UserState.LOCATION_REQUST);
                bot.execute(messageBuilder.deleteMessage(user, update.getCallbackQuery().getMessage().getMessageId()));
                bot.execute(messageBuilder.requestLocation(user));

            }
            case CallbackData.MY_CUSTOMER_ORDER -> {
            }
        }


    }

}
