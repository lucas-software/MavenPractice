package org.example.Teams;

public class Player{
    private int number;
    private String nationality;
    private String position;

    public Player(int number, String nationality, String position) {
        this.number = number;
        this.nationality = nationality;
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
