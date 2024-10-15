package org.example.DAO;

import org.example.DAO.LeagueDAO;
import org.example.DAO.StaffDAO;

public interface DAOFactory {
    LeagueDAO getLeagueDAO();
    StaffDAO getStaffDAO();
}
