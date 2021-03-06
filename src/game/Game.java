package game;

import card.Card;
import card.Deck;
import card.IllegalCardException;
import player.IllegalMoveException;
import player.Player;

import java.util.Scanner;

public class Game {
    public int turn;
    public int cheat;
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

    //This was used for final testing
    public void printSystemStats(){
        System.out.println("\n System stats: \n");
        for(Player player: players){
            System.out.println(player.getClass());
            player.getHand().printCards();
            System.out.println("Size of hand: " + player.getHand().getSize());
            System.out.println();
        }
        System.out.println("Deck size is: " + deck.getSize());
        System.out.println("Turn is: " + turn);
        System.out.println("Cheat is: " + cheat);
        System.out.println("Lie is: " + lie);
    }

    public static void main(String[] args) throws IllegalCardException, IllegalMoveException {
        Scanner sc = new Scanner(System.in);

        System.out.println("What level would you like to play? Please pick between 1 and 7");
        int level = sc.nextInt();

        Game game = new Game(level);

        while(!(game.getCurrentState() instanceof EndGameState)){
            game.getCurrentState().implementStateResponsibilities();
            game.printSystemStats();
        }

        //Will call EndGameState
        game.getCurrentState().implementStateResponsibilities();


    }


}
