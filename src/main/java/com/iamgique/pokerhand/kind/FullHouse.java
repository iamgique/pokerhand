package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.rank.Rank;

public class FullHouse extends Rank {
    public boolean isFullHouse(Card... cards) {
        return repeatValue(3, cards).size() == 1 && repeatValue(2, cards).size() == 1;
    }
}
