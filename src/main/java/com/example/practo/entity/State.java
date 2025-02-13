package com.example.practo.entity;



import javax.persistence.*;


@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//
//    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
//    private List<City> cities;
}