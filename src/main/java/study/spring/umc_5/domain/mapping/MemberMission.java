package study.spring.umc_5.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Mission;
import study.spring.umc_5.domain.common.BaseEntity;
import study.spring.umc_5.domain.enums.MissionStatus;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MissionStatus missionStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public static MemberMission of(Member member, Mission mission) {
        MemberMission memberMission = MemberMission.builder()
                .missionStatus(MissionStatus.CHALLENGING)
                .build();
        memberMission.setMember(member);
        return memberMission;
    }

    private void setMember(Member member) {
        this.member = member;
        member.getMemberMissions().add(this);
    }
}
