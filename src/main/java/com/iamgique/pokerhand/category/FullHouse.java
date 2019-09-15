package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.Value;
import com.iamgique.pokerhand.rank.Rank;

import java.util.*;

public class FullHouse extends Rank {
    public boolean isFullHouse(Card... cards) {
        return repeatValue(3, cards).size() == 1 && repeatValue(2, cards).size() == 1;
    }

    public StringBuffer getFullHouseValueMsg(Card ... cards){
        List<Map.Entry<Value, Long>> sorted = sortKeyByValueIsGrouping(cards);
        StringBuffer sb = new StringBuffer();

        sb.append(sorted.get(0).getKey().getContent());
        sb.append(" over ");
        sb.append(sorted.get(1).getKey().getContent());

        return sb;
    }
}
