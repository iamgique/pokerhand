package com.iamgique.pokerhand.model;

public class Summary {
    private String player;
    private String rank;
    private String msg;

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return player != null ? player + " wins. - with " + rank + ": " + msg : "Tie.";
    }
}
