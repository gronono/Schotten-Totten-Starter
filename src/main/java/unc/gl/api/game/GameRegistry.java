package unc.gl.api.game;

import unc.gl.api.board.Board;

import java.util.*;

public class GameRegistry {
    private List<Game> games;

    private GameRegistry(){
        this.games = new ArrayList<>();
    }
    private static GameRegistry instance = new GameRegistry();

    public static GameRegistry getInstance(){
        return instance;
    }

    public Game createNewGame(GameOptions options){
        Game newGame = new Game(games.size(), new Board(), options);
        this.games.add(newGame);
        return newGame;
    }

    public Optional<Game> findGame(int id){
        return Optional.ofNullable(this.games.get(id));
    }

    public ArrayList<Game> findAllWaitingGames(){
        ArrayList<Game> waitingGames = new ArrayList<Game>();
        for(Game game : this.games){
            if (game.getGameStatus() == GameStatus.CREATED){
                waitingGames.add(game);
            }
        }
        return waitingGames;
    }

}
