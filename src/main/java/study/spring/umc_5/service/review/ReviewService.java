package study.spring.umc_5.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Review;
import study.spring.umc_5.domain.Store;
import study.spring.umc_5.repository.member.MemberRepository;
import study.spring.umc_5.repository.review.ReviewRepository;
import study.spring.umc_5.repository.store.StoreRepository;
import study.spring.umc_5.web.dto.ReviewCreateDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

    @Transactional
    public Long addReview(ReviewCreateDto reviewCreateDto, Long storeId) {

        Member member = memberRepository.findById(1L).orElseThrow();

        Store store = storeRepository.findById(storeId).orElseThrow();

        Review review = ReviewCreateDto.toReview(reviewCreateDto);

        review.setStore(store);
        review.setMember(member);

        return reviewRepository.save(review).getId();
    }
}
