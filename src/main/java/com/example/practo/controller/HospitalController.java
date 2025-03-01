package com.example.practo.controller;

import com.example.practo.ElasticRepository.DoctorSearchRepository;
import com.example.practo.ElasticRepository.HospitalSearchRepository;
import com.example.practo.indexes.DoctorIndex;
import com.example.practo.indexes.HospitalIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller

public class HospitalController {

    @Autowired
    HospitalSearchRepository hospitalSearchRepository;

    @Autowired
    DoctorSearchRepository doctorSearchRepository;
    @GetMapping("/hospital/hospitalProfile/{id}")
    public String viewHospitalProfile(@PathVariable String id, Model model) {

        Optional<HospitalIndex> hospital = hospitalSearchRepository.findById(id);

        Long hospitalId;
        try {
            hospitalId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            return "error";
        }


        List<DoctorIndex> doctorList = doctorSearchRepository.findByHospitalId(id);


        System.out.println("Fetched Doctors: " + doctorList);

        if (hospital.isPresent()) {
            model.addAttribute("hospital", hospital.get());
            model.addAttribute("doctorList", doctorList);

            return "practiseProfile";
        } else {
            return "error";
        }
    }


}
