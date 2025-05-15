package study.spring.umc_5.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.umc_5.domain.Review;
import study.spring.umc_5.domain.Store;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateDto {
    private String body;
    private double score;

    public static Review toReview(ReviewCreateDto dto) {
        return Review.builder()
                .body(dto.getBody())
                .score(dto.getScore())
                .build();
    }
}
