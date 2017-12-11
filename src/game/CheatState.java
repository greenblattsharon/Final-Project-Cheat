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
           }

           game.deck.removeAll();

        }

        else{
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
