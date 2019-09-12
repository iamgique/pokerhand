package com.iamgique.pokerhand.rank;

import com.iamgique.pokerhand.kind.*;
import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class CompareCardRankTest {

    @Test
    public void highest_whenKindOfCardIsHighest(){
        Assert.assertEquals(CardRank.HIGHCARD.ordinal(), new CompareCardRank(new HighCard(), new Pair(),
                new TwoPair(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush())
                .getKindOfCard(new Card(Value._2, Suit.H), new Card(Value._5, Suit.S), new Card(Value._7, Suit.D),
                        new Card(Value._9, Suit.C), new Card(Value.T, Suit.H)));
    }

    @Test
    public void pair_whenKindOfCardIsPair(){
        Assert.assertEquals(CardRank.PAIR.ordinal(), new CompareCardRank(new HighCard(), new Pair(),
                new TwoPair(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush())
                .getKindOfCard(
                        new Card(Value._2, Suit.H),
                        new Card(Value._2, Suit.S),
                        new Card(Value._7, Suit.D),
                        new Card(Value._9, Suit.C),
                        new Card(Value.T, Suit.H)));
    }

    @Test
    public void twoPair_whenKindOfCardIsTwoPair(){
        Assert.assertEquals(CardRank.TWOPAIR.ordinal(), new CompareCardRank(new HighCard(), new Pair(),
                new TwoPair(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush())
                .getKindOfCard(new Card(Value._2, Suit.H),
                        new Card(Value._2, Suit.S),
                        new Card(Value._7, Suit.D),
                        new Card(Value._7, Suit.C),
                        new Card(Value.T, Suit.H)));
    }

    @Test
    public void threeOfAKind_whenKindOfCardIsThreeOfAKind(){
        Assert.assertEquals(CardRank.THREEOFAKIND.ordinal(), new CompareCardRank(new HighCard(), new Pair(),
                new TwoPair(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush())
                .getKindOfCard(new Card(Value._2, Suit.H),
                        new Card(Value._2, Suit.S),
                        new Card(Value._2, Suit.D),
                        new Card(Value._7, Suit.C),
                        new Card(Value.T, Suit.H)));
    }

    @Test
    public void straight_whenKindOfCardIsStraight(){
        Assert.assertEquals(CardRank.STRAIGHT.ordinal(), new CompareCardRank(new HighCard(), new Pair(),
                new TwoPair(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush())
                .getKindOfCard(new Card(Value._2, Suit.H),
                        new Card(Value._3, Suit.S),
                        new Card(Value._4, Suit.D),
                        new Card(Value._5, Suit.C),
                        new Card(Value._6, Suit.H)));
    }

    @Test
    public void flush_whenKindOfCardIsFlush(){
        Assert.assertEquals(CardRank.FLUSH.ordinal(), new CompareCardRank(new HighCard(), new Pair(),
                new TwoPair(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush())
                .getKindOfCard(new Card(Value._2, Suit.H),
                        new Card(Value._3, Suit.H),
                        new Card(Value._4, Suit.H),
                        new Card(Value._7, Suit.H),
                        new Card(Value.J, Suit.H)));
    }

    @Test
    public void fullHouse_whenKindOfCardIsFullHouse(){
        Assert.assertEquals(CardRank.FULLHOUSE.ordinal(), new CompareCardRank(new HighCard(), new Pair(),
                new TwoPair(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush())
                .getKindOfCard(new Card(Value._2, Suit.H),
                        new Card(Value._2, Suit.S),
                        new Card(Value._2, Suit.D),
                        new Card(Value._7, Suit.H),
                        new Card(Value._7, Suit.C)));
    }

    @Test
    public void fourOfAKind_whenKindOfCardIsFourOfAKind(){
        Assert.assertEquals(CardRank.FOUROFAKIND.ordinal(), new CompareCardRank(new HighCard(), new Pair(),
                new TwoPair(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush())
                .getKindOfCard(new Card(Value._4, Suit.H),
                        new Card(Value._4, Suit.D),
                        new Card(Value._4, Suit.C),
                        new Card(Value._4, Suit.S),
                        new Card(Value.J, Suit.H)));
    }

    @Test
    public void straightFlush_whenKindOfCardIsStraightFlush(){
        Assert.assertEquals(CardRank.STRAIGHTFLUSH.ordinal(), new CompareCardRank(new HighCard(), new Pair(),
                new TwoPair(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush())
                .getKindOfCard(new Card(Value._2, Suit.H),
                        new Card(Value._3, Suit.H),
                        new Card(Value._4, Suit.H),
                        new Card(Value._5, Suit.H),
                        new Card(Value._6, Suit.H)));
    }
}
