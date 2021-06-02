package unc.gl.api.border;

import unc.gl.api.card.ClanCard;

import java.util.ArrayList;
import java.util.List;

public class StoneArea {
    private static int MAX_CARDS = 3;
    private List<ClanCard> cards;

    public StoneArea(){
        this.cards = new ArrayList<>();
    }

    public boolean isFull(){
        return this.cards.size() == MAX_CARDS;
    }

    public void addCard(ClanCard card){
        this.cards.add(card);
    }

    public List<ClanCard> getCards(){
        return this.cards;
    }
}
