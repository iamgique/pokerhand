package com.iamgique.pokerhand.game;

import com.iamgique.pokerhand.model.*;
import com.iamgique.pokerhand.rank.CompareCardRank;

import java.util.*;

public class Versus {
    CompareCardRank compareCardRank;
    List<Card> black;
    List<Card> white;
    Map<String, Integer> player = new HashMap<>();
    Summary summary = new Summary();

    public Versus(List<Card> black, List<Card> white, CompareCardRank compareCardRank){
        this.black = black;
        this.white = white;
        this.compareCardRank = compareCardRank;
    }

    public String versus() {
        player.put(Player.BLACK.getContent(),
                getCategory(black.get(0), black.get(1), black.get(2), black.get(3), black.get(4)));
        player.put(Player.WHITE.getContent(),
                getCategory(white.get(0), white.get(1), white.get(2), white.get(3), white.get(4)));

        compareCategoryCardOnHand(player.get(Player.BLACK.getContent()), player.get(Player.WHITE.getContent()));
        return summary.toString();
    }

    private int getCategory(Card ... cards) {
        return compareCardRank.getCategoryOfCard(cards);
    }

    public void compareCategoryCardOnHand(int categoryOfPlayerBlack, int categoryOfPlayerWhite) {
        if(categoryOfPlayerBlack > categoryOfPlayerWhite) {
            getWinner(Player.BLACK, black);
        } else if (categoryOfPlayerBlack < categoryOfPlayerWhite) {
            getWinner(Player.WHITE, white);
        } else {
            if(isPair(Player.WHITE.getContent())) compareHighestCardOfPairOfTwoPlayer();
            if(isTwoPair(Player.WHITE.getContent())) compareHighestCardOfTwoPairOfTwoPlayer();
            if(isFullHouse(Player.WHITE.getContent())) compareHighestCardOfFullHouseOfTwoPlayer();
            if(isMustBeUseMaxDuplicateCard(Player.WHITE.getContent())) compareMaxDuplicateCardOfTwoPlayer();
            if(isMustBeUseHighestCard(Player.WHITE.getContent())) compareHighestCardOfTwoPlayer(0, black, white);
        }
    }

    private void getWinner(Player playerBlackOrWhite, List<Card> cards) {
        if (isPair(playerBlackOrWhite.getContent()))
            setWinner(new Card(compareCardRank.getPairCardValue(cards.toArray(new Card[cards.size()]))).getValue().getContent(), playerBlackOrWhite.getContent());

        if (isTwoPair(playerBlackOrWhite.getContent()))
            setWinner(compareCardRank.getTwoPairCardHighestValue(cards.toArray(new Card[cards.size()])).get(0).getValue().getContent(), playerBlackOrWhite.getContent());

        if (isFullHouse(playerBlackOrWhite.getContent()))
            setWinner(compareCardRank.getFullHouseValueMsg(cards.toArray(new Card[cards.size()])).toString(), playerBlackOrWhite.getContent());

        if (isMustBeUseMaxDuplicateCard(playerBlackOrWhite.getContent()))
            setWinner(new Card(compareCardRank.getMaxDuplicateCard(cards.toArray(new Card[cards.size()]))).getValue().getContent(), playerBlackOrWhite.getContent());

        if (isMustBeUseHighestCard(playerBlackOrWhite.getContent()))
            setWinner(compareCardRank.getHighestCard(0, cards.toArray(new Card[cards.size()])).getValue().getContent(), playerBlackOrWhite.getContent());
    }

    private boolean isPair(String playerBlackOrWhite){
        return player.get(playerBlackOrWhite) == CategoryCardRank.PAIR.ordinal();
    }

    private boolean isTwoPair(String playerBlackOrWhite){
        return player.get(playerBlackOrWhite) == CategoryCardRank.TWOPAIR.ordinal();
    }

    private boolean isFullHouse(String playerBlackOrWhite){
        return player.get(playerBlackOrWhite) == CategoryCardRank.FULLHOUSE.ordinal();
    }

    private boolean isMustBeUseMaxDuplicateCard(String playerBlackOrWhite){
        return player.get(playerBlackOrWhite) == CategoryCardRank.THREEOFAKIND.ordinal()
                || player.get(playerBlackOrWhite) == CategoryCardRank.FOUROFAKIND.ordinal();
    }

