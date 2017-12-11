package game;

import card.Card;
import card.Hand;
import card.IllegalCardException;
import player.IllegalMoveException;

import java.util.ArrayList;

public class CheatState implements GameState{
    Game game;

    public CheatState(Game game){
        this.game = game;
    }

    @Override
    public void implementStateResponsibilities() throws IllegalCardException, IllegalMoveException {
        Hand hand;
        ArrayList<Card> cards = game.deck.getCards();

        if(game.cheat == -1){
            throw new IllegalMoveException("Cheat was improperly called");
        }

        if(game.cheat == 0){
            System.out.println("You have called Cheat on Opponent " + game.turn);
        }
        else {
            if (game.turn == 0) {
                System.out.println("Opponent " + game.cheat + " has called Cheat on you!");
            }
            else{
                System.out.println("Opponent " + game.cheat + " has called Cheat on Opponent " + game.turn);
            }
        }

        if(game.lie){
            if(game.turn == 0){
                System.out.println("Opponent " + game.cheat + " caught your lie! You pick up the deck.");
            }
            else{
                System.out.println("Opponent " + game.turn + " was caught lying! He picks up the deck.");
            }

           hand = game.players[game.turn].getHand();

           for(Card card: cards){
               hand.addCard(card);
           }

           game.deck.removeAll();

        }

        else{
            if(game.turn == 0){
                System.out.println("Opponent " + game.cheat + " wrongly accused you of Cheating! He picks up the deck.");
            }
            else{
                if(game.cheat == 0) {
                    System.out.println("You were wrong about Opponent " + game.turn + " cheating. You pick up the deck.");
                }
                else{
                    System.out.println("Opponent " + game.cheat + " was wrong about Cheat on Opponent " + game.turn + ". He picks up the deck.");
                }
            }
            hand = game.players[game.cheat].getHand();

            for(Card card: cards){
                hand.addCard(card);
            }

            game.deck.removeAll();

            if(game.players[game.turn].getHand().isItEmpty()){
                game.setCurrentState(new EndGameState(game));
                return;
            }
        }

        game.setCurrentState(new TurnState(game));

    }
}
