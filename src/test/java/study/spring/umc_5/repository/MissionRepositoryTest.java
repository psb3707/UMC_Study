package study.spring.umc_5.repository;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.spring.umc_5.TestEntityFactory;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Mission;
import study.spring.umc_5.domain.Region;
import study.spring.umc_5.domain.Store;
import study.spring.umc_5.domain.enums.Gender;
import study.spring.umc_5.domain.enums.MemberStatus;
import study.spring.umc_5.domain.enums.MissionStatus;
import study.spring.umc_5.domain.mapping.MemberMission;
import study.spring.umc_5.repository.membermission.MemberMissionRepository;
import study.spring.umc_5.repository.mission.MissionRepository;
import study.spring.umc_5.repository.store.StoreRepository;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MissionRepositoryTest {

    @Autowired
    MissionRepository missionRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    MemberMissionRepository memberMissionRepository;


    @DisplayName("")
    @Test
    void myMissionWithPaging(){

        //given
        Member member = Member.builder()
                .name("박승범")
                .email("psb3707@naver.com")
                .specAddress("경기도 군포시 금산로 91")
                .memberStatus(MemberStatus.ACTIVE)
                .gender(Gender.MALE)
                .address("군포시")
                .build();

        Region region = Region.builder()
                .name("군포시")
                .build();

        Store store = Store.builder()
                .name("춘리마라탕")
                .address("경기도 군포시")
                .score(4.0f)
                .build();

        Mission mission1 = Mission.builder()
                        .reward(10000)
                        .missionSpec("밥 먹기")
                        .deadline(LocalDateTime.now())
                        .build();

        Mission mission2 = Mission.builder()
                .reward(10000)
                .missionSpec("밥 먹기")
                .deadline(LocalDateTime.now())
                .build();

        Mission mission3 = Mission.builder()
                .reward(10000)
                .missionSpec("밥 먹기")
                .deadline(LocalDateTime.now())
                .build();

        MemberMission memberMission1 = MemberMission.builder()
                .mission(mission1)
                .member(member)
                .missionStatus(MissionStatus.CHALLENGING)
                .build();

        MemberMission memberMission2 = MemberMission.builder()
                .mission(mission1)
                .member(member)
                .missionStatus(MissionStatus.CHALLENGING)
                .build();

        MemberMission memberMission3 = MemberMission.builder()
                .mission(mission1)
                .member(member)
                .missionStatus(MissionStatus.COMPLETE)
                .build();

        MemberMission memberMission4 = MemberMission.builder()
                .mission(mission1)
                .member(member)
                .missionStatus(MissionStatus.CHALLENGING)
                .build();

        MemberMission memberMission5 = MemberMission.builder()
                .mission(mission1)
                .member(member)
                .missionStatus(MissionStatus.CHALLENGING)
                .build();

        MemberMission memberMission6 = MemberMission.builder()
                .mission(mission1)
                .member(member)
                .missionStatus(MissionStatus.CHALLENGING)
                .build();

        MemberMission memberMission7 = MemberMission.builder()
                .mission(mission1)
                .member(member)
                .missionStatus(MissionStatus.CHALLENGING)
                .build();

        MemberMission memberMission8 = MemberMission.builder()
                .mission(mission1)
                .member(member)
                .missionStatus(MissionStatus.CHALLENGING)
                .build();

        mission1.setStore(store);
        mission2.setStore(store);
        mission3.setStore(store);


        store.setRegion(region);

        regionRepository.save(region);

        memberRepository.save(member);

        memberMissionRepository.saveAll(List.of(memberMission1, memberMission2, memberMission3, memberMission4,
                memberMission5, memberMission6, memberMission7, memberMission8));

        //when
        List<MemberMission> memberMissions1 = memberMissionRepository.findByMemberIdAndMissionStatus(member.getId(), MissionStatus.CHALLENGING, 3L);
        List<MemberMission> afterPaging = memberMissionRepository.findByMemberIdAndMissionStatusWithPaging(member.getId(), MissionStatus.CHALLENGING,
                3L, Long.valueOf(memberMissions1.size()));

        //then
        Assertions.assertThat(memberMissions1).hasSize(3)
                .extracting(memberMission -> Tuple.tuple(memberMission.getMember().getId(), memberMission.getMissionStatus()))
                .allSatisfy(tuple -> Assertions.assertThat(tuple).isEqualTo(Tuple.tuple(member.getId(), MissionStatus.CHALLENGING)));

        Assertions.assertThat(memberMissions1.get(0).getId()).isEqualTo(memberMission8.getId());
    }


    @DisplayName("")
    @Test
    void findByMemberIdAndMemberMissionStatus(){

        //given
        Member member = TestEntityFactory.createTestMember();

        Store store = TestEntityFactory.createTestStore();

        Region region = Region.builder()
                .name("군포시")
                .build();

        store.setRegion(region);

        Mission testMission1 = TestEntityFactory.createTestMission();
        Mission testMission2 = TestEntityFactory.createTestMission();
        Mission testMission3 = TestEntityFactory.createTestMission();

        testMission1.setStore(store);
        testMission2.setStore(store);
        testMission3.setStore(store);

        regionRepository.save(region);

        memberRepository.save(member);

        MemberMission testMemberMission1 = TestEntityFactory.createTestMemberMission(member, testMission1, MissionStatus.CHALLENGING);
        MemberMission testMemberMission2 = TestEntityFactory.createTestMemberMission(member, testMission2, MissionStatus.CHALLENGING);
        MemberMission testMemberMission3 = TestEntityFactory.createTestMemberMission(member, testMission3, MissionStatus.CHALLENGING);
        MemberMission testMemberMission4 = TestEntityFactory.createTestMemberMission(member, testMission1, MissionStatus.COMPLETE);
        MemberMission testMemberMission5 = TestEntityFactory.createTestMemberMission(member, testMission1, MissionStatus.CHALLENGING);
        MemberMission testMemberMission6 = TestEntityFactory.createTestMemberMission(member, testMission1, MissionStatus.COMPLETE);

        memberMissionRepository.saveAll(List.of(testMemberMission1, testMemberMission2, testMemberMission3,
                testMemberMission4, testMemberMission5, testMemberMission6));
        //when
        List<MemberMission> result = memberMissionRepository.findByMemberIdAndMemberMissionStatus(member.getId(), MissionStatus.CHALLENGING, 3L, null);

        //then
    }


    @DisplayName("")
    @Test
    void countCompletedMisisonsByRegionId(){

        //given
        Store store = TestEntityFactory.createTestStore();

        Region region = Region.builder()
                .name("군포시")
                .build();
        store.setRegion(region);

        Mission testMission1 = TestEntityFactory.createTestMission();
        Mission testMission2 = TestEntityFactory.createTestMission();
        Mission testMission3 = TestEntityFactory.createTestMission();

        testMission1.setStore(store);
        testMission2.setStore(store);
        testMission3.setStore(store);
        regionRepository.save(region);



        //when

        //then
    }


}