package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class FullHouseTest {

    @Test
    public void fullHouse_trueWhenCardValueRepeat3TimeAndAPair() {
        FullHouse fullHouse = new FullHouse();
        Assert.assertTrue(fullHouse.isFullHouse(new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._2, Suit.D),
                new Card(Value.K, Suit.C),
                new Card(Value.K, Suit.D)));
    }

    @Test
    public void fullHouse_returnThreeAndAce_whenGetFullHouseValue() {
        FullHouse fullHouse = new FullHouse();
        String expect = "3 over Ace";

        StringBuffer resp = fullHouse.getFullHouseValueMsg(new Card(Value._3, Suit.H),
                new Card(Value._3, Suit.S),
                new Card(Value.A, Suit.D),
                new Card(Value.A, Suit.C),
                new Card(Value._3, Suit.D));

        Assert.assertEquals(expect,resp.toString());
    }
}
