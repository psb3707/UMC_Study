package study.spring.umc_5.repository.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.TestEntityFactory;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.repository.dto.MemberDto;

import java.util.List;


@SpringBootTest
class MemberRepositoryImplTest {


    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("")
    @Test
    @Transactional
    @Rollback(false)
    void findByMemberId(){

        //given
        Member member = TestEntityFactory.createTestMember();
        Member member1 = TestEntityFactory.createTestMember();
        Member member2 = TestEntityFactory.createTestMember();
        Member member3 = TestEntityFactory.createTestMember();
        Member member4 = TestEntityFactory.createTestMember();
        Member member5 = TestEntityFactory.createTestMember();
        Member member6 = TestEntityFactory.createTestMember();
        Member member7 = TestEntityFactory.createTestMember();
        Member member8 = TestEntityFactory.createTestMember();
        Member member9 = TestEntityFactory.createTestMember();

        memberRepository.saveAll(List.of(member, member1, member2, member3, member4, member5, member6, member7, member8, member9));

        //when
        MemberDto memberDto = memberRepository.findByMemberId(member.getId());

        //then
        Assertions.assertThat(memberDto.getName()).isEqualTo(member.getName());
    }


    @DisplayName("")
    @Test
    @Transactional
    void test(){

        //given
        memberRepository.findAll().forEach(System.out::println);

        //when

        //then
    }
}