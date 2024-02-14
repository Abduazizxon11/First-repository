package org.example.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.example.States.BotState;
import org.example.model.Product;
import org.example.model.User;
import org.example.service.FileService;
import org.example.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final String fileName = "users.txt";
    private FileService fileService = new FileServiceImpl();


    List<User> users = new ArrayList<>();


    @Override
    public void create(User user) throws IOException {
        String dataFromFile = fileService.getFromDataFile(fileName);
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = new ArrayList<>();
        list.add(user);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        boolean b = fileService.writeDataFromFile(json, fileName);
        System.out.println(b);


        User user1 = new User(user.getChatId(), user.getFullName(), user.getUsername(), user.getPassword(), user.getState(), user.getRole());
        users.add(user1);
    }

    @Override
    public void update(long chatId, User user) {
        for (int i = 0; i < users.size(); i++) {
            User user2 = users.get(i);
            if(chatId == user2.getChatId()){
                if(!user.getFullName().equals("")){
                    user2.setFullName(user.getFullName());
                }
                if(user.getUsername().equals("")){
                    user2.setUsername(user.getUsername());
                }
                if(user.getPassword().equals("")){
                    user2.setPassword(user.getPassword());
                }
            }
        }
    }

    @Override
    public void delete(long chatId) {
        User temp = null;
        for (User user:users) {
            if (user.getChatId() == chatId){
                temp = user;
            }
        }if (temp != null){
            users.remove(temp);
        }
    }

    @Override
    public User get(long chatId) {
        for (int i = 0; i < users.size(); i ++){
            if (chatId == users.get(i).getChatId()) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return users;
    }




    @Override
    public List<Product> basket() {
        return null;
    }
}
