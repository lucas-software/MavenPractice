package org.example.Teams;

public enum GameOutcome {
    WIN("Victory", "Congratulations, your team won!"),
    LOSS("Defeat",  "Your team lost."),
    TIE("Draw", "The game ended in a draw.");

    private final String result;
    private final String message;

    GameOutcome(String result, String message) {
        this.result = result;
        this.message = message;
    }

    public String getResult() {
        return result;
    }


    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return result + " (Mensagem: " + message + ")";
    }
}
