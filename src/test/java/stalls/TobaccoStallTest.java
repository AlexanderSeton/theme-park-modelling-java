package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor youngVisitor;
    Visitor oldVisitor;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", 6, "Jack Jarvis", ParkingSpot.B1);
        youngVisitor = new Visitor(15, 1.65, 5.0);
        oldVisitor = new Visitor(49, 1.78, 45.5);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void hasAgeLimit() {
        assertEquals(false, tobaccoStall.isAllowedTo(youngVisitor));
        assertEquals(true, tobaccoStall.isAllowedTo(oldVisitor));
    }
}
