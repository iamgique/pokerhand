package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class StraightTest {
    @Test
    public void straight_trueWhenCardIsInSequence() {
        Straight straight = new Straight();
        Assert.assertTrue(straight.isStraight(new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.S),
                new Card(Value._4, Suit.D),
                new Card(Value._5, Suit.C),
                new Card(Value._6, Suit.C)));
    }

    @Test
    public void straight_falseWhenCardIsNotSequence() {
        Straight straight = new Straight();

        Assert.assertFalse(straight.isStraight(new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.S),
                new Card(Value._4, Suit.D),
                new Card(Value._5, Suit.C),
                new Card(Value._7, Suit.C)));
    }
}
