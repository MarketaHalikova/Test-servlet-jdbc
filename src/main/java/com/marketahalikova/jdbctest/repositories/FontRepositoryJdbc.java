package com.marketahalikova.jdbctest.repositories;

import com.marketahalikova.jdbctest.database.Database;
import com.marketahalikova.jdbctest.model.Font;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FontRepositoryJdbc implements FontRepository {



    @Override
    public List<Font> fontByProjectId(Long id) throws SQLException {
        List<String> params = new ArrayList<>();
        List<Font> fonts = new ArrayList<>();
        params.add(String.valueOf(id));
        ResultSet resultSet = Database.getInstance().select("SELECT * FROM font WHERE project_id = ?", params);
        if (resultSet == null) {
            return fonts;
        }
        int count = 0;
        Font font = null;
        while (resultSet.next()) {
            font = createFont(resultSet);
            fonts.add(font);
        }
        return fonts;
    }

    @Override
    public int updateFont(Font font) throws SQLException {
        String sql = "UPDATE font SET font_name=?, project_id=? WHERE id=?";
        List<String> params = new ArrayList<>();
        params.add(font.getFontName());
        params.add(""+font.getProjectId());
        params.add(""+font.getId());
        int updatedFontsCount = Database.getInstance().update(sql, params);
        return updatedFontsCount;
    }

    private Font createFont (ResultSet resultSet) throws SQLException {
            Font font = new Font();
            font.setId(resultSet.getLong("id"));
            font.setFontName(resultSet.getString("font_name"));
            font.setProjectId(resultSet.getLong("project_id"));
            return font;
        }

    }
