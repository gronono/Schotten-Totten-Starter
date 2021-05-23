package unc.gl.api.border;

import unc.gl.api.card.ClanCard;
import unc.gl.api.combination.Combination;
import unc.gl.api.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stone {
    private int id;
    private Map<Player, StoneArea> areas;
    private Player captured_by;
    private Player challenger;

    public Stone(int id){
        this.id = id;
        this.captured_by = null;
        this.areas = new HashMap<>();
        this.challenger = null;
    }

    public int getId() {
        return id;
    }

    public Player getCaptured_by() {
        return captured_by;
    }

    public void setCaptured_by(Player captured_by) {
        this.captured_by = captured_by;
    }

    public StoneArea getPlayerAreas(Player player){
        return areas.get(player);
    }

    public boolean PlayerArea_isFull(Player player){
        StoneArea area = getPlayerAreas(player);
        if(area == null){
            return false;
        }
        return area.isFull();
    }

    public void fightForStone(){
        if(areas.keySet().size() != 2){
            return;
        }
        Player player1 = (Player) areas.keySet().toArray()[0];
        Player player2 = (Player) areas.keySet().toArray()[1];

        StoneArea area1 = areas.get(player1);
        StoneArea area2 = areas.get(player2);

        if(area1.isFull() && area2.isFull()){
            Combination combination1 = new Combination(area1.getCards());
            Combination combination2 = new Combination(area2.getCards());

            int result = combination1.compareTo(combination2);

            if(result < 0){
                this.setCaptured_by(player2);
            } else if(result == 0){
                this.setCaptured_by(this.challenger);
            } else {
                this.setCaptured_by(player1);
            }
        }
    }

    public void addCardFor(Player player, ClanCard card){
        StoneArea area = getPlayerAreas(player);
        if(area == null){
            area = new StoneArea();
            areas.put(player, area);
        }

        if(!PlayerArea_isFull(player)) {
            area.addCard(card);
        }

        if (PlayerArea_isFull(player) && challenger == null) {
            challenger = player;
        }

        if(areas.size() > 1) {
            List<Player> players = new ArrayList<>(areas.keySet());
            Player player1 = players.get(0);
            Player player2 = players.get(1);

            if (PlayerArea_isFull(player1) && PlayerArea_isFull(player2)) {
                fightForStone();
            }
        }
    }
}
