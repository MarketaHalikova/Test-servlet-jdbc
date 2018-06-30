package com.marketahalikova.jdbctest.services;

import com.marketahalikova.jdbctest.model.Font;
import com.marketahalikova.jdbctest.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<Project> findAll() {

        List<Project> projectList = new ArrayList<>();
        projectList.add(findById(11L));
        projectList.add(findById(22L));
        return projectList;
    }

    @Override
    public Project findById(Long id) {

        Project project = new Project("project" + id, "kimi.txt");
        project.setId(id);
        Font font = new Font("helvetica");
        font.setProjectId(id);
        font.setId(5401653L);
        Font font2 = new Font("arial");
        font2.setProjectId(id);
        font2.setId(54018653L);
        project.getListFonts().add(font);
        project.getListFonts().add(font2);

        return project;
    }
}
