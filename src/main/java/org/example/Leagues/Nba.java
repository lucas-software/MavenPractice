package org.example.Leagues;

public class Nba extends League{

    private String sport;
    private int numberOfTeams;

    public Nba(int id,String sport,int numberOfTeams) {
        super(id);
        this.sport = sport;
        this.numberOfTeams = 32;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    @Override
    public double totalSalary(){
        double cap = getNumberOfTeams()*300000000;
        return cap;
    }
}
