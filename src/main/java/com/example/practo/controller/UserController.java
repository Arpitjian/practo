package com.example.practo.controller;

import com.example.practo.entity.User;
import com.example.practo.repository.UserRepository;
import com.example.practo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserServices userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String role, Model model) {
        userService.registerUser(username, password, role);
        model.addAttribute("message", "Registration successful! Please login.");
        return "homePage"; // Redirect to login page after registration
    }
    @GetMapping("/login")
    public  String loginPage(){

        System.out.println("Insidde login page");
        return  "loginPage";
    }

    @GetMapping("/signup")
    public  String signup(){
        return  "signup";
    }

    @GetMapping("/loginUser")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {
        boolean isValidUser = userService.validateUser(email, password);

        if (isValidUser) {
            User user = userRepository.findByUserName(email);
            if (user.getRole().equals("admin")) {
                return "adminDashBoard";
            }

            else{
                return "userDashBoard";
            }
             // Redirect to the dashboard if valid
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "login"; // Reload login page with an error message
        }
    }


}
