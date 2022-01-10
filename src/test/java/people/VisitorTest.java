package people;

import attractions.Dodgems;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    Dodgems dodgems;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        dodgems = new Dodgems("Bumper Cars", 5);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void hasVisitedAttractionList() {
        assertEquals(0, visitor.getVisitedAttractions().size());
    }

    @Test
    public void canAddVisitedAttraction() {
        visitor.addVisitedAttraction(dodgems);
        assertEquals(1, visitor.getVisitedAttractions().size());
    }
}
