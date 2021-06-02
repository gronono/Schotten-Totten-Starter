package unc.gl.api.combination;

import unc.gl.api.card.ClanCard;

import java.util.List;

public interface ICombinationSupport {
    public boolean supports(List<ClanCard> cards);
}
