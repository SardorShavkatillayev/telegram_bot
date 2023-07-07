package org.example.bot;

import org.example.product.Product;
import org.example.user.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class KeybordBuilder {
    public ReplyKeyboardMarkup requstPhoneNumber() {

        KeyboardButton keyboardButton = new KeyboardButton("Raqamni ulashish");
        keyboardButton.setRequestContact(true);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(List.of(new KeyboardRow(List.of(keyboardButton))));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public InlineKeyboardMarkup home(User user) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        switch (user.getUserRole()) {
            case CUSTOMER -> {
                InlineKeyboardButton order = new InlineKeyboardButton("buyrtma berish");
                InlineKeyboardButton myOrder = new InlineKeyboardButton("mening buyurtmalarim");
                order.setCallbackData(CallbackData.CUSTOMER_ORDER);
                myOrder.setCallbackData(CallbackData.MY_CUSTOMER_ORDER);
                inlineKeyboardMarkup.setKeyboard(List.of(List.of(order, myOrder)));

            }
            case COOK -> {
                InlineKeyboardButton order = new InlineKeyboardButton("yangi buyurtmalar");
                InlineKeyboardButton myOrder = new InlineKeyboardButton("bajargan buyurtmalarim");
                order.setCallbackData(CallbackData.COOK_NEW_ORDER);
                myOrder.setCallbackData(CallbackData.COOK_CUSTOMER_ORDER);
                inlineKeyboardMarkup.setKeyboard(List.of(List.of(order, myOrder)));
            }
            case CUORIER -> {
                InlineKeyboardButton order = new InlineKeyboardButton(" Tayyor buyurtmalr");
                InlineKeyboardButton myOrder = new InlineKeyboardButton("yetqazgan buyurtmalarim");
                order.setCallbackData(CallbackData.CUORIER_ALL_READY_ORDER);
                myOrder.setCallbackData(CallbackData.CUORIER_DELIVERED_ORDER);
                inlineKeyboardMarkup.setKeyboard(List.of(List.of(order, myOrder)));
            }
        }
        return inlineKeyboardMarkup;
    }

    public ReplyKeyboardRemove remove() {
        return new ReplyKeyboardRemove(true);
    }

    public ReplyKeyboardMarkup requstLocation() {
        KeyboardButton keyboardButton = new KeyboardButton("Mening joylashivumni yuborish");
        keyboardButton.setRequestLocation(true);

        KeyboardButton orqaga = new KeyboardButton("Orqaga");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup
                (List.of(new KeyboardRow(List.of(keyboardButton)), new KeyboardRow(List.of(orqaga))));
        replyKeyboardMarkup.setResizeKeyboard(true);


        return replyKeyboardMarkup;

    }

    public InlineKeyboardMarkup productChooser(List<Product> products) {


        List<InlineKeyboardButton> list = products.stream().map(product -> {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton(product.getName());
            inlineKeyboardButton.setCallbackData(CallbackData.Choose_Product + product.getId());
            return inlineKeyboardButton;
        }).toList();

        return new InlineKeyboardMarkup(List.of(list));

    }

}
