package com.iamgique.pokerhand.rank;

import com.iamgique.pokerhand.category.*;
import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CategoryCardRank;
import com.iamgique.pokerhand.model.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompareCardRankImpl extends Rank implements CompareCardRank {
    HighCard highCard;
    Pair pair;
    TwoPair twoPair;
    ThreeOfKind threeOfKind;
    Straight straight;
    Flush flush;
    FullHouse fullHouse;
    FourOfKind fourOfKind;
    StraightFlush straightFlush;

    public CompareCardRankImpl(HighCard highCard, Pair pair, TwoPair twoPair,
                               ThreeOfKind threeOfKind, Straight straight, Flush flush,
                               FullHouse fullHouse, FourOfKind fourOfKind, StraightFlush straightFlush, Card ... cards){
        this.highCard = highCard;
        this.pair = pair;
        this.twoPair = twoPair;
        this.threeOfKind = threeOfKind;
        this.straight = straight;
        this.flush = flush;
        this.fullHouse = fullHouse;
        this.fourOfKind = fourOfKind;
        this.straightFlush = straightFlush;
    }

    @Override
    public int getCategoryOfCard(Card ... cards) {
        if(straightFlush.isStraightFlush(cards)){
            return CategoryCardRank.STRAIGHTFLUSH.ordinal();
        } if(fourOfKind.isFourOfKind(cards)){
            return CategoryCardRank.FOUROFAKIND.ordinal();
        } if(fullHouse.isFullHouse(cards)){
            return CategoryCardRank.FULLHOUSE.ordinal();
        } else if(flush.isFlush(cards)){
            return CategoryCardRank.FLUSH.ordinal();
        } else if(straight.isStraight(cards)) {
            return CategoryCardRank.STRAIGHT.ordinal();
        } else if(threeOfKind.isThreeOfKind(cards)){
            return CategoryCardRank.THREEOFAKIND.ordinal();
        } else if(twoPair.isTwoPairs(cards)){
            return CategoryCardRank.TWOPAIR.ordinal();
        } else if(pair.isPair(cards)){
            return CategoryCardRank.PAIR.ordinal();
        } else {
            return CategoryCardRank.HIGHCARD.ordinal();
        }
    }

    @Override
    public Card getHighestCard(int index, Card ... cards) {
        return sortByValue(cards).get(index);
    }

    @Override
    public Value getMaxDuplicateCard(Card ... cards) {
        return Stream.of(cards).collect(Collectors.groupingBy(Card::getValue,
                Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();
    }

    @Override
    public Value getPairCardValue(Card ... cards) {
        return pair.getPairCardValue(cards);
    }

    @Override
    public List<Card> getRemainingCardOfPair(List<Card> cards) {
        return pair.getRemainingCardOfPair(cards);
    }

    @Override
    public List<Card> getTwoPairCardHighestValue(Card ... cards) {
        return twoPair.getTwoPairCardHighestValue(cards);
    }

    @Override
    public List<Card> getHighestRemainingCardOfTwoPair(List<Card> cards) {
        return twoPair.getHighestRemainingCardOfTwoPair(cards);
    }

    @Override
    public StringBuffer getFullHouseValueMsg(Card ... cards) {
        return fullHouse.getFullHouseValueMsg(cards);
    }
}
