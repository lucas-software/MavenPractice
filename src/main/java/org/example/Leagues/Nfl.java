package org.example.Leagues;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class Nfl extends League{
    @XmlElement
    @JsonProperty("sport")
    private String sport;
    @XmlElement
    @JsonProperty("numberOfTeams")
    private int numberOfTeams;

    public Nfl(int id,String sport,int numberOfTeams) {
        super(id);
        this.sport = sport;
        this.numberOfTeams = numberOfTeams;
    }

    public Nfl(int id,String sport) {
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
        double cap = getNumberOfTeams()*100000000;
        return cap;
    }
}
