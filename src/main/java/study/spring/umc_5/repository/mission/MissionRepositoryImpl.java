package study.spring.umc_5.repository.mission;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.Mission;
import study.spring.umc_5.domain.QMission;

import java.util.List;

import static study.spring.umc_5.domain.QMission.mission;

@Repository
@RequiredArgsConstructor
@Transactional
public class MissionRepositoryImpl implements CustomMissionRepository {


    private final JPAQueryFactory jpaQueryFactory;




    @Override
    public List<Mission> findAllChallengableMissions(Long regionId) {
        return List.of();
    }
}
