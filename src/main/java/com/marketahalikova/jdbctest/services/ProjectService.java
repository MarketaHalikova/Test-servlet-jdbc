package com.marketahalikova.jdbctest.services;

import com.marketahalikova.jdbctest.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<Project> findAll();
    Optional<Project> findById(Long id);
}
