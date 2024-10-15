package org.example.DAO;

import org.example.Leagues.League;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LeagueDAO extends AbstractDAO<League, Integer> {

    @Override
    protected League mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new League(rs.getInt("league_id"));
    }

    @Override
    protected String getTableName() {
        return "League";
    }

    @Override
    protected String getPrimaryKeyColumn() {
        return "league_id";
    }
}