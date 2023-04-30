package DAOClasses;

import Data.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreDAO {

    public void create(String name) throws SQLException {

        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                     "INSERT INTO genres (name) VALUES (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public String findById(int id) throws SQLException {
        String name = null;
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                     "SELECT * FROM genres WHERE id = ?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    name = rs.getString("name");
                }
            }
        }
        return name;
    }

    public Integer findByName(String name) throws SQLException {
        Integer id = null;
        Connection con = Database.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(
                     "SELECT id FROM genres WHERE name = ?")) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");
                }
            }
        }
        return id;
    }
}
