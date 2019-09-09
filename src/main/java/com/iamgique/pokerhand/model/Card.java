package com.iamgique.pokerhand.model;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private final Value value;
    private final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(value, card.value) &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }

    @Override
    public int compareTo(Card o) {
        return this.value.compareTo(o.value);
    }
}
