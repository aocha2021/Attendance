package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    /**
     * レコードを全件取得する。
     * 
     * @return
     */
    public List<User> findAllUserData() {
        return userRepository.findAll();
    }
    

    public User selectByMail(String mail) {
        return userRepository.findByMail(mail);
    }
    
}