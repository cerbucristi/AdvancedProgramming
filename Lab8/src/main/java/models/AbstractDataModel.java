package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDataModel {

    protected int id;

    public abstract void loadObjectFromResultSet (ResultSet rs) throws SQLException;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
