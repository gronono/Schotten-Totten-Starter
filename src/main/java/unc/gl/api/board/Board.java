package unc.gl.api.board;

import unc.gl.api.border.Border;
import unc.gl.api.player.Player;
import unc.gl.api.stock.Stock;
import unc.gl.api.stock.StockFactories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private static int NUM_PLAYER = 2;
    private List<Player> players;
    private Border border;
    private Stock stock;

    public Board(){
        players = new ArrayList<>();
        border = new Border();
        stock = StockFactories.createClanStock();
    }

    public List<Player> getPlayers(){
        return players;
    }

    public Player getOpponent(Player player) {
        return players.stream()
            .filter(curPlayer -> curPlayer != player)
            .collect(Collectors.toList())
            .get(0);
    }

    public boolean isFull(){
        return players.size() == NUM_PLAYER;
    }

    public void addPlayer(Player player){
        if(!isFull()){
            this.players.add(player);
        }
    }

    public void removePlayer(Player player){
        players.remove(player);
    }

    public Border getBorder(){
        return border;
    }

    public Stock getStock(){
        return stock;
    }
}
