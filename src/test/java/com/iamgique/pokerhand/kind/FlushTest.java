package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class FlushTest {
    @Test
    public void flush_trueWhenAllCardsShareSameSuit() {
        Flush flush = new Flush(new Card(Value._5, Suit.D),
                new Card(Value._3, Suit.D),
                new Card(Value._4, Suit.D),
                new Card(Value.K, Suit.D),
                new Card(Value.J, Suit.D));
        Assert.assertEquals(CardRank.FLUSH.ordinal(), flush.kindOfCard());
    }

    @Test
    public void flush_falseWhenAllCardsShareNotSameSuit() {
        Flush flush = new Flush(new Card(Value._5, Suit.D),
                new Card(Value._3, Suit.D),
                new Card(Value._4, Suit.D),
                new Card(Value.K, Suit.C),
                new Card(Value.J, Suit.D));
        Assert.assertEquals(CardRank.NOTMATCH.ordinal(), flush.kindOfCard());
    }

}