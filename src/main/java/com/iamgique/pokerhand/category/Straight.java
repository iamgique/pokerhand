package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.rank.Rank;

public class Straight extends Rank {
    public boolean isStraight(Card... cards) {
        return isInSequence(sortByValue(cards));
    }
}
