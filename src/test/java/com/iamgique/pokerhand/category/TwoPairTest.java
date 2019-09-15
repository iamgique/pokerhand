package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void returnQueenAndNine_whenQueenAndNineAreTwoPairCard() {
        TwoPair twoPair = new TwoPair();
        List<Card> r = new ArrayList<>();
        r.add(new Card(Value.Q));
        r.add(new Card(Value._9));

        Assert.assertEquals(r, twoPair.getTwoPairCardHighestValue(new Card(Value._2, Suit.H),
                new Card(Value._9, Suit.S),
                new Card(Value.Q, Suit.D),
                new Card(Value.Q, Suit.H),
                new Card(Value._9, Suit.C)));
    }

    @Test
    public void returnKingAndQueen_whenKingAndQueenAreTwoPairCard() {
        TwoPair twoPair = new TwoPair();
        List<Card> r = new ArrayList<>();
        r.add(new Card(Value.K));
        r.add(new Card(Value.Q));

        Assert.assertEquals(r, twoPair.getTwoPairCardHighestValue(new Card(Value.A, Suit.H),
                new Card(Value.K, Suit.S),
                new Card(Value.Q, Suit.D),
                new Card(Value.Q, Suit.H),
                new Card(Value.K, Suit.C)));
    }

    @Test
    public void returnKing_whenKingIsRemainingCardOfTwoPair() {
        TwoPair twoPair = new TwoPair();
        List<Card> resp = new ArrayList<>();
        resp.add(new Card(Value.K));

        List<Card> req = new ArrayList<>();
        req.add(new Card(Value.A, Suit.H));
        req.add(new Card(Value.K, Suit.S));
        req.add(new Card(Value.A, Suit.D));
        req.add(new Card(Value.Q, Suit.H));
        req.add(new Card(Value.Q, Suit.C));

        Assert.assertEquals(resp.get(0).getValue(), twoPair.getHighestRemainingCardOfTwoPair(req).get(0).getValue());
    }
}
