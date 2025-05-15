package study.spring.umc_5.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Mission;
import study.spring.umc_5.domain.mapping.MemberMission;
import study.spring.umc_5.repository.MemberPreferRepository;
import study.spring.umc_5.repository.member.MemberRepository;
import study.spring.umc_5.repository.mission.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    private final MissionRepository missionRepository;

    private final MemberPreferRepository memberPreferRepository;

    @Transactional
    public Long challengeMission(Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow();

        Member member = memberRepository.findById(1L)
                .orElseThrow();

        MemberMission memberMission = MemberMission.of(member, mission);

        memberRepository.save(member);

        return memberMission.getId();
    }

    @Transactional
    public void deleteMember(Long memberId) {
        memberPreferRepository.deleteByMemberId(memberId);
        memberRepository.deleteById(memberId);
    }
}
