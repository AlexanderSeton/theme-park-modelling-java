import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Attr;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    private Dodgems dodgems;
    private Park park;
    protected Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private TobaccoStall tobaccoStall;
    private ThemePark themePark;
    private Visitor visitor;

    @Before
    public void before() {
        dodgems = new Dodgems("Dodgems", 7);
        park = new Park("Park", 5);
        playground = new Playground("Play Ground", 8);
        rollerCoaster = new RollerCoaster("Roller Coaster", 10);
        candyflossStall = new CandyflossStall("Candy Floss Stall", 7, "Tom Smith", ParkingSpot.A1);
        iceCreamStall = new IceCreamStall("Ice Cream Stall", 9, "Tim Jones", ParkingSpot.A2);
        tobaccoStall = new TobaccoStall("Tobacco Store", 5, "Philip Knight", ParkingSpot.A3);
        ArrayList<Attraction> attractions = new ArrayList<>(Arrays.asList(dodgems, park, playground, rollerCoaster));
        ArrayList<Stall> stalls = new ArrayList<>(Arrays.asList(candyflossStall, iceCreamStall, tobaccoStall));
        themePark = new ThemePark(attractions, stalls);
        visitor = new Visitor(20, 1.45, 100);
    }

    @Test
    public void hasAttractions() {
        ArrayList<Attraction> attractions = new ArrayList<>(Arrays.asList(dodgems, park, playground, rollerCoaster));
        assertEquals(attractions, themePark.getAttractions());
    }

    @Test
    public void hasStalls() {
        ArrayList<Stall> stalls = new ArrayList<>(Arrays.asList(candyflossStall, iceCreamStall, tobaccoStall));
        assertEquals(stalls, themePark.getStalls());
    }

    @Test
    public void canReturnListOfAllReviewedLocations() {
        ArrayList<IReviewed> reviewedLocations = new ArrayList<>();
        reviewedLocations.addAll(themePark.getAttractions());
        reviewedLocations.addAll(themePark.getStalls());
        assertEquals(reviewedLocations, themePark.getAllReviewed());
    }

    @Test
    public void visitorCanVisitAttraction() {
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, visitor.getVisitedAttractions().size());
        assertEquals(1, rollerCoaster.getVisitCount());
    }

    @Test
    public void themeParkCanReturnHashMapOfReviews() {
        String reviews = "{Candy Floss Stall=7, Tobacco Store=5, Roller Coaster=10, Play Ground=8, Ice Cream Stall=9, Dodgems=7, Park=5}";
        assertEquals(reviews, themePark.getReviews().toString());
    }

    @Test
    public void canCheckAllRidesAVisitorIsAllowedOn() {
        assertEquals(5, themePark.getAllAllowedFor(visitor).size());
    }
}
