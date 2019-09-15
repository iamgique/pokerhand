package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PairTest {
    @Test
    public void pair_trueWhenCardHasDuplicates() {
        Pair pair = new Pair();

        Assert.assertTrue(pair.isPair(new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.K, Suit.D),
                new Card(Value.K, Suit.H),
                new Card(Value._9, Suit.C)));
    }

    @Test
    public void returnQueen_whenQueenIsPairCard() {
        Pair pair = new Pair();

        Assert.assertEquals(Value.Q, pair.getPairCardValue(new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.Q, Suit.D),
                new Card(Value.Q, Suit.H),
                new Card(Value._9, Suit.C)));
    }

    @Test
    public void returnAce_whenQueenIsPairCard() {
        Pair pair = new Pair();

        Assert.assertEquals(Value.A, pair.getPairCardValue(new Card(Value._2, Suit.H),
                new Card(Value.A, Suit.S),
                new Card(Value.Q, Suit.D),
                new Card(Value.A, Suit.H),
                new Card(Value._9, Suit.C)));
    }

    @Test
    public void returnTwoThreeFive_whenTheseIsRemainingCard() {
        Pair pair = new Pair();

        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Value._2, Suit.H));
        cards.add(new Card(Value._3, Suit.S));
        cards.add(new Card(Value._5, Suit.D));
        cards.add(new Card(Value.Q, Suit.H));
        cards.add(new Card(Value.Q, Suit.C));

        List<Card> resp = new ArrayList<>();
        resp.add(new Card(Value._2, Suit.H));
        resp.add(new Card(Value._3, Suit.S));
        resp.add(new Card(Value._5, Suit.D));

        Assert.assertEquals(resp, pair.getRemainingCardOfPair(cards));
    }
}
