package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class ThreeOfKindTest {
    @Test
    public void threeOfKind_trueWhenCardValueRepeat3TimeAndNoPair() {
        ThreeOfKind threeOfKind = new ThreeOfKind(new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._2, Suit.D),
                new Card(Value.K, Suit.H),
                new Card(Value._5, Suit.C));
        Assert.assertEquals(CardRank.THREEOFAKIND.ordinal(), threeOfKind.kindOfCard());
    }

    @Test
    public void threeOfKind_falseWhenCardValueRepeat3TimeAndAPair() {
        ThreeOfKind threeOfKind = new ThreeOfKind(new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._2, Suit.D),
                new Card(Value.K, Suit.H),
                new Card(Value.K, Suit.C));
        Assert.assertEquals(CardRank.NOTMATCH.ordinal(), threeOfKind.kindOfCard());
    }

    @Test
    public void getThreeOfKindCard_returnCardValueNine() {
        ThreeOfKind threeOfKind = new ThreeOfKind(new Card(Value._9, Suit.H),
                new Card(Value._9, Suit.S),
                new Card(Value._9, Suit.D),
                new Card(Value.K, Suit.H),
                new Card(Value._5, Suit.C));
        Assert.assertEquals(Value._9, threeOfKind.getCardThreeOfKind());
    }

    @Test
    public void getThreeOfKindCard_returnCardValue() {
        ThreeOfKind threeOfKind = new ThreeOfKind(new Card(Value._9, Suit.H),
                new Card(Value.T, Suit.S),
                new Card(Value.T, Suit.D),
                new Card(Value.T, Suit.H),
                new Card(Value._5, Suit.C));
        Assert.assertEquals(Value.T, threeOfKind.getCardThreeOfKind());
    }
}
