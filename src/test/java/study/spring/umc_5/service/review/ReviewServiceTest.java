package study.spring.umc_5.service.review;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.spring.umc_5.TestEntityFactory;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Review;
import study.spring.umc_5.domain.Store;
import study.spring.umc_5.repository.member.MemberRepository;
import study.spring.umc_5.repository.store.StoreRepository;
import study.spring.umc_5.web.dto.ReviewCreateDto;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewServiceTest {

    @Autowired private ReviewService reviewService;
    @Autowired private MemberRepository memberRepository;
    @Autowired private StoreRepository storeRepository;


    @DisplayName("사용자는 특정 가게에 리뷰를 추가할 수 있다.")
    @Test
    void addReview(){

        //given
        Member member = TestEntityFactory.createTestMember();
        Store store = TestEntityFactory.createTestStore();

        memberRepository.save(member);
        storeRepository.save(store);

        ReviewCreateDto dto = new ReviewCreateDto("맛있어요", 4.0);

        //when
        Long savedReviewId = reviewService.addReview(dto, store.getId());

        //then
        Assertions.assertNotNull(savedReviewId);
    }
}