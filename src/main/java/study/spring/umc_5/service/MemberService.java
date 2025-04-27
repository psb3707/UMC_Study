package study.spring.umc_5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.spring.umc_5.repository.MemberPreferRepository;
import study.spring.umc_5.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberPreferRepository memberPreferRepository;

    public void deleteMember(Long memberId) {
        memberPreferRepository.deleteByMemberId(memberId);
        memberRepository.deleteById(memberId);
    }
}
