package com.iamgique.pokerhand.game;

import com.iamgique.pokerhand.kind.Kind;
import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class VersusTest {
    Kind kind;
    List<Card> black;
    List<Card> white;

    @Test
    public void versus_whiteWinWhenWhiteHandHasAceCardIsHighest() {
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
    public void versus_blackWinWhenBlackHandHasNineCardIsHighest() {
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
    public void versus_WhiteWin_playerBlackAndWhiteHasSameHighCard_whiteHasNineCardIsHighest() {
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
    public void versus_WhiteWin_blackAndWhiteHasPair_playerWhiteHasJackCardIsHighest() {
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
    public void versus_blackWin_playerBlackAndWhiteHasSameHighCardTwoTimes_BlackHasEightCardIsHighest() {
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
    public void versus_blackWin_blackAndWhiteHasTwoPair_playerBlackHasKingCardIsHighest() {
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
    public void versus_blackWin_blackAndWhiteHasThreeOfAKind_playerBlackHasKingCardIsHighest() {
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
