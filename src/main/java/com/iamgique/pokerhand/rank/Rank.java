package com.iamgique.pokerhand.rank;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract public class Rank {
    protected static List<Card> sortByValue(Card ... cards) {
        return Stream.of(cards)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    protected Map<Value, List<Card>> repeatValue(int dup, Card ... cards) {
        return filterByDup(dup, repeatingGroup(cards, Card::getValue));
    }

    protected Map<Suit, List<Card>> repeatSuit(int dup, Card ... cards) {
        return filterByDup(dup, repeatingGroup(cards, Card::getSuit));
    }

    protected  <T> Map<T, List<Card>> repeatingGroup(Card[] cards, Function<? super Card, ? extends T> x) {
        return Stream.of(cards).collect(Collectors.groupingBy(x));
    }

    private <T> Map<T, List<Card>> filterByDup(int dup, Map<T, List<Card>> cards) {
        return  cards
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() == dup)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    protected boolean isInSequence(List<Card> cards) {
        Card c = cards.get(0);
        for(int i = 1; i < cards.size(); i++){
            if (c.getValue().ordinal() - 1 != cards.get(i).getValue().ordinal()) {
                return false;
            }
            c = cards.get(i);
        }
        return true;
    }

    protected Map<Value, Long> groupingDupCard(Card ... cards){
        return Stream.of(cards).collect(Collectors.groupingBy(Card::getValue,
                Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    protected List<Card> getHighestByDupValue(Card ... cards){
        List<Card> list = new ArrayList<>();
        groupingDupCard(cards).forEach((k,v)-> {
            if(1 < v){
                list.add(new Card (k));
            }
        });
        return sortByValue(list.toArray(new Card[list.size()]));
    }


}
