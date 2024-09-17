package org.example.Teams;

public enum Penalty {
    HOLDING("Holding", 10, false),
    OFFSIDE("Offside", 5, false),
    PASS_INTERFERENCE("Pass interference", 15, true),
    FACE_MASK("Facemask", 15, false);

    private final String description;
    private final int yardPenalty;
    private final boolean lossOfDown;

    Penalty(String description, int yardPenalty, boolean lossOfDown) {
        this.description = description;
        this.yardPenalty = yardPenalty;
        this.lossOfDown = lossOfDown;
    }

    public String getDescription() {
        return description;
    }

    public int getYardPenalty() {
        return yardPenalty;
    }

    public boolean isLossOfDown() {
        return lossOfDown;
    }

    @Override
    public String toString() {
        return description + " (Lost of " + yardPenalty + " yards, Lost of down: " + lossOfDown + ")";
    }
}

