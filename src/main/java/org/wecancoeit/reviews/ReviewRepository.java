package org.wecancoeit.reviews;

import java.util.HashMap;
import java.util.Map;

public class ReviewRepository {

    Map<Long, Review> reviewsList = new HashMap<>();

    public ReviewRepository(Review review1) {
    }

    public Review findOne(long id) {
        return reviewsList.get(id);
    }
}
