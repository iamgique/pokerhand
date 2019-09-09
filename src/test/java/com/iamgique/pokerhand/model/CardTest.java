package com.iamgique.pokerhand.model;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    public void createNewCard() {
        Card card = new Card(Value._2, Suit.H);
        Assert.assertEquals(Value._2, card.getValue());
        Assert.assertEquals(Suit.H, card.getSuit());
    }

    @Test
    public void comparingCard() {
        Card b = new Card(Value._3, Suit.H);
        Card a = new Card(Value._2, Suit.H);

        Assert.assertTrue(b.compareTo(a) > 0);
    }

    @Test
    public void comparingCard_2() {
        Card a = new Card(Value.T, Suit.H);
        Card b = new Card(Value.A, Suit.H);

        Assert.assertTrue(b.compareTo(a) > 0);
    }
}
