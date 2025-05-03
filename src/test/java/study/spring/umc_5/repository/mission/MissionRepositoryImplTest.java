package study.spring.umc_5.repository.mission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.spring.umc_5.TestEntityFactory;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Mission;
import study.spring.umc_5.domain.Region;
import study.spring.umc_5.domain.enums.MissionStatus;
import study.spring.umc_5.domain.mapping.MemberMission;
import study.spring.umc_5.repository.member.MemberRepository;
import study.spring.umc_5.repository.RegionRepository;
import study.spring.umc_5.repository.membermission.MemberMissionRepository;

import java.util.List;

@SpringBootTest
class MissionRepositoryImplTest {

    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberMissionRepository memberMissionRepository;


    @DisplayName("")
    @Test
    void findAllChallengableMissions(){

        //given
        Member member = TestEntityFactory.createTestMember();

        Region region = TestEntityFactory.createTestRegion();

        Mission mission1 = TestEntityFactory.createTestMission();
        Mission mission2 = TestEntityFactory.createTestMission();
        Mission mission3 = TestEntityFactory.createTestMission();
        Mission mission4 = TestEntityFactory.createTestMission();
        Mission mission5 = TestEntityFactory.createTestMission();
        Mission mission6 = TestEntityFactory.createTestMission();

        mission1.setRegion(region);
        mission2.setRegion(region);
        mission3.setRegion(region);
        mission4.setRegion(region);
        mission5.setRegion(region);
        mission6.setRegion(region);

        regionRepository.save(region);

        memberRepository.save(member);

        MemberMission memberMission1 = TestEntityFactory.createTestMemberMission(member, mission1, MissionStatus.CHALLENGING);
        MemberMission memberMission2 = TestEntityFactory.createTestMemberMission(member, mission2, MissionStatus.CHALLENGING);
        MemberMission memberMission3 = TestEntityFactory.createTestMemberMission(member, mission3, MissionStatus.CHALLENGING);

        memberMissionRepository.saveAll(List.of(memberMission1, memberMission2, memberMission3));

        //when
        List<Mission> result = missionRepository.findAllChallengableMissions(region.getId(), member.getId(), null, 3L);

        //then
        Assertions.assertThat(result).hasSize(3);
    }
}