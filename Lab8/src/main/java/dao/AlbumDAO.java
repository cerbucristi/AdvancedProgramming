package dao;

import data.Database;
import models.Album;

import java.sql.*;


public class AlbumDAO extends GenericDAO<Album>{
    @Override
    public void create(Album entity) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year, title, artist, genres) values (?,?,?,?)")) {
            pstmt.setInt(1, entity.getReleaseYear());
            pstmt.setString(2,entity.getTitle());
            pstmt.setString(3, entity.getArtist());
            pstmt.setArray(4, con.createArrayOf("VARCHAR", entity.getGenreNames().toArray()));

            pstmt.executeUpdate();
        }
    }
}
