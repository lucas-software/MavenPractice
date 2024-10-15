package org.example.DAO;

import org.example.DAO.DAOFactory;
import org.example.DAO.LeagueDAO;
import org.example.DAO.StaffDAO;

public class MySQLDAOFactory implements DAOFactory {
    @Override
    public LeagueDAO getLeagueDAO() {
        return new LeagueDAO();
    }

    @Override
    public StaffDAO getStaffDAO() {
        return new StaffDAO();
    }
}
