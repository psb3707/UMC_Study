package study.spring.umc_5.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.umc_5.domain.Review;
import study.spring.umc_5.domain.Store;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateDto {

    @NotBlank
    private String body;
    @NotNull
    private Double score;

    public static Review toReview(ReviewCreateDto dto) {
        return Review.builder()
                .body(dto.getBody())
                .score(dto.getScore())
                .build();
    }
}
