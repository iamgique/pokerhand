package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.rank.Rank;

public class Pair extends Rank {
    public boolean isPair(Card... cards) {
        return repeatValue(2, cards).size() == 1;
    }
}
