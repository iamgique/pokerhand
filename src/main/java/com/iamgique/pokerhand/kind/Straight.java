package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.rank.Rank;

public class Straight extends Rank implements Kind {
    Card[] cards;

    public Straight(Card... cards){
        this.cards = cards;
    }

    private boolean isStraight(Card... cards) {
        return isInSequence(sortByValue(cards));
    }

    @Override
    public int kindOfCard(){
        return (isStraight(cards)) ? CardRank.STRAIGHT.ordinal() : 0;
    }
}
