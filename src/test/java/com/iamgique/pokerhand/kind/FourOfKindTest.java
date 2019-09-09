package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class FourOfKindTest {
    @Test
    public void fourOfKind_trueWhenCardValueRepeat4Time() {
        FourOfKind fourOfKind = new FourOfKind(new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._2, Suit.D),
                new Card(Value._2, Suit.C),
                new Card(Value.K, Suit.C));
        Assert.assertEquals(CardRank.FOUROFAKIND.ordinal(), fourOfKind.kindOfCard());
    }
}
