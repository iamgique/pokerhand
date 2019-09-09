package com.iamgique.pokerhand.game;

import com.iamgique.pokerhand.kind.*;
import com.iamgique.pokerhand.model.*;

import java.util.*;

public class Versus {
    Kind kind;
    List<Card> black;
    List<Card> white;
    Map<String, Integer> playerBlack = new HashMap<>();
    Map<String, Integer> playerWhite = new HashMap<>();
    Summary summary = new Summary();

    public Versus(List<Card> black, List<Card> white, Kind kind){
        this.kind = kind;
        this.black = black;
        this.white = white;
    }

    public String versus() {
        playerBlack.put(Player.BLACK.getContent(), getKindOfCard(black.get(0), black.get(1), black.get(2), black.get(3), black.get(4)));
        playerWhite.put(Player.WHITE.getContent(), getKindOfCard(white.get(0), white.get(1), white.get(2), white.get(3), white.get(4)));

        CardRank resp = compareKindCardOnHand(playerBlack.get("Black"), playerWhite.get("White"));

        sameKindOfCard(resp);
        notSameKindOfCard(resp);

        return summary.toString();
    }

    public int getKindOfCard(Card ... cards) {
        if(CardRank.STRAIGHTFLUSH.ordinal() == new StraightFlush(cards).kindOfCard()) {
            return new StraightFlush(cards).kindOfCard();
        } else if(CardRank.FOUROFAKIND.ordinal() == new FourOfKind(cards).kindOfCard()){
            return new FourOfKind(cards).kindOfCard();
        } else if(CardRank.FULLHOUSE.ordinal() == new FullHouse(cards).kindOfCard()){
            return new FullHouse(cards).kindOfCard();
        } else if(CardRank.FLUSH.ordinal() == new Flush(cards).kindOfCard()){
            return new Flush(cards).kindOfCard();
        } else if(CardRank.STRAIGHT.ordinal() == new Straight(cards).kindOfCard()){
            return new Straight(cards).kindOfCard();
        } else if (CardRank.THREEOFAKIND.ordinal() == new ThreeOfKind(cards).kindOfCard()) {
            return new ThreeOfKind(cards).kindOfCard();
        } else if (CardRank.TWOPAIR.ordinal() == new TwoPair(cards).kindOfCard()) {
            return new TwoPair(cards).kindOfCard();
        } else if (CardRank.PAIR.ordinal() == new Pair(cards).kindOfCard()) {
            return new Pair(cards).kindOfCard();
        } else if(CardRank.HIGHCARD.ordinal() == new HighCard(cards).kindOfCard()){
            return new HighCard(cards).kindOfCard();
        } else {
            return 0;
        }
    }

    public CardRank compareKindCardOnHand(int a, int b) {
        if(a > b) {
            return CardRank.values[a];
        } else if (a < b) {
            return CardRank.values[b];
        } else {
            return CardRank.values[1];
        }
    }

    private void sameKindOfCard(CardRank resp){
        if(CardRank.DRAW.ordinal() == resp.ordinal()){
            if(playerBlack.get(Player.BLACK.getContent()) == CardRank.THREEOFAKIND.ordinal()){
                compareThreeOfKind();
            }

            if(playerBlack.get(Player.BLACK.getContent()) > CardRank.DRAW.ordinal() &&
                    playerBlack.get(Player.BLACK.getContent()) < CardRank.THREEOFAKIND.ordinal()
                    || playerBlack.get(Player.BLACK.getContent()) == CardRank.STRAIGHT.ordinal()
                    || playerBlack.get(Player.BLACK.getContent()) == CardRank.FLUSH.ordinal()
            ){
                compareHighestCard(0);
            }
        }
    }

    private void notSameKindOfCard(CardRank resp){
        System.err.println("NOT DRAW");
    }

    private void compareHighestCard(int index) {
        Card a = new HighCard(black.get(0), black.get(1), black.get(2), black.get(3), black.get(4)).getHighestCard(index);
        Card b = new HighCard(white.get(0), white.get(1), white.get(2), white.get(3), white.get(4)).getHighestCard(index);
        if(a.getValue().ordinal() == b.getValue().ordinal()){
            compareHighestCard(++index);
        } else {
            getWinner(a, b);
            return;
        }
    }

    private void compareThreeOfKind() {
        Value a = new ThreeOfKind(black.get(0), black.get(1), black.get(2), black.get(3), black.get(4)).getCardThreeOfKind();
        Value b = new ThreeOfKind(white.get(0), white.get(1), white.get(2), white.get(3), white.get(4)).getCardThreeOfKind();
        getWinner(new Card(a, Suit.H),new Card(b, Suit.H));
    }

    private void getWinner(Card a, Card b) {
        if(a.getValue().ordinal() > b.getValue().ordinal()){
            summary.setPlayer(Player.BLACK.getContent());
            summary.setRank(CardRank.values[playerBlack.get(Player.BLACK.getContent())].getContent());
            summary.setCard(a.getValue().getContent());
        } else {
            summary.setPlayer(Player.WHITE.getContent());
            summary.setRank(CardRank.values[playerWhite.get(Player.WHITE.getContent())].getContent());
            summary.setCard(b.getValue().getContent());
        }
    }
}
