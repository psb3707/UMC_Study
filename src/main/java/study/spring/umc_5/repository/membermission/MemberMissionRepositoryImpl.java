package study.spring.umc_5.repository.membermission;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.QMember;
import study.spring.umc_5.domain.QRegion;
import study.spring.umc_5.domain.enums.MissionStatus;
import study.spring.umc_5.domain.mapping.MemberMission;

import java.util.List;
import java.util.Optional;

import static study.spring.umc_5.domain.QMember.member;
import static study.spring.umc_5.domain.QMission.mission;
import static study.spring.umc_5.domain.QRegion.region;
import static study.spring.umc_5.domain.QStore.store;
import static study.spring.umc_5.domain.mapping.QMemberMission.memberMission;

@Repository
@RequiredArgsConstructor
@Transactional
public class MemberMissionRepositoryImpl implements CustomMemberMissionRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberMission> findByMemberIdAndMemberMissionStatus(Long memberId, MissionStatus missionStatus, Long limit,
                                                                    Long lastMemberMissionId) {


        return queryFactory.selectFrom(memberMission)
                .join(memberMission.mission, mission).fetchJoin()
                .join(mission.store, store).fetchJoin()
                .where(
                        memberIdEq(memberId),
                        missionStatusEq(missionStatus),
                        lastMemberMissionIdLt(lastMemberMissionId)
                )
                .limit(limit)
                .orderBy(memberMission.id.desc())
                .fetch();

    }

    @Override
    public long countCompletedMisisonsByRegionId(Long regionId, Long memberId) {
        return Optional.ofNullable(queryFactory
                .select(memberMission.count())
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.region, region)
//                .join(mission.store, store)
//                .join(store.region, region)
                .where(
                        memberIdEq(memberId),
                        regionIdEq(regionId),
                        missionStatusEq(MissionStatus.COMPLETE)
                )
                .fetchOne()).orElse(0L);
    }

    private BooleanExpression regionIdEq(Long regionId) {

        if (regionId == null) {
            return null;
        }

//        return region.id.eq(regionId);
        return memberMission.mission.region.id.eq(regionId);
    }

    private Predicate lastMemberMissionIdLt(Long lastMemberMissionId) {
        if (lastMemberMissionId == null) {
            return null;
        }
        return memberMission.id.lt(lastMemberMissionId);
    }

    private BooleanExpression missionStatusEq(MissionStatus missionStatus) {

        if (missionStatus == null) {
            return null;
        }

        return memberMission.missionStatus.eq(missionStatus);
    }

    private Predicate memberIdEq(Long memberId) {

        if(memberId == null) return null;

        return memberMission.member.id.eq(memberId);
    }
}
