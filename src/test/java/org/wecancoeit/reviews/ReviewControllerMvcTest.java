package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReviewController.class)
public class ReviewControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewRepository reviewRepo;

    @Mock
    private Review reviewOne;

    @Mock
    private Review reviewTwo;

    @Test
    public void shouldBeOkForAllReviewsInTheReviewTemplate() throws Exception {
        mockMvc.perform(get("/reviews")).andExpect(status().isOk())
                .andExpect(view().name("reviewsTemplate"));
    }

    @Test
    public void shouldFindAllReviewInModel() throws Exception {
        Collection<Review> allReviewsInModel = Arrays.asList(reviewOne, reviewTwo);
        when(reviewRepo.findAll()).thenReturn(allReviewsInModel);
        mockMvc.perform(get("/reviews"))
                .andExpect(model().attribute("reviewsModel", allReviewsInModel));
    }

    @Test
    public void shouldBeOkForOneReviewInTheReviewTemplate() throws Exception {
        Long reviewOneId = 1L;
        when(reviewRepo.findOne(reviewOneId)).thenReturn(reviewOne);
        mockMvc.perform(get("/review?id=1")).andExpect(status().isOk())
                .andExpect(view().name("reviewTemplate"));
    }

    @Test
    public void shouldFindReviewOneInModel() throws Exception {
        Long reviewOneId = 1L;
        when(reviewRepo.findOne(reviewOneId)).thenReturn(reviewOne);
        mockMvc.perform(get("/review?id=1"))
                .andExpect(model().attribute("reviewModel", reviewOne));
    }

    @Test
    public void shouldBeNotFoundForRequestNotInModel() throws Exception {
        Long reviewTwoId = 2L;
        when(reviewRepo.findOne(reviewTwoId)).thenReturn(reviewTwo);
        mockMvc.perform(get("/review?id=3")).andExpect(status().isNotFound());
    }
}
