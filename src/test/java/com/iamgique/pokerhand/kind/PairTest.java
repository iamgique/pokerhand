package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

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
}
