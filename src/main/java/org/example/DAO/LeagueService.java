package org.example.DAO;

import org.example.Leagues.League;

import java.util.List;

public interface LeagueService {
    void createLeague(League league);
    League getLeagueById(int id);
    List<League> getAllLeagues();
    void updateLeague(League league);
    void deleteLeague(League league);
}
