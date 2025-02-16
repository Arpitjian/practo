package com.example.practo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private  String contact;


    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Doctor> doctors;


    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;


    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Hospital() {

    }

    public Hospital(String name, String contact, List<Doctor> doctors, City city, State state) {
       // this.id = id;
        this.name = name;
        this.contact = contact;
        this.doctors = doctors;
        this.city = city;
        this.state = state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}