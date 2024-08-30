package org.example.Teams;

public enum Conference {
    EAST("East"),
    WEST("West"),
    NORTH("North"),
    SOUTH("South");

    private String nome;

    Conference(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}