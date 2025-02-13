package com.example.practo.repository;

import com.example.practo.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepo extends JpaRepository<State,Long> {
}