    private boolean isMustBeUseHighestCard(String playerBlackOrWhite){
        return player.get(playerBlackOrWhite) == CategoryCardRank.HIGHCARD.ordinal()
                || player.get(playerBlackOrWhite) == CategoryCardRank.STRAIGHT.ordinal()
                || player.get(playerBlackOrWhite) == CategoryCardRank.FLUSH.ordinal()
                || player.get(playerBlackOrWhite) == CategoryCardRank.STRAIGHTFLUSH.ordinal();
    }

    private void compareHighestCardOfPairOfTwoPlayer() {
        Value pairCardBlack = compareCardRank.getPairCardValue(black.toArray(new Card[black.size()]));
        Value pairCardWhite = compareCardRank.getPairCardValue(white.toArray(new Card[white.size()]));

        if(pairCardBlack.ordinal() != pairCardWhite.ordinal()) {
            compareValueOfCardToSetWinner(new Card(pairCardBlack), new Card(pairCardWhite));
        } else {
            List<Card> a = compareCardRank.getRemainingCardOfPair(black);
            List<Card> b = compareCardRank.getRemainingCardOfPair(white);
            compareHighestCardOfTwoPlayer(0, a, b);
        }
    }

    private void compareHighestCardOfTwoPairOfTwoPlayer() {
        List<Card> twoPairCardBlack = compareCardRank.getTwoPairCardHighestValue(black.toArray(new Card[black.size()]));
        List<Card> twoPairCardWhite = compareCardRank.getTwoPairCardHighestValue(white.toArray(new Card[white.size()]));
        boolean isEquals = false;

        for(int i = 0; i < twoPairCardBlack.size(); i++){
            if(twoPairCardBlack.get(i).getValue().ordinal() != twoPairCardWhite.get(i).getValue().ordinal() ){
                compareValueOfCardToSetWinner(twoPairCardBlack.get(i), twoPairCardWhite.get(i));
                isEquals = true;
                break;
            }
        }

        if(!isEquals) {
            List<Card> a = compareCardRank.getHighestRemainingCardOfTwoPair(black);
            List<Card> b = compareCardRank.getHighestRemainingCardOfTwoPair(white);
            compareHighestCardOfTwoPlayer(0, a, b);
        }
    }

    private void compareHighestCardOfFullHouseOfTwoPlayer() {
        Value a = compareCardRank.getMaxDuplicateCard(black.get(0), black.get(1), black.get(2), black.get(3), black.get(4));
        Value b = compareCardRank.getMaxDuplicateCard(white.get(0), white.get(1), white.get(2), white.get(3), white.get(4));
        if(a.ordinal() > b.ordinal()) {
            setWinner(compareCardRank.getFullHouseValueMsg(black.toArray(new Card[black.size()])).toString(), Player.BLACK.getContent());
        } else {
            setWinner(compareCardRank.getFullHouseValueMsg(white.toArray(new Card[white.size()])).toString(), Player.WHITE.getContent());
        }
    }

    private void compareHighestCardOfTwoPlayer(int index, List<Card> cardsBlack, List<Card> cardsWhite) {
        Card a = compareCardRank.getHighestCard(index, cardsBlack.toArray(new Card[cardsBlack.size()]));
        Card b = compareCardRank.getHighestCard(index, cardsWhite.toArray(new Card[cardsWhite.size()]));

        if(a.getValue().ordinal() == b.getValue().ordinal() && cardsBlack.size() - 1 > index){
            compareHighestCardOfTwoPlayer(++index, cardsBlack, cardsWhite);
        } else {
            compareValueOfCardToSetWinner(a, b);
            return;
        }
    }

    private void compareMaxDuplicateCardOfTwoPlayer() {
        Value a = compareCardRank.getMaxDuplicateCard(black.get(0), black.get(1), black.get(2), black.get(3), black.get(4));
        Value b = compareCardRank.getMaxDuplicateCard(white.get(0), white.get(1), white.get(2), white.get(3), white.get(4));
        compareValueOfCardToSetWinner(new Card(a), new Card(b));
    }

    private void compareValueOfCardToSetWinner(Card a, Card b) {
        if (a.getValue().ordinal() > b.getValue().ordinal()) {
            setWinner(a.getValue().getContent(), Player.BLACK.getContent());
        } else if (a.getValue().ordinal() < b.getValue().ordinal()) {
            setWinner(b.getValue().getContent(), Player.WHITE.getContent());
        }
    }

    private void setWinner(String msg, String playerBlackOrWhite) {
        summary.setPlayer(playerBlackOrWhite);
        summary.setRank(CategoryCardRank.values[player.get(playerBlackOrWhite)].getContent());
        summary.setMsg(msg);
    }
}
