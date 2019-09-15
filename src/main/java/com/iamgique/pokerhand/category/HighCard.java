package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.rank.Rank;

public class HighCard extends Rank {
    public boolean isHighCard(Card... cards) {
        return repeatValue(1, cards).size() == 5;
    }
}
