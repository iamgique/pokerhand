package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.rank.Rank;

public class TwoPair extends Rank implements Kind {
    Card[] cards;

    public TwoPair(Card... cards){
        this.cards = cards;
    }

    private boolean isTwoPairs(Card... cards) {
        return repeatValue(2, cards).size() == 2;
    }

    @Override
    public int kindOfCard(){
        return (isTwoPairs(this.cards)) ? CardRank.TWOPAIR.ordinal() : 0;
    }
}
