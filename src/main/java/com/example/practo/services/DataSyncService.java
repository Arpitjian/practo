package com.example.practo.services;

import com.example.practo.ElasticRepository.CitySearchRepository;
import com.example.practo.ElasticRepository.DoctorSearchRepository;
import com.example.practo.ElasticRepository.HospitalSearchRepository;
import com.example.practo.ElasticRepository.SpecialitySearchRepository;
import com.example.practo.entity.Doctor;
import com.example.practo.indexes.DoctorIndex;
import com.example.practo.indexes.HospitalIndex;
import com.example.practo.repository.CityRepo;
import com.example.practo.repository.DoctorRepository;
import com.example.practo.repository.HospitalRepository;
import com.example.practo.repository.SpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataSyncService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorSearchRepository doctorSearchRepository;

    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private HospitalSearchRepository hospitalSearchRepository;

    @Autowired
    private CityRepo cityRepository;
    @Autowired
    private CitySearchRepository citySearchRepository;

    @Autowired
    private SpecialityRepo specialityRepository;
    @Autowired
    private SpecialitySearchRepository specialitySearchRepository;


    @PostConstruct
    public void syncDataToElastic() {
        doctorRepository.findAll().forEach(doctor -> {
            List<Doctor> doctors = doctorRepository.findAll();
            System.out.println("Total doctors in MySQL: " + doctors.size());
            try {
                // System.out.println("Total doctors in MySQL: " + doctors.size());
                DoctorIndex doctorIndex = new DoctorIndex(
                        doctor.getId().toString(),
                        doctor.getName(),
                        doctor.getAbout(),
                        doctor.getSpeciality().getName(),
                        doctor.getCity().getName()
                );
                doctorSearchRepository.save(doctorIndex);
                System.out.println(" Synced: " + doctor.getName());
            } catch (Exception e) {
                System.err.println(" Error syncing doctor: " + doctor.getName() + " -> " + e.getMessage());
            }
        });
    }
    @PostConstruct
    public void syncHospitalsToElastic() {
        hospitalRepository.findAll().forEach(hospital -> {
            try {
                String cityName = (hospital.getCity() != null) ? hospital.getCity().getName() : "Unknown";
                System.out.println("Syncing Hospital -> Name: " + hospital.getName() + ", City: " + cityName);

                HospitalIndex hospitalIndex = new HospitalIndex(
                        hospital.getId().toString(),
                        hospital.getName(),
                        cityName
                );

                hospitalSearchRepository.save(hospitalIndex);
                System.out.println(" Synced Hospital: " + hospital.getName());
            } catch (Exception e) {
                System.err.println( "Error syncing hospital: " + hospital.getName() + " -> " + e.getMessage());
            }
        });
    }


}
