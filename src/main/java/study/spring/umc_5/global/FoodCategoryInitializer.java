package study.spring.umc_5.global;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.spring.umc_5.domain.FoodCategory;
import study.spring.umc_5.repository.FoodCategoryRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodCategoryInitializer {
    private final FoodCategoryRepository foodCategoryRepository;

    @PostConstruct
    public void init() {
        if (foodCategoryRepository.count() == 0) {
            FoodCategory category1 = FoodCategory.builder()
                    .name("한식")
                    .build();

            FoodCategory category2 = FoodCategory.builder()
                    .name("일식")
                    .build();

            FoodCategory category3 = FoodCategory.builder()
                    .name("중식")
                    .build();

            foodCategoryRepository.saveAll(List.of(category1, category2, category3));
        }
    }
}
