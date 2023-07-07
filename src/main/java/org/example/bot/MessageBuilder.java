package org.example.bot;

import org.example.product.Product;
import org.example.product.ProductService;
import org.example.user.User;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

import java.util.ArrayList;
import java.util.List;

public class MessageBuilder {
    private final KeybordBuilder keybordBuilder = new KeybordBuilder();


    public SendMessage requstPhoneNumber(User user) {
        SendMessage sendMessage = new SendMessage(user.getId(), "Telefon raqamizni yuboring Namuna: 998919757535");
        sendMessage.setReplyMarkup(keybordBuilder.requstPhoneNumber());
        return sendMessage;

    }

    public SendMessage buildHome(User user) {
        SendMessage sendMessage = new SendMessage(user.getId(), "HOME");
        sendMessage.setReplyMarkup(keybordBuilder.home(user));
        return sendMessage;
    }

    public SendMessage confirmPhoneNumber(User user) {
        SendMessage sendMessage = new SendMessage(user.getId(), "Telefon raqam tasdiqlandi");
        sendMessage.setReplyMarkup(keybordBuilder.remove());
        return sendMessage;
    }

    public SendMessage requestLocation(User user) {

        SendMessage sendMessage = new SendMessage(user.getId(), "Marhamat yetqazib berish joyini yuboring");
        sendMessage.setReplyMarkup(keybordBuilder.requstLocation());
        return sendMessage;
    }

    public DeleteMessage deleteMessage(User user, int messageid) {
        return new DeleteMessage(user.getId(), messageid);

    }


    public SendMessage returnedhome(User user) {
        SendMessage sendMessage = new SendMessage(user.getId(), "Bosh menyuga qaytingiz");
        sendMessage.setReplyMarkup(keybordBuilder.remove());
        return sendMessage;

    }


    public SendMessage showProduct(User user, List<Product> products) {
        SendMessage sendMessage = new SendMessage(user.getId(),showroducyt(products));
        sendMessage.setReplyMarkup(keybordBuilder.productChooser(products));


        return sendMessage;
    }

    public String showroducyt(List<Product> productList) {
        StringBuilder response = new StringBuilder();

        for (int i = 0; i < productList.size(); i++) {
            response.append((i + 1)).append(". ").append(showproduct(productList.get(i))).append("\n\n");
        }
        return response.toString();
    }

    public String showproduct(Product product) {
        return product.getName() + "\n" + product.getProductType() + " - " + product.getPrice();
    }


}
