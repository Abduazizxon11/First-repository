package org.example;

import org.example.States.BotState;
import org.example.States.Roles;
import org.example.model.User;
import org.example.service.BotButtonService;
import org.example.service.impl.UserServiceImpl;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class MyBot extends TelegramLongPollingBot {
    UserServiceImpl userService = new UserServiceImpl();
    BotButtonService buttonService = new BotButtonService();
    public MyBot(String botToken){
        super(botToken);
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().hasText() && update.hasMessage()){
            String text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            if (text.equals("/start") || text.equals("Orqaga")){
                User user = new User(chatId, update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getUserName(), update.getMessage().getText(), BotState.LANG, Roles.USER);
                try {
                    userService.create(user);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("Assalomu aleykum. Tilni tanlang\n\n" +
                        "Привет. Выберите язык");
                message.setReplyMarkup(buttonService.language());
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }else {
                User user = userService.get(chatId);
                switch (user.getState()){

                    case LANG -> {
                        if (text.equals("\uD83C\uDDFA\uD83C\uDDFF O'zbek tili")){
                            SendMessage txt = new SendMessage();
                            txt.setText("Yaxshi endi registratsiyani davom ettirish uchun botga qanday maqsadda kirganingizni yozing");
                            txt.setChatId(chatId);
                            txt.setReplyMarkup(buttonService.sales());
                            try {
                                execute(txt);
                            } catch (TelegramApiException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (text.equals("Русский язык \uD83C\uDDF7\uD83C\uDDFA")) {

                        }
                    }case REGISTRATION -> {

                    }
                }
            }
        } else if (update.hasCallbackQuery()) {

        }
    }

    @Override
    public String getBotUsername() {
        return "sale_sell_market_uzum_bot";
    }
}
