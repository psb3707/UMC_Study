package study.spring.umc_5.repository.membermission;

import study.spring.umc_5.domain.enums.MissionStatus;
import study.spring.umc_5.domain.mapping.MemberMission;

import java.util.List;

public interface CustomMemberMissionRepository {
    List<MemberMission> findByMemberIdAndMemberMissionStatus(Long memberId, MissionStatus missionStatus, Long limit,
                                                             Long lastMemberMissionId);

    long countCompletedMisisonsByRegionId(Long regionId);
}
