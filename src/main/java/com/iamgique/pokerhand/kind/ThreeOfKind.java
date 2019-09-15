package com.iamgique.pokerhand.kind;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.rank.Rank;

public class ThreeOfKind extends Rank {
    public boolean isThreeOfKind(Card... cards) {
        return repeatValue(3, cards).size() == 1 && repeatValue(1, cards).size() == 2;
    }
}
