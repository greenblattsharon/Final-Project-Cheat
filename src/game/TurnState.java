package game;

import card.Card;
import card.IllegalCardException;
import player.Opponent;

public class TurnState implements GameState {

    Game game = null;

    public TurnState(Game game) {
        this.game = game;
    }

    public void playTurn() throws IllegalCardException {
        int[] card_indices;
        Card[] cards;

        if (game.turn != 0) {
            card_indices = game.players[game.turn].getCardsToPlay(game.last_card);
        } else {


        }
        cards = game.players[game.turn].playCards(card_indices);

        for (Card card : cards) {
            game.deck.addCard(card);
        }

    }

    private boolean wasTurnALie(Card[] cards) {

        //If the cards are not all the same then it is an automatic lie
        if (!areAllCardsTheSame(cards)) {
            return true;
        }

        //If the cards are the same and the game.turn = -1 then there cannot be a lie
        if (game.last_card == -1) {
            return false;
        } else {
            if (game.last_card == cards[0].getNumber()
                    || convertCardNumber(game.last_card - 1) == cards[0].getNumber()
                    || convertCardNumber(game.last_card + 1) == cards[0].getNumber()) {
                return false;
            }
            return true;

        }
    }

    private boolean areAllCardsTheSame(Card[] cards) {
        for (Card card1 : cards) {
            for (Card card2 : cards) {
                if (card1.compareTo(card2) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int convertCardNumber(int card_number) {
        if (card_number == 0) {
            return 13;
        }

        if (card_number == 14) {
            return 1;
        } else {
            return card_number;
        }
    }

}
