package study.spring.umc_5;

import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Mission;
import study.spring.umc_5.domain.Region;
import study.spring.umc_5.domain.Store;
import study.spring.umc_5.domain.enums.Gender;
import study.spring.umc_5.domain.enums.MemberStatus;
import study.spring.umc_5.domain.enums.MissionStatus;
import study.spring.umc_5.domain.mapping.MemberMission;

import java.time.LocalDateTime;

public class TestEntityFactory {

    public static Member createTestMember() {

        return Member.builder()
                .name("박승범")
                .email("psb3707@naver.com")
                .specAddress("경기도 군포시 금산로 91")
                .memberStatus(MemberStatus.ACTIVE)
                .gender(Gender.MALE)
                .address("군포시")
                .build();
    }

    public static Store createTestStore() {
        return Store.builder()
                .name("춘리마라탕")
                .address("경기도 군포시")
                .score(4.0f)
                .build();
    }


    public static Mission createTestMission() {
        return Mission.builder()
                .reward(10000)
                .missionSpec("밥 먹기")
                .deadline(LocalDateTime.now())
                .build();
    }

    public static MemberMission createTestMemberMission(Member member, Mission mission, MissionStatus missionStatus) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .missionStatus(missionStatus)
                .build();
    }


}
