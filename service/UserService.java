package service;

import entities.User;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class UserService {

    Set<User> users = new HashSet<User>();


    public void registration(String login, String password) throws IOException {
        User user = users.stream()
                .filter(curr -> login.equals(curr.getUsername()) & password.equals(curr.getPassword()))
                .findAny()
                .orElse(null);
        if(user == null) {
            User userToAdd = new User(login, password);
            users.add(userToAdd);
            System.out.println("User added");
        }
        else {
            System.out.println("User already exists");
        }

    }

    public void authentication(String login, String password) {
        User user = users.stream()
                .filter(curr -> login.equals(curr.getUsername()) & password.equals(curr.getPassword()))
                .findAny()
                .orElse(null);
        if(user == null) {
            System.out.println("Can't find user");
        }
        else {
            System.out.println("You are logged in");
        }
    }
}
