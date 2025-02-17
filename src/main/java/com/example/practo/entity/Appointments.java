package com.example.practo.entity;

import com.example.practo.entity.Doctor;
import com.example.practo.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public  Appointments(){}


    public Appointments( Doctor doctor, LocalDateTime time, Status status) {

        this.doctor = doctor;
        this.time = time;
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private LocalDateTime time;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public enum Status {
        PENDING,
        COMPLETED,
        CANCELLED
    }



}
