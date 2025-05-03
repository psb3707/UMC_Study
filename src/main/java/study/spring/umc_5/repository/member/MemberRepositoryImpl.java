package study.spring.umc_5.repository.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.QMember;
import study.spring.umc_5.repository.dto.MemberDto;
import study.spring.umc_5.repository.dto.QMemberDto;

import static study.spring.umc_5.domain.QMember.member;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberRepositoryImpl implements CustomMemberRepository {

    private final JPAQueryFactory queryFactory;


    @Override
    public MemberDto findByMemberId(Long memberId) {
        return queryFactory.select(new QMemberDto(member.id, member.name, member.email,member.phoneNumber, member.point))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}
