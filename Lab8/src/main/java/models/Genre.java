package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Genre extends AbstractDataModel{

    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    @Override
    public void loadObjectFromResultSet(ResultSet rs) throws SQLException {
        this.name = rs.getString("name");
    }

    @Override
    public String toString() {
        return "Genre{" +
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
