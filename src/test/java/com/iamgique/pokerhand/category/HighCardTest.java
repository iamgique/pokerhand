package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class HighCardTest {
    @Test
    public void highCard_trueWhenCardHasNoDuplicatesOrSameSuit() {
        HighCard highCard = new HighCard();

        Assert.assertTrue(highCard.isHighCard(new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._9, Suit.C),
                new Card(Value.T, Suit.H)));
    }

    @Test
    public void highCard_falseWhenCardHasNoDuplicatesOrSameSuitAndTheCardMoreThanFive() {
        HighCard highCard = new HighCard();

        Assert.assertFalse(highCard.isHighCard(new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._9, Suit.C),
                new Card(Value.T, Suit.H),
                new Card(Value.J, Suit.H)));
    }
}
