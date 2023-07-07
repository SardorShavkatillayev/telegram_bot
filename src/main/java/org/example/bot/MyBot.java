package org.example.bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

public class MyBot extends TelegramLongPollingBot {
    UpdateHandler updateHandler = new UpdateHandler(this);

    @Override
    @SneakyThrows

    public void onUpdateReceived(Update update) {
        updateHandler.handler(update);
    }


    @Override
    public String getBotUsername() {
        return "https://t.me/SARDOR_Belissim0_Clone_Bot";
    }

    @Override
    public String getBotToken() {
        return "6344830534:AAHmOtigrIiU1PS3pdCWGqAEoksVoDZx2wA";
    }


}
