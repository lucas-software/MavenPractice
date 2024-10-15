package org.example.DAO;

import org.example.DAO.GenericDAO;
import org.example.DAO.LeagueDAO;
import org.example.DAO.LeagueService;
import org.example.Leagues.League;

import java.util.List;

public class LeagueServiceImpl implements LeagueService {
    private final GenericDAO<League, Integer> leagueDAO;

    public LeagueServiceImpl(LeagueDAO leagueDAO) {
        this.leagueDAO = leagueDAO;
    }

    @Override
    public void createLeague(League league) {
        leagueDAO.create(league);
    }

    @Override
    public League getLeagueById(int id) {
        return leagueDAO.findById(id);
    }

    @Override
    public List<League> getAllLeagues() {
        return leagueDAO.findAll();
    }

    @Override
    public void updateLeague(League league) {
        leagueDAO.update(league);
    }

    @Override
    public void deleteLeague(League league) {
        leagueDAO.delete(league);
    }
}

