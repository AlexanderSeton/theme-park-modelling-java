package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor youngVisitor;
    Visitor oldVisitor;
    Visitor tallVisitor;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        youngVisitor = new Visitor(8, 1.40, 5.0);
        oldVisitor = new Visitor(23, 1.78, 45.5);
        tallVisitor = new Visitor(27, 2.15, 55024);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void differentPriceForTallPeople() {
        assertEquals(2.25, dodgems.priceFor(youngVisitor), 0.0);
        assertEquals(4.5, dodgems.priceFor(tallVisitor), 0.0);
    }

    @Test
    public void hasDefaultTicketPrice() {
        assertEquals(4.5, dodgems.defaultPrice(), 0.0);
    }
}
