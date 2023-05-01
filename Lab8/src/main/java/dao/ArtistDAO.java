package dao;

import data.DatabaseHikari;
import models.Artist;

import java.sql.*;

public class ArtistDAO extends GenericDAO<Artist> {
    @Override
    public void create(Artist entity) throws SQLException {

        Connection con = DatabaseHikari.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, entity.getName());
            pstmt.executeUpdate();
        }
    }
}