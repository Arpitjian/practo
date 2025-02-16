package com.example.practo.controller;

import com.example.practo.ElasticRepository.DoctorSearchRepository;
import com.example.practo.ElasticRepository.HospitalSearchRepository;
import com.example.practo.entity.*;
import com.example.practo.indexes.DoctorIndex;
import com.example.practo.indexes.HospitalIndex;
import com.example.practo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private DoctorSearchRepository doctorSearchRepository;

    @Autowired
    private HospitalSearchRepository hospitalSearchRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

        @GetMapping("/doctor/doctorProfile/{id}")
        public String viewDoctorProfile(@PathVariable String id, Model model) {
        Optional<DoctorIndex> doctor = doctorSearchRepository.findById(id);

        if (doctor.isPresent()) {
            model.addAttribute("doctor", doctor.get());
            return "DoctorProfile"; // Render the Thymeleaf template
        } else {
            return "error"; // Show an error page if doctor is not found
        }
    }

    @GetMapping("/bookAppointMent/{id}")
    public String bookAppointment(@PathVariable String id, Model model) {
        return "bookAppointment";
    }

    @GetMapping("/saveAppointment")
    public String saveAppointment(){
        return "success";
    }


}






