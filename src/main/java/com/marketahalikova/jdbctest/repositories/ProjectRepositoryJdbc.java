package com.marketahalikova.jdbctest.repositories;

import com.marketahalikova.jdbctest.database.Database;
import com.marketahalikova.jdbctest.model.Font;
import com.marketahalikova.jdbctest.model.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepositoryJdbc implements ProjectRepository {

    private FontRepository fontRepository;

    public ProjectRepositoryJdbc() throws SQLException {
        fontRepository = new FontRepositoryJdbc();
    }

    @Override
    public List<Project> findAll() throws SQLException {

        List<Project> projects = new ArrayList<>();
        ResultSet resultSet = Database.getInstance().select("SELECT * FROM project", new ArrayList<>());
        if (resultSet == null) {
            return null;
        }
        if (resultSet == null) {
            return projects;
        }
        while (resultSet.next()) {
            Project project = createProject(resultSet);
            projects.add(project);
        }
        return projects;
    }

    private Project createProject(ResultSet resultSet) throws SQLException {
        Project project = new Project();
        project.setId(resultSet.getLong("id"));
        project.setName(resultSet.getString("project_name"));
        project.setDescription(resultSet.getString("description"));
        project.setGitURL(resultSet.getString("url"));
        project.setListFonts(fontRepository.fontByProjectId(project.getId()));
        return project;
    }

    @Override
    public Optional<Project> findById(Long id) throws SQLException {

        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        ResultSet resultSet = Database.getInstance().select("SELECT * FROM project WHERE id = ?", params);
        if (resultSet == null) {
            return Optional.empty();
        }
        int count = 0;
        Project project = null;
        while (resultSet.next()) {

            if (count == 0) {
                project = createProject(resultSet);

            }
            count++;
        }
        if (count == 1) {
            return Optional.of(project);
        } else {
            return Optional.empty();
        }

    }


    @Override
    public int update(Project project) throws SQLException {

        String sql = "UPDATE project SET project_name=?, description=?, url=? WHERE id=?";
        List<String> params = new ArrayList<>();
        params.add(project.getName());
        params.add(project.getDescription());
        params.add(project.getGitURL());
        params.add(""+project.getId());

        Savepoint savepoint = Database.getInstance().getConnection().setSavepoint();

        int updatedProjectsCount = Database.getInstance().update(sql, params);
        if(updatedProjectsCount != 1){
            Database.getInstance().getConnection().rollback(savepoint);
            throw new SQLException("Attempted to update more projects at the same time ");
        }

        for(Font f : project.getListFonts()){
            if(fontRepository.updateFont(f)!=1){
                Database.getInstance().getConnection().rollback(savepoint);
                throw new SQLException("Attempted to update more projects at the same time ");
            }
        }

        Database.getInstance().getConnection().setAutoCommit(true);

        return updatedProjectsCount;
    }
}
