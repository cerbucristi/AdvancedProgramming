package DAOClasses;

import Data.Database;
import org.postgresql.jdbc.PgArray;

import java.sql.*;

public class AlbumDAO {

    public void create(int year, String title, String artist, String... genres ) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year, title, artist, genres) values (?,?,?,?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2,title);
            pstmt.setString(3,artist);
            pstmt.setArray(4, con.createArrayOf("VARCHAR", genres));

            pstmt.executeUpdate();
        }
    }

    public Integer findByTitle(String title) throws SQLException {
        Integer id = null;
        Connection con = Database.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(
                "SELECT id FROM albums WHERE name = ?")) {
            pstmt.setString(1, title);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");
                }
            }
        }
        return id;
    }

    public String findById(int id) throws SQLException {
        String name = null;
        Connection con = Database.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(
                "SELECT name FROM albums WHERE id = ?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    name = rs.getString("name");
                }
            }
        }
        return name;
    }
}
