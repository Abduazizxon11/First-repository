package org.example.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class BotButtonService {
    public ReplyKeyboardMarkup language(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83C\uDDFA\uD83C\uDDFF O'zbek tili");
        row.add(button1);

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Русский язык \uD83C\uDDF7\uD83C\uDDFA");
        row.add(button2);

        rowList.add(row);
        markup.setKeyboard(rowList);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(true);

        return markup;
    }
    public InlineKeyboardMarkup sales(){
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setCallbackData("Sotuvchi mijoz");
        button1.setText("Sotuvchi");
        row.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Sotib oluvchi");
        button2.setCallbackData("Mijoz");
        row.add(button2);

        rowList.add(row);
        markup.setKeyboard(rowList);

        return markup;
    }
}
