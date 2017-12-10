package player;

import java.util.Collections;

public class User extends Player {

    public void sort(){
        Collections.sort(getHand().getCards());
    }

    @Override
    public int[] getCardsToPlay(int last_card) {
        getHand().printCards();
        return new int[0];
    }
}
