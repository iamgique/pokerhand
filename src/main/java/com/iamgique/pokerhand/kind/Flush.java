package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.rank.Rank;

public class Flush extends Rank {
    public boolean isFlush(Card... cards) {
        return repeatSuit(5, cards).size() == 1;
    }
}
