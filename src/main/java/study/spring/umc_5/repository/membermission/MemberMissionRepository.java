package study.spring.umc_5.repository.membermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.enums.MissionStatus;
import study.spring.umc_5.domain.mapping.MemberMission;

import java.util.List;
import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, CustomMemberMissionRepository {

    @Query("select mm from MemberMission mm join fetch mm.mission join fetch mm.mission.store" +
            " where mm.member.id = :memberId and mm.missionStatus = :missionStatus order by mm.id desc limit :limit")
    List<MemberMission> findByMemberIdAndMissionStatus(@Param("memberId") Long memberId,
                                                       @Param("missionStatus") MissionStatus missionStatus,
                                                       @Param("limit") Long limit);

    @Query("select mm from MemberMission mm join fetch mm.mission join fetch mm.mission.store" +
            " where mm.member.id = :memberId and mm.missionStatus = :missionStatus and mm.id < :lastMemberMissionId order by mm.id desc limit :limit")
    List<MemberMission> findByMemberIdAndMissionStatusWithPaging(@Param("memberId") Long memberId,
                                                       @Param("missionStatus") MissionStatus missionStatus,
                                                       @Param("limit") Long limit,
                                                       @Param("lastMemberMissionId") Long lastMemberMissionId);

    Optional<MemberMission> findByMissionId(Long missionId);
}
