package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReviewRepository {

    Map<Long, Review> reviewsList = new HashMap<>();

    public ReviewRepository() {
        Review review1 = new Review(1L, "Movie Review", "imgr.com/???1",
                "Movies", "This movie is not so good");
        Review review2 = new Review(2L, "Food Review", "imgr.com/???2",
                "Food", "The food is okay");
        Review review3 = new Review(3L, "Food Review2", "imgr.com/???3",
                "Food", "The food is pretty good");

        reviewsList.put(review1.getId(), review1);
        reviewsList.put(review2.getId(), review2);
        reviewsList.put(review2.getId(), review2);
    }

    public ReviewRepository(Review... reviewsToAdd) {
        for(Review review: reviewsToAdd){
            reviewsList.put(review.getId(), review);
        }
    }

    public Review findOne(long id) {
        return reviewsList.get(id);
    }

    public Collection<Review> findAll() {
        return reviewsList.values();
    }
}
