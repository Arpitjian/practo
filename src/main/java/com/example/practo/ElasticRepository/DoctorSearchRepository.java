package com.example.practo.ElasticRepository;

import com.example.practo.indexes.DoctorIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface DoctorSearchRepository extends ElasticsearchRepository<DoctorIndex, String> {
    List<DoctorIndex> findByNameContainingOrSpecialityNameContaining(String name, String speciality);
}

