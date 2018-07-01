package com.marketahalikova.jdbctest.services;

import com.marketahalikova.jdbctest.model.Font;
import com.marketahalikova.jdbctest.model.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<Project> findAll() {

        List<Project> projectList = new ArrayList<>();
        projectList.add(findById(11L).get());
        projectList.add(findById(22L).get());
        return projectList;
    }

    @Override
    public Optional<Project> findById(Long id) {

        Optional<Project> project = Optional.of(new Project("project" + id, "kimi.txt"));
        project.get().setId(id);
        Font font = new Font("helvetica");
        font.setProjectId(id);
        font.setId(5401653L);
        Font font2 = new Font("arial");
        font2.setProjectId(id);
        font2.setId(54018653L);
        project.get().getListFonts().add(font);
        project.get().getListFonts().add(font2);

        return project;
    }
}
