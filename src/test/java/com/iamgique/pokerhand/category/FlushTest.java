package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class FlushTest {
    @Test
    public void flush_trueWhenAllCardsShareSameSuit() {
        Flush flush = new Flush();
        Assert.assertTrue(flush.isFlush(new Card(Value._5, Suit.D),
                new Card(Value._3, Suit.D),
                new Card(Value._4, Suit.D),
                new Card(Value.K, Suit.D),
                new Card(Value.J, Suit.D)));
    }

    @Test
    public void flush_falseWhenAllCardsShareNotSameSuit() {
        Flush flush = new Flush();
        Assert.assertFalse(flush.isFlush(new Card(Value._5, Suit.D),
                new Card(Value._3, Suit.D),
                new Card(Value._4, Suit.D),
                new Card(Value.K, Suit.C),
                new Card(Value.J, Suit.D)));
    }

}
