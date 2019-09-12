package com.iamgique.pokerhand.rank;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    public void highCard_getHighestCard() {
        Assert.assertEquals(new Card(Value.T, Suit.H), Rank.getHighestCard(0, new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value.T, Suit.H),
                new Card(Value._9, Suit.C)));
    }

    @Test
    public void getThreeOfKindCard_returnCardValueNine() {
        Assert.assertEquals(Value._9, Rank.getHighestCardOnThreeCardSame(new Card(Value._9, Suit.H),
                new Card(Value._9, Suit.S),
                new Card(Value._9, Suit.D),
                new Card(Value.K, Suit.H),
                new Card(Value._5, Suit.C)));
    }

    @Test
    public void getThreeOfKindCard_returnCardValue() {
        Assert.assertEquals(Value.T, Rank.getHighestCardOnThreeCardSame(new Card(Value._9, Suit.H),
                new Card(Value.T, Suit.S),
                new Card(Value.T, Suit.D),
                new Card(Value.T, Suit.H),
                new Card(Value._5, Suit.C)));
    }
}
