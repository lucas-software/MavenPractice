package org.example.Teams;

public enum TeamType {
    OFFENSE("Offense"),
    DEFENSE("Defense"),
    SPECIAL_TEAMS("Special teams");

    private final String role;

    TeamType(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return  ("Role: " + role);
    }
}

