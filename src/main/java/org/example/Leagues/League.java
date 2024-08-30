package org.example.Leagues;
public abstract class League {
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
