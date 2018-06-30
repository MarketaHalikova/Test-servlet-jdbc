package com.marketahalikova.jdbctest.services;

import com.marketahalikova.jdbctest.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();
    Project findById(Long id);
}
