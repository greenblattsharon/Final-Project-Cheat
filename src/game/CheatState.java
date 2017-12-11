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

        if(game.lie){
           hand = game.players[game.turn].getHand();

           for(Card card: cards){
               hand.addCard(card);
               game.deck.removeCard(card);
           }

        }

        else{
            hand = game.players[game.cheat].getHand();

            for(Card card: cards){
                hand.addCard(card);
                game.deck.removeCard(card);
            }
        }

        game.setCurrentState(new TurnState(game));

    }
}
