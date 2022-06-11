package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewRepositoryTest {

    private ReviewRepository underTest;
    private Review review1 = new Review(1L, "Movie Review1", "imgr.com/???1",
            "Movies", "This movie is not so good");
    private Review review2 = new Review(2L, "Food Review", "imgr.com/???2",
            "Food", "The food is okay");

    @Test
    public void shouldFindReview1(){
        underTest = new ReviewRepository(review1);
        Review foundReview = underTest.findOne(1L);
        assertEquals(review1, foundReview);
    }

    @Test
    public void shouldFindCourse1And2(){
        underTest = new ReviewRepository(review1, review2);
        Collection<Review> foundCourses = underTest.findAll();
        assertThat(foundCourses).contains(review1, review2);
    }

}
