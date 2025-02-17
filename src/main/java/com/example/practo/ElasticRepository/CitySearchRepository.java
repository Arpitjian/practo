package com.example.practo.ElasticRepository;

import com.example.practo.indexes.CityIndex;
import com.example.practo.indexes.DoctorIndex;
import com.example.practo.indexes.HospitalIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CitySearchRepository extends ElasticsearchRepository<CityIndex, String> {
    List<CityIndex> findByNameContaining(String name);


}
