package game;

import card.Deck;
import card.DeckFactory;
import card.IllegalCardException;
import player.Opponent;
import player.OpponentFactory;
import player.User;
import player.UserFactory;

public class InitializeState implements GameState{

    Game game = null;
    GUIBuilder guiBuilder = new GUIBuilder();

    public InitializeState(Game game) throws IllegalCardException{
        this.game = game;
        implementStateResponsibilities();
    }

    @Override
    public void implementStateResponsibilities() throws IllegalCardException{
        game.turn = 0;
        game.cheat = false;
        game.lie = false;
        game.last_card = -1;

        game.deck = (Deck) guiBuilder.buildGroupOfCards(new DeckFactory());
        game.deck.initializeDeck();

        game.players[0] = (User) guiBuilder.buildPlayer(new UserFactory(), 0.0);
        game.players[1] = (Opponent) guiBuilder.buildPlayer(new OpponentFactory(), game.level * .1);
        game.players[2] = (Opponent) guiBuilder.buildPlayer(new OpponentFactory(), (game.level * .1) + .1);
        game.players[3] = (Opponent) guiBuilder.buildPlayer(new OpponentFactory(), (game.level * .1) + .2);

        game.deck.dealCards(game.players);

    }

}
