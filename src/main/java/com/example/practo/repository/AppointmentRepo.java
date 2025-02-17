package com.example.practo.repository;


import com.example.practo.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo  extends JpaRepository<Appointments,Long> {

}
