package study.spring.umc_5.repository.member;

import study.spring.umc_5.domain.Member;
import study.spring.umc_5.repository.dto.MemberDto;

public interface CustomMemberRepository {

    MemberDto findByMemberId(Long memberId);

}
