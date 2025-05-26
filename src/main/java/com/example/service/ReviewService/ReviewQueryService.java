package com.example.service.ReviewService;

import com.example.domain.Review;
import org.springframework.data.domain.Page;

public interface ReviewQueryService {
    Page<Review> getMyReviewList(Long memberId, Integer page);
}
