package com.example.practo.controller;

import com.example.practo.entity.Speciality;
import com.example.practo.repository.SpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class SpecialityController {
    //@Autowired Speciality speciality;
    @Autowired
    private SpecialityRepo specialityRepo;


    @GetMapping("/getSpeciality")
   public  List<Speciality> getSpecialities(){

        return specialityRepo.findAll();
    }
}
