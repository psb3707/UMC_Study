package study.spring.umc_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import study.spring.umc_5.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Modifying
    @Query("delete from Review r where r.member.id = :memberId")
    void deleteByMemberId(@Param("memberId") Long memberId);
}
