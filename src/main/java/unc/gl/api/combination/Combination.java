package unc.gl.api.combination;

import unc.gl.api.card.ClanCard;

import java.util.List;

public class Combination {
    private List<ClanCard> cards;
    private int sum;

    public Combination(List<ClanCard> cards){
        this.cards = cards;
        this.sum = 0;

        for(ClanCard card : this.cards){
            this.sum += card.getStrength();
        }
    }

    public List<ClanCard> getCards() {
        return cards;
    }

    public int getSum() {
        return sum;
    }

    public int compareTo(Combination o) {
        if(this.cards.size() != 3 || o.cards.size() != 3){
            return -2;
        }
        ECombinationType type1 = ECombinationType.findFor(this);
        ECombinationType type2 = ECombinationType.findFor(o);

        if(type1.ordinal() > type2.ordinal()){
            return -1;
        } else if(type1.ordinal() == type2.ordinal()){
            return Integer.compare(this.getSum(), o.getSum());
        } else {
            return 1;
        }
    }
}
