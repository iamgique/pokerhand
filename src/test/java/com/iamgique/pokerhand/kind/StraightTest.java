package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class StraightTest {
    @Test
    public void straight_trueWhenCardIsInSequence() {
        Straight straight = new Straight(new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.S),
                new Card(Value._4, Suit.D),
                new Card(Value._5, Suit.C),
                new Card(Value._6, Suit.C));
        Assert.assertEquals(CardRank.STRAIGHT.ordinal(), straight.kindOfCard());
    }

    @Test
    public void straight_falseWhenCardIsNotSequence() {
        Straight straight = new Straight(new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.S),
                new Card(Value._4, Suit.D),
                new Card(Value._5, Suit.C),
                new Card(Value._7, Suit.C));

        Assert.assertEquals(CardRank.NOTMATCH.ordinal(), straight.kindOfCard());
    }
}
