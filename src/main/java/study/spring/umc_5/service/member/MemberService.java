package study.spring.umc_5.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Mission;
import study.spring.umc_5.domain.mapping.MemberMission;
import study.spring.umc_5.repository.MemberPreferRepository;
import study.spring.umc_5.repository.member.MemberRepository;
import study.spring.umc_5.repository.membermission.MemberMissionRepository;
import study.spring.umc_5.repository.mission.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    private final MissionRepository missionRepository;

    private final MemberPreferRepository memberPreferRepository;

    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public Long challengeMission(Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalCallerException("미션이 없습니다."));

        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new IllegalCallerException("회원이 없습니다."));

        MemberMission memberMission = MemberMission.of(member, mission);

        memberMissionRepository.save(memberMission);

        return memberMission.getId();
    }

    @Transactional
    public void deleteMember(Long memberId) {
        memberPreferRepository.deleteByMemberId(memberId);
        memberRepository.deleteById(memberId);
    }
}
