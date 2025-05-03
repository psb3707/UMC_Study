package study.spring.umc_5.repository.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.spring.umc_5.TestEntityFactory;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.repository.dto.MemberDto;


@SpringBootTest
class MemberRepositoryImplTest {


    @Autowired
    private MemberRepository memberRepository;


    @DisplayName("")
    @Test
    void findByMemberId(){

        //given
        Member member = TestEntityFactory.createTestMember();

        memberRepository.save(member);


        //when
        MemberDto memberDto = memberRepository.findByMemberId(member.getId());

        //then
        Assertions.assertThat(memberDto.getName()).isEqualTo(member.getName());
    }
}