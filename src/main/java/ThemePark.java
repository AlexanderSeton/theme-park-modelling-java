import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;
    }

    public ArrayList<Attraction> getAttractions() {
        return this.attractions;
    }

    public ArrayList<Stall> getStalls() {
        return this.stalls;
    }

    public ArrayList<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> reviewedLocations = new ArrayList<>();
        reviewedLocations.addAll(this.attractions);
        reviewedLocations.addAll(this.stalls);
        return reviewedLocations;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addVisitedAttraction(attraction);
        attraction.increaseVisitCountBy1();
    }

    public HashMap<String, Integer> getReviews() {
        HashMap<String, Integer> reviews = new HashMap<>();
        for (int i=0; i<this.attractions.size(); i++) {
            reviews.put(this.attractions.get(i).getName(), this.attractions.get(i).getRating());
        }
        for (int i=0; i<this.stalls.size(); i++) {
            reviews.put(this.stalls.get(i).getName(), this.stalls.get(i).getRating());
        }
        return reviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allowedRides = new ArrayList<>();
        ArrayList<IReviewed> allReviewedRides = this.getAllReviewed();
        for (int i=0; i<allReviewedRides.size(); i++) {
            if (allReviewedRides.get(i) instanceof ISecurity) {
                if (((ISecurity) allReviewedRides.get(i)).isAllowedTo(visitor) == true) {
                    allowedRides.add(allReviewedRides.get(i));
                }
            }
            else {
                allowedRides.add(allReviewedRides.get(i));
            }
        }
        return allowedRides;
    }
}
