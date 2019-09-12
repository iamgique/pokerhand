package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;
import com.iamgique.pokerhand.rank.Rank;

public class TwoPair extends Rank {
    public boolean isTwoPairs(Card... cards) {
        return repeatValue(2, cards).size() == 2;
    }
}
