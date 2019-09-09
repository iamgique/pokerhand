package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.rank.Rank;

public class Flush extends Rank implements Kind {
    Card[] cards;

    public Flush(Card... cards){
        this.cards = cards;
    }

    private boolean isFlush(Card... cards) {
        return repeatSuit(5, cards).size() == 1;
    }

    @Override
    public int kindOfCard(){
        return (isFlush(this.cards)) ? CardRank.FLUSH.ordinal() : 0;
    }
}
