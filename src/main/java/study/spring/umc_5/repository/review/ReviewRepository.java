package study.spring.umc_5.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.umc_5.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
