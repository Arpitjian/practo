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

import javax.print.Doc;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.elasticsearch.annotations.DateFormat.time;

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
    private  AppointmentRepo appointmentRepo;

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

    @GetMapping("/bookAppointment/{id}")
    public String bookAppointment(@PathVariable String id, Model model) {
            Long idl = Long.parseLong(id);
        Doctor doctor = doctorRepository.findById(idl).orElse(null);
        if (doctor == null) {
            // Handle the case when doctor is not found
            return "doctorNotFound";
        }
        model.addAttribute("doctor", doctor);
        return "bookAppointment";
    }

    @PostMapping("/saveAppointment/{id}")
    public String saveAppointment(@PathVariable Long id, @RequestParam String time) {
        // Fetch the doctor
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor == null) {
            System.out.println("Doctor not found");
            return "Doctor not found!";
        }

        System.out.println("Appointment time: "+time);

        try {
            // Convert time string to LocalDateTime
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

            // Convert the time string to LocalDateTime
            LocalDateTime appointmentTime = LocalDateTime.parse(time, formatter);

            // Create and save the appointment with default status PENDING
            Appointments appointment = new Appointments(doctor, appointmentTime, Appointments.Status.PENDING);
            appointmentRepo.save(appointment);

            return "success";
        } catch (Exception e) {
            System.out.println("Error parsing time: " + e.getMessage());
            return "success";
        }
    }



}






