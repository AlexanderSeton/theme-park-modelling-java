package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor youngVisitor;
    Visitor oldVisitor;
    Visitor tallVisitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        youngVisitor = new Visitor(15, 1.40, 5.0);
        oldVisitor = new Visitor(23, 1.78, 45.5);
        tallVisitor = new Visitor(27, 2.15, 55024);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void hasHeightLimit() {
        assertEquals(false, rollerCoaster.isAllowedTo(youngVisitor));
        assertEquals(true, rollerCoaster.isAllowedTo(oldVisitor));
    }

    @Test
    public void differentPriceForTallPeople() {
        assertEquals(8.4, rollerCoaster.priceFor(youngVisitor), 0.0);
        assertEquals(16.8, rollerCoaster.priceFor(tallVisitor), 0.0);
    }

    @Test
    public void hasDefaultTicketPrice() {
        assertEquals(8.4, rollerCoaster.defaultPrice(), 0.0);
    }
}
