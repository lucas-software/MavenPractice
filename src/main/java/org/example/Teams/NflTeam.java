package org.example.Teams;

public class NflTeam extends Team{
    private int id;
    public NflTeam(String name, Conference conference,int id) {
        super(name, conference);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}