package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.model.Suit;
import com.iamgique.pokerhand.model.Value;
import com.iamgique.pokerhand.rank.Rank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeOfKind extends Rank implements Kind {
    Card[] cards;

    public ThreeOfKind(Card... cards){
        this.cards = cards;
    }

    private boolean isThreeOfKind(Card... cards) {
        return repeatValue(3, cards).size() == 1 && repeatValue(1, cards).size() == 2;
    }

    @Override
    public int kindOfCard(){
        return (isThreeOfKind(this.cards)) ? CardRank.THREEOFAKIND.ordinal() : 0;
    }

    public Value getCardThreeOfKind() {
        return Stream.of(cards).collect(Collectors.groupingBy(Card::getValue,
                Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1L)
                .map(e -> e.getKey())
                .collect(Collectors.toList()).get(0);
    }
}
