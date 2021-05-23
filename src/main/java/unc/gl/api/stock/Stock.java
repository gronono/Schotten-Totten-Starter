package unc.gl.api.stock;

import unc.gl.api.card.ClanCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class Stock {
    private Stack<ClanCard> cardStack;

    public Stock(ArrayList<ClanCard> cards){
        Collections.shuffle(cards);
        this.cardStack = new Stack<>();
        cardStack.addAll((cards));
    }

    public ClanCard draw(){
        if(!cardStack.isEmpty()){
            return cardStack.pop();
        }else{
            throw new EmptyStackException();
        }
    }

    public Stack<ClanCard> getCardStack(){
        return this.cardStack;
    }
}
