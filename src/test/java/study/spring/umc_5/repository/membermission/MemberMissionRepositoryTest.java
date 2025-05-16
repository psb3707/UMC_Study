package study.spring.umc_5.repository.membermission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.TestEntityFactory;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Mission;
import study.spring.umc_5.domain.enums.MissionStatus;
import study.spring.umc_5.domain.mapping.MemberMission;
import study.spring.umc_5.repository.member.MemberRepository;
import study.spring.umc_5.repository.mission.MissionRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberMissionRepositoryTest {

    @Autowired
    MemberMissionRepository memberMissionRepository;
    @Autowired
    MissionRepository missionRepository;
    @Autowired
    MemberRepository memberRepository;

    @DisplayName("")
    @Test
    void test(){

        //given
        Mission mission = TestEntityFactory.createTestMission();

        missionRepository.save(mission);

        Member member = TestEntityFactory.createTestMember();
        memberRepository.save(member);

        MemberMission memberMission = MemberMission.builder()
                .mission(mission)
                .member(member)
                .missionStatus(MissionStatus.CHALLENGING)
                .build();

        memberMissionRepository.save(memberMission);

        //when
        Optional<MemberMission> byMissionId = memberMissionRepository.findByMissionId(mission.getId());

        //then
        Assertions.assertThat(byMissionId).isPresent();
    }
}