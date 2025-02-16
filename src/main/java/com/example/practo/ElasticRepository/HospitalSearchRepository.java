package com.example.practo.ElasticRepository;

import com.example.practo.indexes.HospitalIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface HospitalSearchRepository extends ElasticsearchRepository<HospitalIndex, String> {
    List<HospitalIndex> findByNameContainingOrNameContaining(String name, String city);
}
