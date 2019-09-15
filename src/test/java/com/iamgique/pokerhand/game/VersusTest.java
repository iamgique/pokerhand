package com.iamgique.pokerhand.game;

import com.iamgique.pokerhand.kind.*;
import com.iamgique.pokerhand.model.*;
import com.iamgique.pokerhand.rank.CompareCardRank;
import com.iamgique.pokerhand.rank.CompareCardRankImpl;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class VersusTest {
    CompareCardRank compareCardRank;

    @BeforeEach
    public void setUp(){
        compareCardRank = new CompareCardRankImpl(new HighCard(), new Pair(),
                new TwoPair(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush()) {
        };
    }

    @Test
    public void versusSameKind_whiteWinWhenWhiteHandHasAceCardIsHighest() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._9, Suit.C),
                new Card(Value.T, Suit.H));
        List<Card> white = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._9, Suit.C),
                new Card(Value.A, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("White wins. - with high card: Ace", versus.versus());
    }

    @Test
    public void versusSameKind_blackWinWhenBlackHandHasNineCardIsHighest() {
        List<Card> black = asList(
                new Card(Value._2, Suit.C),
                new Card(Value._5, Suit.D),
                new Card(Value._7, Suit.S),
                new Card(Value._9, Suit.C),
                new Card(Value._3, Suit.C));
        List<Card> white = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._8, Suit.C),
                new Card(Value._3, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("Black wins. - with high card: 9", versus.versus());
    }

    @Test
    public void versusSameKind_TieWhenEveryoneHasHighestCard() {
        List<Card> black = asList(
                new Card(Value._2, Suit.C),
                new Card(Value._5, Suit.D),
                new Card(Value._7, Suit.S),
                new Card(Value._9, Suit.C),
                new Card(Value._3, Suit.C));
        List<Card> white = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._9, Suit.S),
                new Card(Value._3, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("Tie.", versus.versus());
    }

    @Test
    public void versusSameKind_WhiteWin_playerBlackAndWhiteHasSameHighCard_whiteHasNineCardIsHighest() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._8, Suit.C),
                new Card(Value.T, Suit.H));
        List<Card> white = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._9, Suit.C),
                new Card(Value.T, Suit.C));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("White wins. - with high card: 9", versus.versus());
    }

    @Test
    public void versusSameKind_blackWin_playerBlackAndWhiteHasSameHighCardTwoTimes_BlackHasEightCardIsHighest() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value.J, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._8, Suit.C),
                new Card(Value.Q, Suit.H));
        List<Card> white = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value.J, Suit.C),
                new Card(Value.Q, Suit.C));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("Black wins. - with high card: 8", versus.versus());
    }

    @Test
    public void versusSameKind_WhiteWin_blackAndWhiteHasPair_playerWhiteHasJackCardIsHighest() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.Q, Suit.D),
                new Card(Value.Q, Suit.C),
                new Card(Value.T, Suit.H));
        List<Card> white = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.Q, Suit.S),
                new Card(Value.Q, Suit.H),
                new Card(Value.J, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("White wins. - with pair: Jack", versus.versus());
    }

    @Test
    public void versusSameKind_WhiteWin_blackAndWhiteHasPair_playerWhiteHasJackIsPairCardAreHighest() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.Q, Suit.D),
                new Card(Value.T, Suit.C),
                new Card(Value.T, Suit.H));
        List<Card> white = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.Q, Suit.S),
                new Card(Value.J, Suit.H),
                new Card(Value.J, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("White wins. - with pair: Jack", versus.versus());
    }

    @Test
    public void versusNotSameKind_WhiteWin_WhiteHasPairIsHigherThanBlack() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.J, Suit.D),
                new Card(Value.Q, Suit.C),
                new Card(Value.T, Suit.H));
        List<Card> white = asList(
                new Card(Value.A, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.Q, Suit.S),
                new Card(Value.Q, Suit.H),
                new Card(Value.K, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("White wins. - with pair: Queen", versus.versus());
    }

    @Test
    public void versusNotSameKind_WhiteWin_WhiteHasTwoPairIsHigherThanBlack() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.J, Suit.D),
                new Card(Value.Q, Suit.C),
                new Card(Value.T, Suit.H));
        List<Card> white = asList(
                new Card(Value.A, Suit.H),
                new Card(Value._7, Suit.S),
                new Card(Value._7, Suit.S),
                new Card(Value._8, Suit.H),
                new Card(Value._8, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("White wins. - with two pairs: 8", versus.versus());
    }

    @Test
    public void versusNotSameKind_BlackWin_BlackHasStraightIsHigherThanWhite() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.S),
                new Card(Value._4, Suit.D),
                new Card(Value._5, Suit.C),
                new Card(Value._6, Suit.H));
        List<Card> white = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.Q, Suit.S),
                new Card(Value.Q, Suit.H),
                new Card(Value.J, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("Black wins. - with straight: 6", versus.versus());
    }

    @Test
    public void versusNotSameKind_WhiteWin_WhiteHasThreeOfAKindIsHigherThanBlack() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.J, Suit.D),
                new Card(Value.K, Suit.C),
                new Card(Value.K, Suit.H));
        List<Card> white = asList(
                new Card(Value._2, Suit.H),
                new Card(Value.Q, Suit.C),
                new Card(Value.Q, Suit.S),
                new Card(Value.Q, Suit.H),
                new Card(Value.J, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("White wins. - with three of a kind: Queen", versus.versus());
    }

    @Test
    public void versusSameKind_blackWin_blackAndWhiteHasTwoPair_playerBlackHasJackCardIsTwoPairNumberTwo() {
        List<Card> black = asList(
                new Card(Value.J, Suit.H),
                new Card(Value.J, Suit.S),
                new Card(Value.A, Suit.D),
                new Card(Value.Q, Suit.C),
                new Card(Value.Q, Suit.H));
        List<Card> white = asList(
                new Card(Value._9, Suit.H),
                new Card(Value._9, Suit.C),
                new Card(Value.Q, Suit.S),
                new Card(Value.Q, Suit.D),
                new Card(Value.J, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("Black wins. - with two pairs: Jack", versus.versus());
    }

    @Test
    public void versusSameKind_blackWin_blackAndWhiteHasTwoPair_playerBlackHasKingCardIsHighest() {
        List<Card> black = asList(
                new Card(Value.K, Suit.H),
                new Card(Value.A, Suit.S),
                new Card(Value.A, Suit.D),
                new Card(Value.Q, Suit.C),
                new Card(Value.Q, Suit.H));
        List<Card> white = asList(
                new Card(Value.A, Suit.H),
                new Card(Value.A, Suit.C),
                new Card(Value.Q, Suit.S),
                new Card(Value.Q, Suit.D),
                new Card(Value.J, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("Black wins. - with two pairs: King", versus.versus());
    }

    @Test
    public void versusSameKind_blackWin_blackAndWhiteHasThreeOfAKind_playerBlackHasKingCardIsHighest() {
        List<Card> black = asList(
                new Card(Value.K, Suit.H),
                new Card(Value.K, Suit.S),
                new Card(Value.A, Suit.D),
                new Card(Value.K, Suit.C),
                new Card(Value.Q, Suit.H));
        List<Card> white = asList(
                new Card(Value.A, Suit.H),
                new Card(Value.A, Suit.C),
                new Card(Value.A, Suit.S),
                new Card(Value.Q, Suit.D),
                new Card(Value.J, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("White wins. - with three of a kind: Ace", versus.versus());
    }

    @Test
    public void versusSameKind_blackWin_blackAndWhiteHasStraight_playerBlackHasAceCardIsHighest() {
        List<Card> black = asList(
                new Card(Value.T, Suit.H),
                new Card(Value.J, Suit.S),
                new Card(Value.Q, Suit.D),
                new Card(Value.K, Suit.C),
                new Card(Value.A, Suit.H));
        List<Card> white = asList(
                new Card(Value._9, Suit.H),
                new Card(Value.T, Suit.C),
                new Card(Value.J, Suit.S),
                new Card(Value.Q, Suit.D),
                new Card(Value.K, Suit.H));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("Black wins. - with straight: Ace", versus.versus());
    }

    @Test
    public void versusSameKind_blackWin_blackAndWhiteHasFlush_playerBlackHasQueenCardIsHighest() {
        List<Card> black = asList(
                new Card(Value.T, Suit.H),
                new Card(Value._6, Suit.H),
                new Card(Value._7, Suit.H),
                new Card(Value._2, Suit.H),
                new Card(Value.Q, Suit.H));
        List<Card> white = asList(
                new Card(Value._9, Suit.C),
                new Card(Value.T, Suit.C),
                new Card(Value.J, Suit.C),
                new Card(Value._2, Suit.C),
                new Card(Value._6, Suit.C));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("Black wins. - with flush: Queen", versus.versus());
    }

    @Test
    public void versusSameKind_WhiteWin_blackAndWhiteHasFullHouse_playerWhiteHasJackCardIsHighest() {
        List<Card> black = asList(
                new Card(Value._2, Suit.D),
                new Card(Value.T, Suit.H),
                new Card(Value.T, Suit.C),
                new Card(Value._2, Suit.H),
                new Card(Value.T, Suit.S));
        List<Card> white = asList(
                new Card(Value._9, Suit.S),
                new Card(Value._9, Suit.C),
                new Card(Value.J, Suit.C),
                new Card(Value.J, Suit.H),
                new Card(Value.J, Suit.S));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("White wins. - with full house: Jack", versus.versus());
    }

    @Test
    public void versusSameKind_WhiteWin_blackAndWhiteHasFourOfAKind_playerWhiteHasJackCardIsHighest() {
        List<Card> black = asList(
                new Card(Value._2, Suit.D),
                new Card(Value.T, Suit.H),
                new Card(Value.T, Suit.C),
                new Card(Value.T, Suit.D),
                new Card(Value.T, Suit.S));
        List<Card> white = asList(
                new Card(Value._9, Suit.S),
                new Card(Value.J, Suit.C),
                new Card(Value.J, Suit.D),
                new Card(Value.J, Suit.H),
                new Card(Value.J, Suit.S));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("White wins. - with four of a kind: Jack", versus.versus());
    }

    @Test
    public void versusSameKind_WhiteWin_blackAndWhiteHasStraightFlush_playerWhiteHasQueenCardIsHighest() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.H),
                new Card(Value._4, Suit.H),
                new Card(Value._5, Suit.H),
                new Card(Value._6, Suit.H));
        List<Card> white = asList(
                new Card(Value._8, Suit.S),
                new Card(Value._9, Suit.S),
                new Card(Value.T, Suit.S),
                new Card(Value.J, Suit.S),
                new Card(Value.Q, Suit.S));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("White wins. - with straight flush: Queen", versus.versus());
    }

    @Test
    public void versusSameKind_Tie_blackAndWhiteHasStraightFlush_everyoneHasHighestCard() {
        List<Card> black = asList(
                new Card(Value._8, Suit.H),
                new Card(Value._9, Suit.H),
                new Card(Value.T, Suit.H),
                new Card(Value.J, Suit.H),
                new Card(Value.Q, Suit.H));
        List<Card> white = asList(
                new Card(Value._8, Suit.S),
                new Card(Value._9, Suit.S),
                new Card(Value.T, Suit.S),
                new Card(Value.J, Suit.S),
                new Card(Value.Q, Suit.S));
        Versus versus = new Versus(black, white, this.compareCardRank);
        Assert.assertEquals("Tie.", versus.versus());
    }

}
