package com.example.service.ReviewService;

import com.example.domain.Review;
import com.example.repository.ReviewRepository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    public ReviewQueryServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer PageRequest){
        return reviewRepository.findAllByMemberId(memberId,PageRequest);
    }
}
