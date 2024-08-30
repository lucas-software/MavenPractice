package org.example.Teams;

public class Team {

    private String name;
    private Conference conference;

    public Team(String name, Conference conference) {
        this.name = name;
        this.conference = conference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
