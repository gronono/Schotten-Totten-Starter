package unc.gl.api.player;

import unc.gl.api.card.ClanCard;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public static int HAND_SIZE = 6;
    private List<ClanCard> cards;

    public List<ClanCard> getCards(){
        return this.cards;
    }

    public boolean isFull(){
        return cards.size() == HAND_SIZE;
    }

    public void addCard(ClanCard card){
        if (!isFull()){
            this.cards.add(card);
        }
    }

    public void removeCard(ClanCard card){
        cards.remove(card);
    }

    public boolean have_card(ClanCard card){
        for(ClanCard cards: this.cards){
            if (card.getId().equals((cards.getId()))){
                return true;
            }
        }
        return false;
    }

    public Hand(){
        this.cards = new ArrayList<>();
    }

}
