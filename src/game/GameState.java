package game;

import card.IllegalCardException;
import player.IllegalMoveException;

public interface GameState {

    void implementStateResponsibilities() throws IllegalCardException, IllegalMoveException;
}
