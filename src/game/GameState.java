package game;

import card.IllegalCardException;

public interface GameState {

    void implementStateResponsibilities() throws IllegalCardException;
}
