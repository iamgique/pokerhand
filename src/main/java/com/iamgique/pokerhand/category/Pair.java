package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Value;
import com.iamgique.pokerhand.rank.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pair extends Rank {
    public boolean isPair(Card... cards) {
        return repeatValue(2, cards).size() == 1;
    }

    public Value getPairCardValue(Card ... cards) {
        return Stream.of(cards).collect(Collectors.groupingBy(Card::getValue,
                Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();
    }

    public List<Card> getRemainingCardOfPair(List<Card> cards){
        return cards.stream()
                .filter(e -> e.getValue().ordinal() != getPairCardValue(cards.toArray(new Card[cards.size()])).ordinal())
                .collect(Collectors.toList());
    }
}
