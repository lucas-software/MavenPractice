package org.example.Teams;

public enum PlayType {
    PASS("Pass", 8.5),
    RUN("Run", 4.3),
    FIELD_GOAL("Field goal", 3.0),
    PUNT("Punt", 45.0);

    private final String description;
    private final double averageYards;

    PlayType(String description, double averageYards) {
        this.description = description;
        this.averageYards = averageYards;
    }

    public String getDescription() {
        return description;
    }

    public double getAverageYards() {
        return averageYards;
    }

    @Override
    public String toString() {
        return description + " (Average yardage: " + averageYards + ")";
    }
}

