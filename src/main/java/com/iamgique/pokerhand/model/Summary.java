package com.iamgique.pokerhand.model;

public class Summary {
    private String player;
    private String rank;
    private String card;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return player + " wins. - with " + rank + ": " + card;
    }
}
