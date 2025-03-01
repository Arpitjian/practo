package com.example.practo.controller;

import com.example.practo.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    public String search(@RequestParam String keyword, Model model) {
        Map<String, Object> results = searchService.search(keyword);

        model.addAttribute("keyword", keyword);
        model.addAttribute("doctors", results.get("doctors"));
        model.addAttribute("hospitals", results.get("hospitals"));
        model.addAttribute("cities", results.get("cities"));
        model.addAttribute("specialities", results.get("specialities"));

        return "ResultPage";
    }
}
