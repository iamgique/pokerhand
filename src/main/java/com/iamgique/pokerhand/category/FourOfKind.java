package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.rank.Rank;

public class FourOfKind extends Rank {
    public boolean isFourOfKind(Card... cards) {
        return repeatValue(4, cards).size() == 1 && repeatValue(1, cards).size() == 1;
    }
}
