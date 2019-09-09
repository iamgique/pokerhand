package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class StraightFlushTest {
    @Test
    public void straightFlush_trueWhenCardIsInSequenceAndShareSameSuit() {
        StraightFlush straightFlush = new StraightFlush(new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.H),
                new Card(Value._4, Suit.H),
                new Card(Value._5, Suit.H),
                new Card(Value._6, Suit.H));

        Assert.assertEquals(CardRank.STRAIGHTFLUSH.ordinal(), straightFlush.kindOfCard());
    }


}
