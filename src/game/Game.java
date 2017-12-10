package game;

import card.Card;
import card.Deck;
import player.Player;

public class Game {
    private Player turn;
    private boolean cheat = false;
    private boolean lie = false;

    private Card last_card = null;

    private Deck deck = new Deck();
    private Player[] players = new Player[4];

    public void initializeGame(int level){

    }

}
