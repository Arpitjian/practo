package com.example.practo.services;

import com.example.practo.entity.User;
import com.example.practo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerUser(String userName,String password,String role){
        String hashedPassword = passwordEncoder.encode(password);
        User user = new User(userName,hashedPassword,role);
        userRepository.save(user);
    }
    public boolean validateUser(String username, String rawPassword) {
        System.out.println("checking..");
        User user = userRepository.findByUserName(username);
        if (user == null) {
            return false; // User does not exist
        }
        boolean flag =  passwordEncoder.matches(rawPassword, user.getPassword());
        //System.out.println("");
        if(flag){
            System.out.println("Yes user is valid");
        }
        else{
            System.out.println("User invalid");
        }
        return  flag;
    }
}
