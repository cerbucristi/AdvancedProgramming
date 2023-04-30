package DAOClasses;

import Data.Database;

import java.sql.*;

public class ArtistDAO {

    public void create(String name) throws SQLException {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "INSERT INTO artists (name) VALUES (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Integer id = null;
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "SELECT id FROM artists WHERE name = ?")) {
            pstmt.setString(1, name);
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
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "SELECT name FROM artists WHERE id = ?")) {
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