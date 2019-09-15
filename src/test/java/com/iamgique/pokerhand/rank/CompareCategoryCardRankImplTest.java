package com.iamgique.pokerhand.rank;

import com.iamgique.pokerhand.category.*;
import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CategoryCardRank;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompareCategoryCardRankImplTest {
    CompareCardRank compareCardRank;

    @BeforeEach
    public void setUp(){
        compareCardRank = new CompareCardRankImpl(new HighCard(), new Pair(),
                new TwoPair(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush()) {
        };
    }


    @Test
    public void highest_whenKindOfCardIsHighest(){
        Assert.assertEquals(CategoryCardRank.HIGHCARD.ordinal(),
                compareCardRank.getCategoryOfCard(new Card(Value._2, Suit.H), new Card(Value._5, Suit.S),
                        new Card(Value._7, Suit.D), new Card(Value._9, Suit.C), new Card(Value.T, Suit.H)));
    }

    @Test
    public void pair_whenKindOfCardIsPair(){
        Assert.assertEquals(CategoryCardRank.PAIR.ordinal(), compareCardRank.getCategoryOfCard(
                new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._9, Suit.C),
                new Card(Value.T, Suit.H)));
    }

    @Test
    public void twoPair_whenKindOfCardIsTwoPair(){
        Assert.assertEquals(CategoryCardRank.TWOPAIR.ordinal(), compareCardRank.getCategoryOfCard(
                new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._7, Suit.C),
                new Card(Value.T, Suit.H)));
    }

    @Test
    public void threeOfAKind_whenKindOfCardIsThreeOfAKind(){
        Assert.assertEquals(CategoryCardRank.THREEOFAKIND.ordinal(), compareCardRank.getCategoryOfCard(
                new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._2, Suit.D),
                new Card(Value._7, Suit.C),
                new Card(Value.T, Suit.H)));
    }

    @Test
    public void straight_whenKindOfCardIsStraight(){
        Assert.assertEquals(CategoryCardRank.STRAIGHT.ordinal(), compareCardRank.getCategoryOfCard(
                new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.S),
                new Card(Value._4, Suit.D),
                new Card(Value._5, Suit.C),
                new Card(Value._6, Suit.H)));
    }

    @Test
    public void flush_whenKindOfCardIsFlush(){
        Assert.assertEquals(CategoryCardRank.FLUSH.ordinal(), compareCardRank.getCategoryOfCard(
                new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.H),
                new Card(Value._4, Suit.H),
                new Card(Value._7, Suit.H),
                new Card(Value.J, Suit.H)));
    }

    @Test
    public void fullHouse_whenKindOfCardIsFullHouse(){
        Assert.assertEquals(CategoryCardRank.FULLHOUSE.ordinal(), compareCardRank.getCategoryOfCard(
                new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._2, Suit.D),
                new Card(Value._7, Suit.H),
                new Card(Value._7, Suit.C)));
    }

    @Test
    public void fourOfAKind_whenKindOfCardIsFourOfAKind(){
        Assert.assertEquals(CategoryCardRank.FOUROFAKIND.ordinal(), compareCardRank.getCategoryOfCard(
                new Card(Value._4, Suit.H),
                new Card(Value._4, Suit.D),
                new Card(Value._4, Suit.C),
                new Card(Value._4, Suit.S),
                new Card(Value.J, Suit.H)));
    }

    @Test
    public void straightFlush_whenKindOfCardIsStraightFlush(){
        Assert.assertEquals(CategoryCardRank.STRAIGHTFLUSH.ordinal(), compareCardRank.getCategoryOfCard(
                new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.H),
                new Card(Value._4, Suit.H),
                new Card(Value._5, Suit.H),
                new Card(Value._6, Suit.H)));
    }

    @Test
    public void highCard_getHighestCard() {
        Assert.assertEquals(new Card(Value.T, Suit.H),
                compareCardRank.getHighestCard(0,
                        new Card(Value._2, Suit.H),
                        new Card(Value._5, Suit.S),
                        new Card(Value._7, Suit.D),
                        new Card(Value.T, Suit.H),
                        new Card(Value._9, Suit.C)));
    }

    @Test
    public void getThreeOfKindCard_returnCardValueNine() {
        Assert.assertEquals(Value._9, compareCardRank.getMaxDuplicateCard(
                new Card(Value._9, Suit.H),
                new Card(Value._9, Suit.S),
                new Card(Value._9, Suit.D),
                new Card(Value.K, Suit.H),
                new Card(Value._5, Suit.C)));
    }

    @Test
    public void getThreeOfKindCard_returnCardValue() {
        Assert.assertEquals(Value.T, compareCardRank.getMaxDuplicateCard(
                new Card(Value._9, Suit.H),
                new Card(Value.T, Suit.S),
                new Card(Value.T, Suit.D),
                new Card(Value.T, Suit.H),
                new Card(Value._5, Suit.C)));
    }
}
