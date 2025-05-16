package study.spring.umc_5.service.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.TestEntityFactory;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Mission;
import study.spring.umc_5.domain.Store;
import study.spring.umc_5.repository.RegionRepository;
import study.spring.umc_5.repository.member.MemberRepository;
import study.spring.umc_5.repository.mission.MissionRepository;
import study.spring.umc_5.repository.store.StoreRepository;


@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired private MemberService memberService;

    @Autowired private MemberRepository memberRepository;

    @Autowired private MissionRepository missionRepository;

    @DisplayName("사용자는 특정 미션에 도전할 수 있습니다.")
    @Test
    @Rollback(false)
    void challengeMission(){

        //given
        Member member = TestEntityFactory.createTestMember();

        Mission mission = TestEntityFactory.createTestMission();

        memberRepository.save(member);
        missionRepository.save(mission);

        //when
        Long memberMissionId = memberService.challengeMission(mission.getId());

        //then
        Assertions.assertThat(memberMissionId).isNotNull();
    }


    @DisplayName("")
    @Test
    @Rollback(false)
    void test(){

        //given
        Member member = TestEntityFactory.createTestMember();
        memberRepository.save(member);

        //when

        //then
    }
}