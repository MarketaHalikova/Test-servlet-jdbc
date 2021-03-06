package com.marketahalikova.jdbctest.services;

import com.marketahalikova.jdbctest.model.Project;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<Project> findAll() throws SQLException;
    Optional<Project> findById(Long id) throws SQLException;
}
