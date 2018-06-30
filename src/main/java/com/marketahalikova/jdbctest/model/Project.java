package com.marketahalikova.jdbctest.model;

import java.util.List;

public class Project {

    private Long id;
    private String name;
    private String description;
    private String gitURL;
    private List<Font> listFonts;

    public Project() {
    }

    public Project(String name, String gitURL) {
        this.name = name;
        this.gitURL = gitURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGitURL() {
        return gitURL;
    }

    public void setGitURL(String gitURL) {
        this.gitURL = gitURL;
    }

    public List<Font> getListFonts() {
        return listFonts;
    }

    public void setListFonts(List<Font> listFonts) {
        this.listFonts = listFonts;
    }
}
