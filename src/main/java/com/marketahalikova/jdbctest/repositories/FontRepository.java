package com.marketahalikova.jdbctest.repositories;

import com.marketahalikova.jdbctest.model.Font;

import java.sql.SQLException;
import java.util.List;

public interface FontRepository {
    List<Font> fontByProjectId(Long id) throws SQLException;
    int updateFont(Font font) throws SQLException;
}
