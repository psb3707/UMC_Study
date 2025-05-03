package study.spring.umc_5.repository.mission;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.*;
import study.spring.umc_5.domain.mapping.QMemberMission;

import java.util.List;

import static study.spring.umc_5.domain.QMember.*;
import static study.spring.umc_5.domain.QMission.*;
import static study.spring.umc_5.domain.QRegion.*;
import static study.spring.umc_5.domain.QStore.*;
import static study.spring.umc_5.domain.mapping.QMemberMission.*;


@Repository
@RequiredArgsConstructor
@Transactional
public class MissionRepositoryImpl implements CustomMissionRepository {


    private final JPAQueryFactory jpaQueryFactory;




    @Override
    public List<Mission> findAllChallengableMissions(Long regionId, Long memberId, Long lastMissionId, Long limit) {


        return jpaQueryFactory.select(mission)
                .from(mission)
                .where(
                        regionIdEq(regionId),
                        missionIdLt(lastMissionId),
                        JPAExpressions
                                .selectOne()
                                .from(memberMission)
                                .where(
                                        memberMission.mission.id.eq(mission.id),
                                        memberMission.member.id.eq(memberId)
                                )
                                .notExists()
                )
                .orderBy(mission.id.desc())
                .limit(limit)
                .fetch();
    }

    private BooleanExpression missionIdLt(Long lastMissionId) {

        if (lastMissionId == null) return null;
        return mission.id.lt(lastMissionId);
    }

    private BooleanExpression regionIdEq(Long regionId) {

        if (regionId == null) return null;
        return mission.region.id.eq(regionId);
    }
}
