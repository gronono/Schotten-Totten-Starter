package unc.gl.api.combination;

import unc.gl.api.card.ClanCard;
import unc.gl.api.card.EColor;

import java.util.Comparator;
import java.util.List;

public enum ECombinationType implements ICombinationSupport{
    COLOR_RUN{
        @Override
        public boolean supports(List<ClanCard> cards) {
            return ECombinationType.isColorRun(cards);
        }
    },
    THREE_OF_KIND{
        @Override
        public boolean supports(List<ClanCard> cards) {
            return ECombinationType.isThreeOfKind(cards);
        }
    },
    COLOR{
        @Override
        public boolean supports(List<ClanCard> cards) {
            return ECombinationType.isColor(cards);
        }
    },
    RUN{
        @Override
        public boolean supports(List<ClanCard> cards) {
            return ECombinationType.isRun(cards);
        }
    },
    SUM{
        @Override
        public boolean supports(List<ClanCard> cards) {
            return true;
        }
    };

    public static ECombinationType findFor(Combination combination){
        List<ClanCard> cards = combination.getCards();

        for(ECombinationType type : ECombinationType.values()){
            if(type.supports(cards)){
                return type;
            }
        }
        return ECombinationType.SUM;
    }

    private static boolean isColorRun(List<ClanCard> cards){
        cards.sort(Comparator.comparingInt(ClanCard::getStrength));
        ClanCard ref = cards.get(0);
        EColor colorRef = ref.getColor();
        int strengthRef = ref.getStrength();

        for(int i = 1; i < cards.size(); i++){
            if(cards.get(i).getColor() != colorRef
                || cards.get(i).getStrength()-i != strengthRef){
                return false;
            }
        }
        return true;
    }

    private static boolean isThreeOfKind(List<ClanCard> cards){
        int ref = cards.get(0).getStrength();

        for(int i = 1; i < cards.size(); i++){
            if(cards.get(i).getStrength() != ref){
                return false;
            }
        }
        return true;
    }

    private static boolean isColor(List<ClanCard> cards){
        EColor ref = cards.get(0).getColor();

        for (int i = 1; i < cards.size(); i++){
            if(cards.get(i).getColor() != ref){
                return false;
            }
        }
        return true;
    }

    private static boolean isRun(List<ClanCard> cards){
        cards.sort(Comparator.comparingInt(ClanCard::getStrength));
        int ref = cards.get(0).getStrength();

        for(int i = 1; i < cards.size(); i++){
            if(cards.get(i).getStrength()-i != ref){
                return false;
            }
        }
        return true;
    }
}
