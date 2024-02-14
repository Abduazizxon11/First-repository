package org.example.service;

import org.example.model.Product;
import org.example.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void create(User user) throws IOException;

    void update(long chatId, User user);
    void delete(long chatId);
    User get(long chatId);
    List<User> getAll();
    List<Product> basket();
}
