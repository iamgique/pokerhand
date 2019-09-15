package com.iamgique.pokerhand.category;

import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.rank.Rank;

import java.util.ArrayList;
import java.util.List;

public class FullHouse extends Rank {
    public boolean isFullHouse(Card... cards) {
        return repeatValue(3, cards).size() == 1 && repeatValue(2, cards).size() == 1;
    }

    public List<Card> getFullHouseValue(Card ... cards){
        List<Card> resp = new ArrayList<>();
        repeatingGroup(cards, Card::getValue).forEach((k,v)->{
            resp.add(new Card(k));
        });
        return resp;
    }
}
