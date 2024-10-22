package org.example.Teams;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class NbaTeam extends Team{
    @XmlElement
    @JsonProperty("id")
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
