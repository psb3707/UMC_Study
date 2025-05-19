package study.spring.umc_5.service.member;

import study.spring.umc_5.domain.Member;
import study.spring.umc_5.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
