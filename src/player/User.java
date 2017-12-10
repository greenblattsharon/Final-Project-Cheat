package player;

import java.util.Collections;

public class User extends Player {


    @Override
    public int[] getCardsToPlay(int card_number) {
        return new int[0];
    }

    public void sort(){
        Collections.sort(getHand().getCards());
    }
}
