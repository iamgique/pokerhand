package com.iamgique.pokerhand.game;

import com.iamgique.pokerhand.kind.*;
import com.iamgique.pokerhand.model.*;
import com.iamgique.pokerhand.rank.Rank;

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
        playerBlack.put(Player.BLACK.getContent(),
                getKindOfCard(black.get(0), black.get(1), black.get(2), black.get(3), black.get(4)));
        playerWhite.put(Player.WHITE.getContent(),
                getKindOfCard(white.get(0), white.get(1), white.get(2), white.get(3), white.get(4)));

        CardRank kindOfCard = compareKindCardOnHand(
                playerBlack.get(Player.BLACK.getContent()),
                playerWhite.get(Player.WHITE.getContent()));

        if(CardRank.DRAW.ordinal() == kindOfCard.ordinal()) {
            sameKindOfCard();
        } else {
            notSameKindOfCard(kindOfCard);
        }
        return summary.toString();
    }

    public int getKindOfCard(Card ... cards) {
        if(CardRank.STRAIGHTFLUSH.ordinal() == new StraightFlush(cards).kindOfCard()) {
            return CardRank.STRAIGHTFLUSH.ordinal();
        } else if(CardRank.FOUROFAKIND.ordinal() == new FourOfKind(cards).kindOfCard()){
            return CardRank.FOUROFAKIND.ordinal();
        } else if(CardRank.FULLHOUSE.ordinal() == new FullHouse(cards).kindOfCard()){
            return CardRank.FULLHOUSE.ordinal();
        } else if(CardRank.FLUSH.ordinal() == new Flush(cards).kindOfCard()){
            return CardRank.FLUSH.ordinal();
        } else if(CardRank.STRAIGHT.ordinal() == new Straight(cards).kindOfCard()){
            return CardRank.STRAIGHT.ordinal();
        } else if (CardRank.THREEOFAKIND.ordinal() == new ThreeOfKind(cards).kindOfCard()) {
            return CardRank.THREEOFAKIND.ordinal();
        } else if (CardRank.TWOPAIR.ordinal() == new TwoPair(cards).kindOfCard()) {
            return CardRank.TWOPAIR.ordinal();
        } else if (CardRank.PAIR.ordinal() == new Pair(cards).kindOfCard()) {
            return CardRank.PAIR.ordinal();
        } else {
            return CardRank.HIGHCARD.ordinal();
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

    private void sameKindOfCard(){
        if(playerBlack.get(Player.BLACK.getContent()) == CardRank.THREEOFAKIND.ordinal()
            || playerBlack.get(Player.BLACK.getContent()) == CardRank.FULLHOUSE.ordinal()
            || playerBlack.get(Player.BLACK.getContent()) == CardRank.FOUROFAKIND.ordinal() ){
            compareMaxDuplicateCard();
        }

        if(playerBlack.get(Player.BLACK.getContent()) == CardRank.HIGHCARD.ordinal()
            || playerBlack.get(Player.BLACK.getContent()) == CardRank.PAIR.ordinal()
            || playerBlack.get(Player.BLACK.getContent()) == CardRank.TWOPAIR.ordinal()
            || playerBlack.get(Player.BLACK.getContent()) == CardRank.STRAIGHT.ordinal()
            || playerBlack.get(Player.BLACK.getContent()) == CardRank.FLUSH.ordinal()
            || playerBlack.get(Player.BLACK.getContent()) == CardRank.STRAIGHTFLUSH.ordinal()
        ){
            compareHighestCard(0);
        }
    }

    private void notSameKindOfCard(CardRank resp){
        System.err.println("NOT DRAW");
    }

    private void compareMaxDuplicateCard() {
        Value a = Rank.getMaxDuplicateCard(black.get(0), black.get(1), black.get(2), black.get(3), black.get(4));
        Value b = Rank.getMaxDuplicateCard(white.get(0), white.get(1), white.get(2), white.get(3), white.get(4));
        getWinner(new Card(a, Suit.H),new Card(b, Suit.H));
    }

    private void compareHighestCard(int index) {
        Card a = Rank.getHighestCard(index, black.get(0), black.get(1), black.get(2), black.get(3), black.get(4));
        Card b = Rank.getHighestCard(index, white.get(0), white.get(1), white.get(2), white.get(3), white.get(4));
        if(a.getValue().ordinal() == b.getValue().ordinal() && black.size() - 1 > index){
            compareHighestCard(++index);
        } else {
            getWinner(a, b);
            return;
        }
    }

    private void getWinner(Card a, Card b) {
        if(a.getValue().ordinal() > b.getValue().ordinal()) {
            summary.setPlayer(Player.BLACK.getContent());
            summary.setRank(CardRank.values[playerBlack.get(Player.BLACK.getContent())].getContent());
            summary.setCard(a.getValue().getContent());
        } else if(a.getValue().ordinal() < b.getValue().ordinal()) {
            summary.setPlayer(Player.WHITE.getContent());
            summary.setRank(CardRank.values[playerWhite.get(Player.WHITE.getContent())].getContent());
            summary.setCard(b.getValue().getContent());
        }
    }
}
