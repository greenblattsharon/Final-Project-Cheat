package game;

import card.Card;
import card.IllegalCardException;
import player.IllegalMoveException;

import java.util.Random;
import java.util.Scanner;

public class TurnState implements GameState {

    Game game = null;

    public TurnState(Game game) {
        this.game = game;
    }

    @Override
    public void implementStateResponsibilities() throws IllegalCardException, IllegalMoveException {
        int[] card_indices;
        Card[] cards;

        card_indices = game.players[game.turn].getCardsToPlay(game.last_card);
        cards = game.players[game.turn].playCards(card_indices);

        game.lie = wasTurnALie(cards);

        for (Card card : cards) {
            game.deck.addCard(card);
        }

        if (game.turn == 0) {
            System.out.println("You have played " + cards.length + " cards of number " + game.last_card);
        } else {
            System.out.println("Opponent " + game.turn + " has played " + cards.length + " cards of number " + game.last_card);
        }

        if (game.turn != 0) {
            if (game.players[0].callCheat(0, 0)) {
                game.cheat = 0;
            } else {
                int[] opponents = new int[2];

                switch (game.turn) {
                    case 1:
                        opponents[0] = 2;
                        opponents[1] = 3;
                    case 2:
                        opponents[0] = 1;
                        opponents[1] = 3;
                    case 3:
                        opponents[0] = 1;
                        opponents[1] = 2;
                }

                game.cheat = whoCallsCheat(opponents, cards.length);
            }
        } else {

            int[] opponents = new int[3];
            opponents[0] = 1;
            opponents[1] = 2;
            opponents[2] = 3;
            game.cheat = whoCallsCheat(opponents, cards.length);
        }

        if (game.cheat != -1) {
            game.setCurrentState(new CheatState(game));
            game.getCurrentState().implementStateResponsibilities();
        }

        if (game.players[game.turn].getHand().isItEmpty()) {
            game.setCurrentState(new EndGameState(game));
        }

        game.turn++;
        game.lie = false;
        game.cheat = -1;

        if (game.turn == 4) {
            game.turn = 0;
        }
    }

    public boolean wasTurnALie(Card[] cards) {

        //If the cards are not all the same then it is an automatic lie
        if (!areAllCardsTheSame(cards)) {
            game.last_card = generateLastCardNumber(game.last_card);
            return true;
        }

        //If the cards are the same and the game.turn = -1 then there cannot be a lie
        if (game.last_card == -1) {
            game.last_card = cards[0].getNumber();
            return false;
        } else {
            if (game.last_card == cards[0].getNumber()
                    || convertCardNumber(game.last_card - 1) == cards[0].getNumber()
                    || convertCardNumber(game.last_card + 1) == cards[0].getNumber()) {
                game.last_card = cards[0].getNumber();
                return false;
            }
            game.last_card = generateLastCardNumber(game.last_card);
            return true;

        }
    }

    public boolean areAllCardsTheSame(Card[] cards) {
        for (Card card1 : cards) {
            for (Card card2 : cards) {
                if (card1.compareTo(card2) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int convertCardNumber(int card_number) {
        if (card_number == 0) {
            return 13;
        }

        if (card_number == 14) {
            return 1;
        } else {
            return card_number;
        }
    }

    public int generateLastCardNumber(int card_number) {
        int cn;
        if (game.turn == 0 && card_number == -1) {
            System.out.println("You have lied. What card would you like to say you are playing? ");
            Scanner sc = new Scanner(System.in);
            cn = sc.nextInt();
            while (cn <= 0 || cn >= 14) {
                System.out.println("Error! Error! This is not a valid number. Try again!");
                System.out.println("Please enter another number to play: ");
                cn = sc.nextInt();
            }
            return cn;
        }

        Random rn = new Random();
        cn = rn.nextInt(13) + 1;

        if (card_number == -1) {
            return cn;
        } else {
            cn = rn.nextInt(3) + 1;
            switch (cn) {
                case 1:
                    return convertCardNumber(card_number - 1);
                case 2:
                    return card_number;
                case 3:
                    return convertCardNumber(card_number + 1);
            }

        }
        return card_number;
    }

    public int whoCallsCheat(int[] opponents, int card_length) throws IllegalMoveException {
        Random rn = new Random();

        boolean[] cheat_eval = new boolean[opponents.length];

        for (int i = 0; i < opponents.length; i++) {
            cheat_eval[i] = game.players[opponents[i]].callCheat(game.last_card, card_length);
        }

        int count = 0;
        for (Boolean bool : cheat_eval) {
            if (bool) {
                count++;
            }
        }

        //None of the opponents want to call Cheat
        if (count == 0) {
            return -1;
        } else {
            if (count == cheat_eval.length) {
                int decider = rn.nextInt(3);
                return opponents[decider];
            } else {
                for (int i = 0; i < cheat_eval.length; i++) {
                    if (cheat_eval[i]) {
                        return opponents[i];
                    }
                }
            }
        }
        return -1;
    }

}
