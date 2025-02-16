package com.example.practo.indexes;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.util.List;

@Document(indexName = "hospitals")
public class HospitalIndex {
    @Id
    private String id;
    private String name;
    private String cityName;
    private List<DoctorIndex> doctorIndex;



    public HospitalIndex(){};
    public HospitalIndex(String id, String name, String cityName) {
        this.id = id;
        this.name = name;
        this.cityName = cityName;
    }

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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
