package com.example.practo.services;

import com.example.practo.ElasticRepository.CitySearchRepository;
import com.example.practo.ElasticRepository.DoctorSearchRepository;
import com.example.practo.ElasticRepository.HospitalSearchRepository;
import com.example.practo.ElasticRepository.SpecialitySearchRepository;
import com.example.practo.indexes.CityIndex;
import com.example.practo.indexes.DoctorIndex;
import com.example.practo.indexes.HospitalIndex;
import com.example.practo.indexes.SpecialityIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {

    @Autowired
    private DoctorSearchRepository doctorSearchRepository;

    @Autowired
    private HospitalSearchRepository hospitalSearchRepository;

    @Autowired
    private CitySearchRepository citySearchRepository;

    @Autowired
    private SpecialitySearchRepository specialitySearchRepository;

    public Map<String, Object> search(String keyword) {
        Map<String, Object> results = new HashMap<>();

        // Search doctors by name or speciality
        List<DoctorIndex> doctors = doctorSearchRepository.findByNameContainingOrSpecialityNameContaining(keyword, keyword);
        List<DoctorIndex> doctorCity = doctorSearchRepository.findDoctorsByCityName(keyword);

        // Combine doctors and doctorCity results
        doctors.addAll(doctorCity);  // Add city-specific doctors to the list of doctors

        // Search hospitals by name
        List<HospitalIndex> hospitals = hospitalSearchRepository.findByNameContainingOrNameContaining(keyword, keyword);
        List<HospitalIndex> hosp1 = hospitalSearchRepository.findHospitalByCityName(keyword);

        // Combine hospitals and hosp1 results
        hospitals.addAll(hosp1);  // Add city-specific hospitals to the list of hospitals

        // Search cities by name
        List<CityIndex> cities = citySearchRepository.findByNameContaining(keyword);

        // Search specialities by name
        List<SpecialityIndex> specialities = specialitySearchRepository.findByNameContaining(keyword);

        // Combine results
        results.put("doctors", doctors);
        results.put("hospitals", hospitals);
        results.put("cities", cities);
        results.put("specialities", specialities);

        return results;
    }

}


