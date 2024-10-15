package org.example.DAO;

import org.example.Staffers.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDAO extends AbstractDAO<Staff, Integer> {

    @Override
    protected Staff mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Staff(rs.getInt("staff_id"));
    }

    @Override
    protected String getTableName() {
        return "Staff";
    }

    @Override
    protected String getPrimaryKeyColumn() {
        return "staff_id";
    }
}