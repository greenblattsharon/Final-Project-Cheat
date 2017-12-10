package game;

import card.Card;
import card.IllegalCardException;

import java.util.Random;
import java.util.Scanner;

public class TurnState implements GameState {

    Game game = null;

    public TurnState(Game game) {
        this.game = game;
    }

    @Override
    public void implementStateResponsibilities() throws IllegalCardException {
        int[] card_indices;
        Card[] cards;

        card_indices = game.players[game.turn].getCardsToPlay(game.last_card);
        cards = game.players[game.turn].playCards(card_indices);

        game.lie = wasTurnALie(cards);

        for (Card card : cards) {
            game.deck.addCard(card);
        }

        if(game.turn == 0){
            System.out.println("You have played " + cards.length + " cards of number " + game.last_card);
        }
        else{
            System.out.println("Your opponent has played " + cards.length + " cards of number " + game.last_card);
        }

        //TODO add code to implement calling Cheat

        if(game.players[game.turn].getHand().isItEmpty()){
            game.setCurrentState(new EndGameState());
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

    public int generateLastCardNumber(int card_number){
        int cn;
        if(game.turn == 0 && card_number == -1){
            System.out.println("You have lied. What card would you like to say you are playing? ");
            Scanner sc = new Scanner(System.in);
            cn = sc.nextInt();
            while(cn <= 0 || cn >= 14){
                System.out.println("Error! Error! This is not a valid number. Try again!");
                System.out.println("Please enter another number to play: ");
                cn = sc.nextInt();
            }
            return cn;
        }

        Random rn = new Random();
        cn = rn.nextInt(13) + 1;

        if(card_number == -1){
            return cn;
        }
        else{
            cn = rn.nextInt(3) + 1;
            switch(cn){
                case 1:
                    return convertCardNumber(card_number -1);
                case 2:
                    return card_number;
                case 3:
                    return convertCardNumber(card_number + 1);
            }

        }
        return card_number;
    }

}
