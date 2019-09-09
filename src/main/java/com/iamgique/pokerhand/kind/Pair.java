package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.rank.Rank;

public class Pair extends Rank implements Kind {
    Card[] cards;

    public Pair(Card... cards){
        this.cards = cards;
    }

    private boolean isPair(Card... cards) {
        return repeatValue(2, cards).size() == 1;
    }

    @Override
    public int kindOfCard(){
        return (isPair(this.cards)) ? CardRank.PAIR.ordinal() : 0;
    }
}
