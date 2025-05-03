package study.spring.umc_5.senior;

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
public class OrphanRemovalTest {

    @Autowired
    private FoodCategoryRepository foodRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberPreferRepository memberPreferRepository;

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

    @DisplayName("orphanRemoval = true 옵션을 통한 선호 음식 리스트에서 특정 선호 음식 선호 내역 삭제 ")
    @Test
    @Transactional
    @Commit
    void orphanRemovalTest(){

        //given
        Member member = memberRepository.findById(8L).get();
        FoodCategory foodCategory = foodRepository.findById(22L).get();

        member.removePrefer(foodCategory);
        //when

        //then
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
