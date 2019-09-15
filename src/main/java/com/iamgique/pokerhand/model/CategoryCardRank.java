package com.iamgique.pokerhand.model;

public enum CategoryCardRank {
    NOTMATCH("not match"),
    DRAW("draw"),
    HIGHCARD("high card"),
    PAIR("pair"),
    TWOPAIR("two pairs"),
    THREEOFAKIND("three of a category"),
    STRAIGHT("straight"),
    FLUSH("flush"),
    FULLHOUSE("full house"),
    FOUROFAKIND("four of a category"),
    STRAIGHTFLUSH("straight flush");

    public static final CategoryCardRank values[] = values();

    private final String content;

    CategoryCardRank(String value) {
        content = value;
    }

    public String getContent() {
        return content;
    }
}
