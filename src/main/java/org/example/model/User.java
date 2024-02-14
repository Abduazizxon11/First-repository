package org.example.model;

import org.example.States.BotState;
import org.example.States.Roles;

public class User {
    private long chatId;
    private String fullName;
    private String username;
    private String password;
    private BotState state;
    private Roles role;

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public BotState getState() {
        return state;
    }

    public void setState(BotState state) {
        this.state = state;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(long chatId, String fullName, String username, String password, BotState state, Roles role) {
        this.chatId = chatId;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.state = state;
        this.role = role;
    }

    public User() {
    }
}
