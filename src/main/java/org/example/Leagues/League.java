package org.example.Leagues;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
    public abstract class League {
    @XmlElement
    @JsonProperty("league_id")
    private int id;

    public League(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double totalSalary();

}
