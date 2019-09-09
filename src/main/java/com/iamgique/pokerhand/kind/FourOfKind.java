package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.rank.Rank;

public class FourOfKind extends Rank implements Kind {
    Card[] cards;

    public FourOfKind(Card... cards){
        this.cards = cards;
    }

    private boolean isFourOfKind(Card... cards) {
        return repeatValue(4, cards).size() == 1 && repeatValue(1, cards).size() == 1;
    }

    @Override
    public int kindOfCard(){
        return (isFourOfKind(this.cards)) ? CardRank.FOUROFAKIND.ordinal() : 0;
    }
}
