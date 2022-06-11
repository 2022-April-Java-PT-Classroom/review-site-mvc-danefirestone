package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewRepositoryTest {

    private ReviewRepository underTest;
    private Review reviewOne = new Review(1L, "Movie Review1", "imgr.com/???1",
            "Movies", "This movie is not so good");
    private Review reviewTwo = new Review(2L, "Food Review", "imgr.com/???2",
            "Food", "The food is okay");

    @Test
    public void shouldFindReviewOne(){
        underTest = new ReviewRepository(reviewOne);
        Review foundReview = underTest.findOne(1L);
        assertEquals(reviewOne, foundReview);
    }

}
