package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class FullHouseTest {

    @Test
    public void fullHouse_trueWhenCardValueRepeat3TimeAndAPair() {
        FullHouse fullHouse = new FullHouse(new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._2, Suit.D),
                new Card(Value.K, Suit.C),
                new Card(Value.K, Suit.D));
        Assert.assertEquals(CardRank.FULLHOUSE.ordinal(), fullHouse.kindOfCard());
    }
}