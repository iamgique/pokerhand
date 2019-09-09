package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.rank.Rank;

public class FullHouse extends Rank implements Kind {
    Card[] cards;

    public FullHouse(Card... cards){
        this.cards = cards;
    }

    private boolean isFullHouse(Card... cards) {
        return repeatValue(3, cards).size() == 1 && repeatValue(2, cards).size() == 1;
    }

    @Override
    public int kindOfCard(){
        return (isFullHouse(this.cards)) ? CardRank.FULLHOUSE.ordinal() : 0;
    }
}
