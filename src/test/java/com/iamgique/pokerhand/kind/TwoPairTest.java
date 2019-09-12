package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class TwoPairTest {
    @Test
    public void twoPair_trueWhenCardHasDuplicatesYwoTimes() {
        TwoPair twoPair = new TwoPair();
        Assert.assertTrue(twoPair.isTwoPairs(new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.K, Suit.D),
                new Card(Value.K, Suit.H),
                new Card(Value._5, Suit.C)));
    }
}
