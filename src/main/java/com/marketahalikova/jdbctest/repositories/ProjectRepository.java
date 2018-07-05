package com.marketahalikova.jdbctest.repositories;

import com.marketahalikova.jdbctest.model.Project;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    List<Project> findAll() throws SQLException;
    Optional<Project> findById(Long id) throws SQLException;
    int update(Project project) throws SQLException;

}
