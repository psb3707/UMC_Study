package study.spring.umc_5.service.review;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.spring.umc_5.repository.member.MemberRepository;
import study.spring.umc_5.repository.store.StoreRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewServiceTest {

    @Autowired private ReviewService reviewService;
    @Autowired private MemberRepository memberRepository;
    @Autowired private StoreRepository storeRepository;


    @DisplayName("")
    @Test
    void test(){

        //given

        //when

        //then
    }
}