package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Artist extends AbstractDataModel{

    private String name;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    @Override
    public void loadObjectFromResultSet(ResultSet rs) throws SQLException {
        this.name = rs.getString("name");
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
