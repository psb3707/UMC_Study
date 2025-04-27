package study.spring.umc_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import study.spring.umc_5.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
