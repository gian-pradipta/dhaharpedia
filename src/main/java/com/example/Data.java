package com.example;

public class Data {
    public static User[] users = {new User("admin", "admin") };
}

class User {
    String name;
    String password;
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public boolean validation(String name, String password) {
        if (this.name.equals(name) || this.password.equals(password)) {
            return true;
        }
        return false;
    }

}