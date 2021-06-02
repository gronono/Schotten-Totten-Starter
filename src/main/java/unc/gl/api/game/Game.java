package unc.gl.api.game;

import unc.gl.api.board.Board;
import unc.gl.api.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Integer id;
    private GameOptions gameOption;
    private GameStatus gameStatus;
    private Board board;

    public Integer getId() {
        return id;
    }

    public GameOptions getGameOption() {
        return gameOption;
    }

    public void setGameOption(GameOptions gameOption) {
        this.gameOption = gameOption;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Board getBoard() {
        return board;
    }

    public Game(int id, Board board, GameOptions options){
        this.id = id;
        this.gameOption = options;
        this.gameStatus = GameStatus.CREATED;
        this.board = board;
    }

    public void start(){
        if(this.gameStatus == GameStatus.CREATED){
            this.gameStatus = GameStatus.STARTED;
        }
    }

    public boolean isFull(){
        return this.board.isFull();
    }

    public List<Player> getPlayers(){
        return this.board.getPlayers();
    }

    public void addPlayers(Player player){
        if (!isFull()){
            this.board.addPlayer(player);
        }
    }

    public void removePlayer(Player player){
        this.board.removePlayer(player);
    }

    public Player getOpponent(Player player){
        return this.board.getOpponent(player);
    }
}
