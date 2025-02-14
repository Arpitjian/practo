package com.example.practo.indexes;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Document(indexName = "doctors")
public class DoctorIndex {
    @Id
    private String id;


    private String name;
    private String about;
    private String specialityName;
    private String cityName;

    public  DoctorIndex(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public DoctorIndex(String id, String name, String about, String specialityName, String cityName) {
        this.name = name;
        this.about = about;
        this.id = id;
        //this.about = about;
        this.specialityName = specialityName;
        this.cityName = cityName;

    }
}
