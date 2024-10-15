package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T, ID> implements GenericDAO<T, ID> {
    protected Connection getConnection() throws SQLException {
        return ConnectionPool.getDataSource().getConnection();
    }

    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;
    protected abstract String getTableName();
    protected abstract String getPrimaryKeyColumn();

    @Override
    public void create(T entity) {

    }

    @Override
    public T findById(ID id) {
        String query = "SELECT * FROM " + getTableName() + " WHERE " + getPrimaryKeyColumn() + " = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setObject(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEntity(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        String query = "SELECT * FROM " + getTableName();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                entities.add(mapResultSetToEntity(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {

    }
}