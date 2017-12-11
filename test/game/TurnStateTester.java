package game;

import card.Card;
import card.IllegalCardException;
import card.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import player.User;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TurnStateTester {

    Game game;
    TurnState turnState;

    @Before
    public void setup() throws IllegalCardException{
        game = new Game(1);
        turnState = new TurnState(game);
        game.setCurrentState(turnState);}

    /**
     * currentState can be set to TurnState
     */
    @Test
    public void setCurrentStateToTurnState(){
        Assert.assertTrue("Current state is turnState", game.getCurrentState() instanceof TurnState);
    }

    /**
     * The first turn of turn state will have the user as the player for the turn
     */
    @Test
    public void firstTurnWillHaveUserAsPlayer(){
        Assert.assertTrue("First player is a user", game.players[game.turn] instanceof User);
    }

    /**
     * ConvertCardNumber will return 13 when give 0
     */
    @Test
    public void thirteenIsReturnedWhenGivenZero(){
        int num = turnState.convertCardNumber(0);
        Assert.assertTrue("ConvertCardNumber will return 13 when given 0", 13 == num);
    }

    /**
     * ConvertCardNumber will return 1 when give 14
     */
    @Test
    public void oneIsReturnedWhenGivenFourteen(){
        int num = turnState.convertCardNumber(14);
        Assert.assertTrue("ConvertCardNumber will return 1 when given 14", 1 == num);
    }

    /**
     * generateLastCardNumber will ask the user for what number they want
     * when the user lies and the any card is valid
     */
    @Test
    public void askUserToSetLast_Card(){
        String stimulatedOutput = "5";
        InputStream in = new ByteArrayInputStream(stimulatedOutput.getBytes());
        System.setIn(in);

        int num = turnState.generateLastCardNumber(-1);

        Assert.assertTrue("The return int should be what the user set", 5 == num);
    }

    /**
     * generateLastCardNumber will pick a random number if any card is a valid move
     */
    @Test
    public void randomNumberGeneratedWhenAnyCardIsValid(){
        game.turn = 1;

        int num = turnState.generateLastCardNumber(-1);
        System.out.println(num);

        Assert.assertTrue("The returned int will be higher than 1", 1 <= num);
        Assert.assertTrue("The returned int will be lower than 13", 13 >= num);
    }

    /**
     * generateLastCardNumber will pick random up, stay, or down when last_card is not anything
     */
    @Test
    public void randomNumberWithinGameParametersForValidMoveIsChose(){
        game.turn = 1;

        int num = turnState.generateLastCardNumber(5);
        System.out.println(num);

        Assert.assertTrue("The returned int will be 4,5, or 6", 4 == num || 5 == num|| 6 == num);

    }

    /**
     * areAllCardsTheSame will return true when given an array of all the same cards
     */
    @Test
    public void returnTrueWhenAllCardsAreTheSame(){
        Card[] card = new Card[]{new Card(2, Suit.Diamond), new Card(2, Suit.Club), new Card(2, Suit.Heart), new Card(2, Suit.Spade)};

        Assert.assertTrue("All cards are the same", turnState.areAllCardsTheSame(card));
    }

    /**
     * areAllCardsTheSame will return false when given an array of different cards
     */
    @Test
    public void returnFalseWhenCardsAreDifferent(){
        Card[] card = new Card[]{new Card(3, Suit.Diamond), new Card(2, Suit.Club), new Card(2, Suit.Heart), new Card(2, Suit.Spade)};

        Assert.assertFalse("The cards are not the same", turnState.areAllCardsTheSame(card));
    }

    /**
     * wasTurnALie will return true if cards all were not the same
     */
    @Test
    public void returnTrueLieWhenCardsAreDifferent(){
        game.turn = 1;
        Card[] card = new Card[]{new Card(3, Suit.Diamond), new Card(2, Suit.Club), new Card(2, Suit.Heart), new Card(2, Suit.Spade)};

        Assert.assertTrue("There was a lie when all cards are not the same", turnState.wasTurnALie(card));
    }

    /**
     * wasTurnALie will return false if cards are the same and last_card == -1
     */
    @Test
    public void returnFalseLieWhenCardsAreSameAndLast_CardIsAnything(){
        game.turn = 1;
        game.last_card = -1;
        Card[] card = new Card[]{new Card(2, Suit.Diamond), new Card(2, Suit.Club), new Card(2, Suit.Heart), new Card(2, Suit.Spade)};

        Assert.assertFalse("Return false when cards are the same and -1 is the last_card", turnState.wasTurnALie(card));
    }

    /**
     * wasTurnALie will return false if cards are the same and equal to either the last_card
     * last_card + 1 or last_card - 1
     */
    @Test
    public void returnFalseLieWhenCardsAreSameAndMoveValidWithLastCard(){
        game.turn = 1;
        game.last_card = 2;
        Card[] card = new Card[]{new Card(2, Suit.Diamond), new Card(2, Suit.Club), new Card(2, Suit.Heart), new Card(2, Suit.Spade)};

        Assert.assertFalse("Return false when cards are the same and the last card matches", turnState.wasTurnALie(card));

    }

    /**
     * wasTurnALie will return true if cards are the same and not valid with last_card
     */
    @Test
    public void returnTrueLieWhenCardsAreSameAndMoveNotValidWithLastCard(){
        game.turn = 1;
        game.last_card = 6;
        Card[] card = new Card[]{new Card(2, Suit.Diamond), new Card(2, Suit.Club), new Card(2, Suit.Heart), new Card(2, Suit.Spade)};

        Assert.assertTrue("Return true when cards are the same and the last card does not match", turnState.wasTurnALie(card));

    }

    /**
     * Having the user as the player for the turn will allow the user to play cards
     * The user cannot call Cheat
     */
    @Test
    public void userCanPlayCards()throws IllegalCardException{

    }

    /**
     * Having an opponent as the player will cause the opponent to play cards
     * The user will not call Cheat
     */
    @Test
    public void opponentPlayCardsNoCheatCalledByUser() throws IllegalCardException{

    }

    /**
     * Having an opponent as the player will cause the opponent to play cards
     * The user will call Cheat
     */
    @Test
    public void opponentPlayCardsCheatCalledByUser() throws IllegalCardException{

    }

    /**
     * The user will put down the last card without Cheat being called
     * and change the gameState to endGameState
     */
    @Test
    public void userPutsDownLastCardAndChangesGameState() throws IllegalCardException{

    }


}
