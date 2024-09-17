package org.example.Teams;

public enum Position {
    QUARTERBACK("Quarterback", 5),
    RUNNING_BACK("Running Back", 4),
    WIDE_RECEIVER("Wide Receiver", 3),
    LINEBACKER("Linebacker", 2),
    KICKER("Kicker", 1);

    private final String role;
    private final int popularity;

    Position(String role, int popularity) {
        this.role = role;
        this.popularity = popularity;
    }

    public String getRole() {
        return role;
    }

    public int getPopularity() {
        return popularity;
    }

    @Override
    public String toString() {
        return name() + " ( Popularity: " + popularity + ")";
    }
}
