package org.example.DAO;

import org.example.DAO.DAOFactory;
import org.example.DAO.LeagueService;
import org.example.DAO.LeagueServiceImpl;

public class ServiceFactory {
    public static LeagueService getLeagueService(DAOFactory daoFactory) {
        return new LeagueServiceImpl(daoFactory.getLeagueDAO());
    }
}
