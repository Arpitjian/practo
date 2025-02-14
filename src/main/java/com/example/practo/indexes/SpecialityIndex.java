package com.example.practo.indexes;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Document(indexName = "specialities")
public class SpecialityIndex {
    @Id
    private String id;
    private String name;

    public SpecialityIndex(){};

    public SpecialityIndex(String id, String name) {
        this.id = id;
        this.name = name;
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
}

