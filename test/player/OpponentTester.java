package player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpponentTester {
    Opponent opponent;

    @Before
    public void setup(){opponent = new Opponent(0);}

    /**
     * Constructing Opponent using Factory
     */
    @Test
    public void correctInstanceFromFactory(){
        OpponentFactory of = new OpponentFactory();
        Opponent fromFactory = of.createPlayer(.1);
        Assert.assertTrue(fromFactory instanceof Opponent);
    }

    /**
     * Constructing Opponent with a double intelligence
     */
    @Test
    public void initialIntelligence(){
        opponent = new Opponent(.1);
        assertTrue("Constructing opponent with double intelligence", .1 == opponent.getIntelligence());
    }


}
