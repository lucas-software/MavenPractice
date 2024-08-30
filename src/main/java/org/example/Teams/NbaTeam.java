package org.example.Teams;

public class NbaTeam extends Team{
    private int id;
    public NbaTeam(String name, Conference conference,int id) {
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
