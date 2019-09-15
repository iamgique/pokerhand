package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.rank.Rank;

public class StraightFlush extends Rank {
    public boolean isStraightFlush(Card... cards) {
        return isInSequence(sortByValue(cards)) && repeatSuit(5, cards).size() == 1;
    }
}
