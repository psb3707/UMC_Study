package study.spring.umc_5.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.umc_5.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository {

}
