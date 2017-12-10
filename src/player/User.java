package player;

import java.util.Collections;

public class User extends Player {

    public void sort(){
        Collections.sort(getHand().getCards());
    }
}
