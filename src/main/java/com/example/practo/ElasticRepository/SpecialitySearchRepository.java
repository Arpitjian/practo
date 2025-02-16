package com.example.practo.ElasticRepository;

import com.example.practo.indexes.SpecialityIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface SpecialitySearchRepository extends ElasticsearchRepository<SpecialityIndex, String> {
    List<SpecialityIndex> findByNameContaining(String name);
}
