package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.rank.Rank;

public class StraightFlush extends Rank implements Kind {
    Card[] cards;

    public StraightFlush(Card... cards){
        this.cards = cards;
    }

    private boolean isStraightFlush(Card... cards) {
        return isInSequence(sortByValue(cards)) && repeatSuit(5, cards).size() == 1;
    }

    @Override
    public int kindOfCard(){
        return (isStraightFlush(this.cards)) ? CardRank.STRAIGHTFLUSH.ordinal() : 0;
    }
}
