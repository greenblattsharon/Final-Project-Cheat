package player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpponentTester {
    Opponent opponent;

    @Before
    public void setup(){opponent = new Opponent(0);}

    /**
     * Constructing Opponent with a double intelligence
     */
    @Test
    public void initialIntelligence(){
        opponent = new Opponent(.1);
        assertTrue("Constructing opponent with double intelligence", .1 == opponent.getIntelligence());
    }


}
