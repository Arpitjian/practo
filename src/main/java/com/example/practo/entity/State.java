package com.example.practo.entity;



import javax.persistence.*;


@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
//    private List<City> cities;
}