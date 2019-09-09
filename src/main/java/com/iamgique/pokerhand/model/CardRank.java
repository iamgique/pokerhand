package com.iamgique.pokerhand.model;

public enum CardRank {
    NOTMATCH("not match"),
    DRAW("draw"),
    HIGHCARD("high card"),
    PAIR("pair"),
    TWOPAIR("two pairs"),
    THREEOFAKIND("three of a kind"),
    STRAIGHT("straight"),
    FLUSH("flush"),
    FULLHOUSE("full house"),
    FOUROFAKIND("four of a kind"),
    STRAIGHTFLUSH("straight flush");

    public static final CardRank values[] = values();

    private final String content;

    CardRank(String value) {
        content = value;
    }

    public String getContent() {
        return content;
    }
}
