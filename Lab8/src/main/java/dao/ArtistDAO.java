package dao;

import data.Database;
import models.Artist;

import java.sql.*;

public class ArtistDAO extends GenericDAO<Artist> {
    @Override
    public void create(Artist entity) throws SQLException {

        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, entity.getName());
            pstmt.executeUpdate();
        }
    }
}