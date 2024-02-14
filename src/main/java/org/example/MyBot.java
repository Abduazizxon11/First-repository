package org.example;

import org.example.States.BotState;
import org.example.States.Roles;
import org.example.model.User;
import org.example.service.impl.UserServiceImpl;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class MyBot extends TelegramLongPollingBot {
    UserServiceImpl userService = new UserServiceImpl();
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
            }else {
                User user = userService.get(chatId);
                switch (user.getState()){
                    case LANG -> {
                        if (text.equals("O'zbek tili")){

                        } else if (text.equals("Rus tili")) {

                        }
                    }case MAIN -> {

                    }
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "sale_sell_market_uzum_bot";
    }
}
