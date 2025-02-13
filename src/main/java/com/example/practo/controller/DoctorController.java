package com.example.practo.controller;

import com.example.practo.entity.City;
import com.example.practo.entity.Doctor;
import com.example.practo.entity.Speciality;
import com.example.practo.entity.State;
import com.example.practo.repository.CityRepo;
import com.example.practo.repository.DoctorRepository;
import com.example.practo.repository.SpecialityRepo;
import com.example.practo.repository.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.validation.constraints.Null;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private SpecialityRepo specialityRepo;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private StateRepo stateRepo;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/addDoctor")
    public String addDoctor(Model model){


        List<Speciality> specialityList = specialityRepo.findAll();
        List<State> stateList = stateRepo.findAll();
        List<City> cityList = cityRepo.findAll();
        model.addAttribute("specialites",specialityList);
        model.addAttribute("Cities",cityList);
        model.addAttribute("states",stateList);


        System.out.println("Specialities: " + specialityList);
        System.out.println("States: " + stateList);
        System.out.println("Cities: " + cityList);

        System.out.println("inside the adddocto fundtion");
        return  "addDoctor";
    }


    @PostMapping("/saveDoctor")
    public String saveDoctor(@RequestParam String name,
                             @RequestParam Integer age,
                             @RequestParam String about,
                             @RequestParam Long speciality,
                             @RequestParam Long cityId,
                             @RequestParam Long stateId,
                             @RequestParam String qualification) {
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setAge(age);
        doctor.setAbout(about);
        doctor.setSpeciality(specialityRepo.findById(speciality).orElse(null));
        doctor.setCity(cityRepo.findById(cityId).orElse(null));
        doctor.setState(stateRepo.findById(stateId).orElse(null));
        doctorRepository.save(doctor);
        return  "success";






    }
}

