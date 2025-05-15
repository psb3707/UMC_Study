package study.spring.umc_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.spring.umc_5.domain.mapping.MemberPrefer;

import java.util.List;

public interface MemberPreferRepository extends JpaRepository<MemberPrefer, Long> {

    @Modifying
    @Query("delete from MemberPrefer mp where mp.member.id = :memberId")
    void deleteByMemberId(@Param("memberId") Long memberId);

}
