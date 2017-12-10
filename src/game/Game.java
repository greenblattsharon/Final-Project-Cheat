package game;

import card.Card;
import card.Deck;
import card.IllegalCardException;
import player.Player;

public class Game {
    public int turn;
    public boolean cheat;
    public boolean lie;

    public int last_card;

    public int level;

    public Deck deck;
    public Player[] players = new Player[4];

    private GameState currentState;

    public Game(int level) throws IllegalCardException{
        this.level = level;
        currentState = new InitializeState(this);
    }

    public GameState getCurrentState(){
        return this.currentState;
    }

    public void setCurrentState(GameState gameState){
        this.currentState = gameState;
    }


}
