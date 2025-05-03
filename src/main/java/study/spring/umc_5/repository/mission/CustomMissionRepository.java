package study.spring.umc_5.repository.mission;

import study.spring.umc_5.domain.Mission;

import java.util.List;

public interface CustomMissionRepository {

    List<Mission> findAllChallengableMissions(Long regionId, Long memberId, Long lastMissionId, Long limit);
}
