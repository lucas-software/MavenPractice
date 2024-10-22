package org.example.Teams;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Team {
    @XmlElement
    @JsonProperty("name")
    private String name;
    @XmlElement
    @JsonProperty("conference")
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
