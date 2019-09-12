package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.rank.Rank;

import java.util.List;

public class HighCard extends Rank implements Kind {
    Card[] cards;

    public HighCard(Card... cards){
        this.cards = cards;
    }

    private boolean isHighCard(Card... cards) {
        return repeatValue(1, cards).size() == 5;
    }

    @Override
    public int kindOfCard(){
        return (isHighCard(this.cards)) ? CardRank.HIGHCARD.ordinal() : 0;
    }
}
