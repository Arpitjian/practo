package com.example.practo.repository;

import com.example.practo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findBySpeciality_Name(String speciality);

    List<Doctor> findByCityName(String city);

    @Query("SELECT d FROM Doctor d WHERE d.name LIKE %:keyword% OR d.about LIKE %:keyword%")
    List<Doctor> searchDoctors(@Param("keyword") String keyword);
}
