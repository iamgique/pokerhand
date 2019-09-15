package com.iamgique.pokerhand.rank;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Value;

import java.util.List;

public interface CompareCardRank {
    int getCategoryOfCard(Card... cards);
    Card getHighestCard(int index, Card ... cards);
    Value getMaxDuplicateCard(Card ... cards);
    Value getPairCardValue(Card ... cards);
    List<Card> getTwoPairCardHighestValue(Card ... cards);
    List<Card> getFullHouseValue(Card ... cards);
    List<Card> getRemainingCardOfPair(List<Card> cards);
    List<Card> getHighestRemainingCardOfTwoPair(List<Card> cards);
}
