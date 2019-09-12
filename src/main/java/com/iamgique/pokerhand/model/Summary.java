package com.iamgique.pokerhand.model;

public class Summary {
    private String player;
    private String rank;
    private String card;

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return player != null ? player + " wins. - with " + rank + ": " + card : "Tie.";
    }
}
