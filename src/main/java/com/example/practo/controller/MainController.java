package com.example.practo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public  String home(){
        return "homePage";
    }
    @GetMapping("/adminDashBoard")
    public String admin(){
        return  "adminDashBoard";
    }
    @GetMapping("/addReview")
    public String review(){
        return  "successreview";
    }
}
