package com.example.practo.controller;

import com.example.practo.entity.*;
import com.example.practo.repository.*;
import com.example.practo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServices userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpecialityRepo specialityRepo;

    @Autowired
    private StateRepo stateRepo;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private  HospitalRepository hospitalRepository;

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String role, Model model) {
        userService.registerUser(username, password, role);
        model.addAttribute("message", "Registration successful! Please login.");
        return "homePage";
    }


    @GetMapping("/signup")
    public  String signup(){
        return  "signup";
    }

    @GetMapping("/login")
    public  String login(){
        return  "loginPage";
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

        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "loginPage"; // Reload login page with an error message
        }
    }
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
        return  "successDoctor";
    }

    @GetMapping("/addPractise")
    public String addPracrtise(Model model){



        List<State> stateList = stateRepo.findAll();
        List<City> cityList = cityRepo.findAll();

        model.addAttribute("Cities",cityList);
        model.addAttribute("States",stateList);



        System.out.println("States: " + stateList);
        System.out.println("Cities: " + cityList);

        System.out.println("inside the adddocto fundtion");
        return  "addPractise";
    }
    @PostMapping("/savePractise")
    public String saveDoctor(@RequestParam String name,
                             @RequestParam Long cityId,
                             @RequestParam Long stateId
                             ) {
        Hospital hospital = new Hospital();
        hospital.setName(name);

       // Long stateIdl = Long.parseLong(stateId);
       // Long cityIdl = Long.parseLong(cityId);
        City city = cityRepo.findById(cityId).orElse(null);
        State state = stateRepo.findById(stateId).orElse(null);

        if (city != null && state != null) {
            hospital.setCity(city);
            hospital.setState(state);
            hospitalRepository.save(hospital);
            return "successPractise";
        } else {
            // Handle the case where city or state is not found, maybe return an error message
            return "error";
        }
        //return  "success";
    }

    @GetMapping("/addSpeciality")
    public  String addSpeciality(){
        return "addSpeciality";
    }
    @PostMapping("/saveSpeciality")
    public String saveSpeciality(@RequestParam String name){
        Speciality speciality =  new Speciality();
        speciality.setName(name);
        specialityRepo.save(speciality);
        return "Success";
    }



}
