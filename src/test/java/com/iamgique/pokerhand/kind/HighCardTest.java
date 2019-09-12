package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class HighCardTest {
    @Test
    public void highCard_trueWhenCardHasNoDuplicatesOrSameSuit() {
        HighCard highCard = new HighCard(new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._9, Suit.C),
                new Card(Value.T, Suit.H));

        Assert.assertEquals(CardRank.HIGHCARD.ordinal(), highCard.kindOfCard());
    }

    @Test
    public void highCard_falseWhenCardHasNoDuplicatesOrSameSuitAndTheCardMoreThanFive() {
        HighCard highCard = new HighCard(new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._9, Suit.C),
                new Card(Value.T, Suit.H),
                new Card(Value.J, Suit.H));

        Assert.assertEquals(CardRank.NOTMATCH.ordinal(), highCard.kindOfCard());
    }
}
