package study.spring.umc_5.service.memberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.repository.membermission.MemberMissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;

    public boolean isChallengingMission(Long missionId) {
        return memberMissionRepository.findByMissionId(missionId).isEmpty();
    }

}
