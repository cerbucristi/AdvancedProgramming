package dao;

import data.DatabaseHikari;
import models.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenreDAO extends GenericDAO<Genre> {
    @Override
    public void create(Genre entity) throws SQLException {
        Connection con = DatabaseHikari.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                     "INSERT INTO genres (name) VALUES (?)")) {
            pstmt.setString(1, entity.getName());
            pstmt.executeUpdate();
        }
    }
}
