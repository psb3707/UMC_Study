package study.spring.umc_5.senior;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.FoodCategory;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.enums.Gender;
import study.spring.umc_5.domain.enums.MemberStatus;
import study.spring.umc_5.domain.mapping.MemberPrefer;
import study.spring.umc_5.repository.FoodCategoryRepository;
import study.spring.umc_5.repository.MemberPreferRepository;
import study.spring.umc_5.repository.member.MemberRepository;

import java.util.List;

@SpringBootTest
public class BatchDeleteTest {

    @Autowired
    private FoodCategoryRepository foodRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberPreferRepository memberPreferRepository;

    @PersistenceContext
    private EntityManager em;


    @DisplayName("")
    @Test
    @Commit
    void insertDummyData(){

        FoodCategory category1 = FoodCategory.builder()
                .name("양식")
                .build();

        FoodCategory category2 = FoodCategory.builder()
                .name("일식")
                .build();

        FoodCategory category3 = FoodCategory.builder()
                .name("한식")
                .build();

        foodRepository.saveAll(List.of(category1, category2, category3));

        Member member = Member.builder()
                .name("박승범")
                .address("경기도 군포시")
                .email("psb3707@naver.com")
                .gender(Gender.MALE)
                .memberStatus(MemberStatus.ACTIVE)
                .specAddress("래미안하이어스 120동 2903호")
                .build();

        memberRepository.save(member);

        MemberPrefer memberPrefer1 = createMemberPrefer(member, category1);
        MemberPrefer memberPrefer2 = createMemberPrefer(member, category2);
        MemberPrefer memberPrefer3 = createMemberPrefer(member, category3);

        memberPreferRepository.saveAll(List.of(memberPrefer1, memberPrefer2, memberPrefer3));
    }

    @DisplayName("멤버를 삭제하면 그와 연관된 모든 테이블을 한번에 삭제한다.")
    @Test
    @Transactional
    @Commit
    void deleteMemberWithBatchDelete(){


        memberPreferRepository.deleteByMemberId(11L);

        memberRepository.deleteById(11L);

    }

    private MemberPrefer createMemberPrefer(Member member, FoodCategory category) {
        MemberPrefer prefer = MemberPrefer.builder()
                .member(member)
                .foodCategory(category)
                .build();

        prefer.addMember(member);

        return prefer;
    }
}
