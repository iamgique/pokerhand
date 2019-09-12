package com.iamgique.pokerhand.game;

import com.iamgique.pokerhand.kind.Kind;
import com.iamgique.pokerhand.model.*;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class VersusTest {
    Kind kind;
    List<Card> black;
    List<Card> white;

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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
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
                new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value.Q, Suit.S),
                new Card(Value.Q, Suit.H),
                new Card(Value.J, Suit.H));
        Versus versus = new Versus(black, white, this.kind);
        Assert.assertEquals("White wins. - with pair: Jack", versus.versus());
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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
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
        Versus versus = new Versus(black, white, this.kind);
        Assert.assertEquals("Tie.", versus.versus());
    }

    @Test
    public void highCard_getKindOfCard(){
        Versus versus = new Versus(this.black, this.white, this.kind);
        Assert.assertEquals(CardRank.HIGHCARD.ordinal(), versus.getKindOfCard(new Card(Value._2, Suit.H),
                new Card(Value._5, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._8, Suit.C),
                new Card(Value._3, Suit.H)));
    }

    @Test
    public void pair_getKindOfCard(){
        Versus versus = new Versus(this.black, this.white, this.kind);
        Assert.assertEquals(CardRank.PAIR.ordinal(), versus.getKindOfCard(new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._8, Suit.C),
                new Card(Value._3, Suit.H)));
    }

    @Test
    public void twoPairs_getKindOfCard(){
        Versus versus = new Versus(this.black, this.white, this.kind);
        Assert.assertEquals(CardRank.TWOPAIR.ordinal(), versus.getKindOfCard(new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._7, Suit.C),
                new Card(Value._3, Suit.H)));
    }

    @Test
    public void threeOfAKind_getKindOfCard(){
        Versus versus = new Versus(this.white, this.black, this.kind);
        Assert.assertEquals(CardRank.THREEOFAKIND.ordinal(), versus.getKindOfCard(new Card(Value._2, Suit.H),
                new Card(Value._7, Suit.S),
                new Card(Value._7, Suit.D),
                new Card(Value._7, Suit.C),
                new Card(Value._3, Suit.H)));
    }

    @Test
    public void straight_getKindOfCard(){
        Versus versus = new Versus(this.black, this.white, this.kind);
        Assert.assertEquals(CardRank.STRAIGHT.ordinal(), versus.getKindOfCard(new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.S),
                new Card(Value._4, Suit.D),
                new Card(Value._5, Suit.C),
                new Card(Value._6, Suit.C)));
    }

    @Test
    public void flush_getKindOfCard(){
        Versus versus = new Versus(this.black, this.white, this.kind);
        Assert.assertEquals(CardRank.FLUSH.ordinal(), versus.getKindOfCard(new Card(Value._5, Suit.D),
                new Card(Value._3, Suit.D),
                new Card(Value._4, Suit.D),
                new Card(Value.K, Suit.D),
                new Card(Value.J, Suit.D)));
    }

    @Test
    public void fullhouse_getKindOfCard(){
        Versus versus = new Versus(this.black, this.white, this.kind);
        Assert.assertEquals(CardRank.FULLHOUSE.ordinal(), versus.getKindOfCard(new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._2, Suit.D),
                new Card(Value.K, Suit.C),
                new Card(Value.K, Suit.D)));
    }

    @Test
    public void fourOfKind_getKindOfCard(){
        Versus versus = new Versus(this.black, this.white, this.kind);
        Assert.assertEquals(CardRank.FOUROFAKIND.ordinal(), versus.getKindOfCard(new Card(Value._2, Suit.H),
                new Card(Value._2, Suit.S),
                new Card(Value._2, Suit.D),
                new Card(Value._2, Suit.C),
                new Card(Value.Q, Suit.C)));
    }

    @Test
    public void straightFlush_getKindOfCard(){
        Versus versus = new Versus(this.black, this.white, this.kind);
        Assert.assertEquals(CardRank.STRAIGHTFLUSH.ordinal(), versus.getKindOfCard(new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.H),
                new Card(Value._4, Suit.H),
                new Card(Value._5, Suit.H),
                new Card(Value._6, Suit.H)));
    }

    @Test
    public void pairBiggerThanHighCard_compareKindOfCard(){
        Versus versus = new Versus(this.black, this.white, this.kind);
        Assert.assertEquals(CardRank.PAIR,
                versus.compareKindCardOnHand(CardRank.PAIR.ordinal(), CardRank.HIGHCARD.ordinal()));
    }

    @Test
    public void threeOfKindBiggerThanTwoPairs_compareKindOfCard(){
        Versus versus = new Versus(this.black, this.white, this.kind);
        Assert.assertEquals(CardRank.THREEOFAKIND,
                versus.compareKindCardOnHand(CardRank.TWOPAIR.ordinal(), CardRank.THREEOFAKIND.ordinal()));
    }

    @Test
    public void draw_compareKindOfCard(){
        Versus versus = new Versus(this.black, this.white, this.kind);
        Assert.assertEquals(CardRank.DRAW,
                versus.compareKindCardOnHand(CardRank.STRAIGHT.ordinal(), CardRank.STRAIGHT.ordinal()));
    }
}
