package org.example.Teams;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
@XmlRootElement
public class NflTeam extends Team{
    @XmlElement
    @JsonProperty("id")
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