package study.spring.umc_5.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.spring.umc_5.apiPayload.ApiResponse;
import study.spring.umc_5.service.review.ReviewService;
import study.spring.umc_5.validator.ExistStore;
import study.spring.umc_5.web.dto.ReviewCreateDto;

@RestController
@RequiredArgsConstructor
@Validated
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/api/stores/{storeId}/reviews")
    public ApiResponse<?> addReview(@ExistStore @PathVariable("storeId") Long storeId,
                                    @RequestBody ReviewCreateDto reviewCreateDto) {
        return ApiResponse.onSuccess(reviewService.addReview(reviewCreateDto, storeId));
    }
}
