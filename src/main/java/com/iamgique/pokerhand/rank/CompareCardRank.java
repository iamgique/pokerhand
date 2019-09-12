package com.iamgique.pokerhand.rank;

import com.iamgique.pokerhand.kind.*;
import com.iamgique.pokerhand.model.Card;
import com.iamgique.pokerhand.model.CardRank;

public class CompareCardRank {
    HighCard highCard;
    Pair pair;
    TwoPair twoPair;
    ThreeOfKind threeOfKind;
    Straight straight;
    Flush flush;
    FullHouse fullHouse;
    FourOfKind fourOfKind;
    StraightFlush straightFlush;

    public CompareCardRank(HighCard highCard, Pair pair, TwoPair twoPair,
                           ThreeOfKind threeOfKind, Straight straight, Flush flush,
                           FullHouse fullHouse, FourOfKind fourOfKind, StraightFlush straightFlush, Card ... cards){
        this.highCard = highCard;
        this.pair = pair;
        this.twoPair = twoPair;
        this.threeOfKind = threeOfKind;
        this.straight = straight;
        this.flush = flush;
        this.fullHouse = fullHouse;
        this.fourOfKind = fourOfKind;
        this.straightFlush = straightFlush;
    }

    public int getKindOfCard(Card ... cards) {
        if(straightFlush.isStraightFlush(cards)){
            return CardRank.STRAIGHTFLUSH.ordinal();
        } if(fourOfKind.isFourOfKind(cards)){
            return CardRank.FOUROFAKIND.ordinal();
        } if(fullHouse.isFullHouse(cards)){
            return CardRank.FULLHOUSE.ordinal();
        } else if(flush.isFlush(cards)){
            return CardRank.FLUSH.ordinal();
        } else if(straight.isStraight(cards)) {
            return CardRank.STRAIGHT.ordinal();
        } else if(threeOfKind.isThreeOfKind(cards)){
            return CardRank.THREEOFAKIND.ordinal();
        } else if(twoPair.isTwoPairs(cards)){
            return CardRank.TWOPAIR.ordinal();
        } else if(pair.isPair(cards)){
            return CardRank.PAIR.ordinal();
        } else {
            return CardRank.HIGHCARD.ordinal();
        }
    }
}
