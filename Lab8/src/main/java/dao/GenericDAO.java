package dao;

import data.Database;
import enums.ModelToTable;
import models.AbstractDataModel;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<T extends AbstractDataModel> {

    public abstract void create(T entity) throws SQLException;

    public List<T> findAll(Class<T> tClass) throws SQLException {
        T model = null;
        Connection con = Database.getConnection();
        List<T> objects = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM "
                + ModelToTable.valueOf(tClass.getSimpleName().toLowerCase()).getTableName())) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    model = tClass.getDeclaredConstructor().newInstance();
                    model.loadObjectFromResultSet(rs);
                    objects.add(model);
                }
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            return objects;
        }
    }

    public List<T> findByName(Class<T> tClass, String name) throws SQLException {
        T model = null;
        Connection con = Database.getConnection();

        List<T> objects = new ArrayList<>();
        try (PreparedStatement pstmt = con.prepareStatement(
                "SELECT id FROM " + ModelToTable.valueOf(tClass.getSimpleName().toLowerCase()).getTableName() +" WHERE name = ?")) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    model = tClass.getDeclaredConstructor().newInstance();
                    model.loadObjectFromResultSet(rs);
                    objects.add(model);
                }
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return objects;
    }

    public T findById(Class<T> tClass, int id) throws SQLException {
        T model = null;
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "SELECT id FROM " + ModelToTable.valueOf(tClass.getSimpleName().toLowerCase()).getTableName() +" WHERE id = ?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    model = tClass.getDeclaredConstructor().newInstance();
                    model.loadObjectFromResultSet(rs);
                    return model;
                }
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
