package com.example.icare.icare.service;

import com.example.icare.icare.user.User;
import com.example.icare.icare.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class UserService   {
    @Autowired
    private UserRepository userRepository;


    public  List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return new ArrayList<>(users);
    }
    public void saveUser(User user) {
        userRepository.save(user);
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}


