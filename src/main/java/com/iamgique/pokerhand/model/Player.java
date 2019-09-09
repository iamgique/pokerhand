package com.iamgique.pokerhand.model;

public enum Player {
    BLACK("Black"), WHITE("White");

    private final String content;

    Player(String value) {
        content = value;
    }

    public String getContent() {
        return content;
    }
}
