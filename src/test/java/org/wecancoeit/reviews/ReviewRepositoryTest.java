package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewRepositoryTest {

    private ReviewRepository underTest;
    private Review review1 = new Review(1L, "Movie Review1", "imgr.com/???1",
            "Movies", "This movie is not so good");
    private Review review2 = new Review(2L, "Food Review", "imgr.com/???2",
            "Food", "The food is okay");

    @Test
    public void shouldFindCourseOne(){
        underTest = new ReviewRepository(review1);
        Review foundReview = underTest.findOne(1L);
        assertEquals(review1, foundReview);
    }

}
