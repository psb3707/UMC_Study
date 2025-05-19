package study.spring.umc_5.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.apiPayload.code.status.ErrorStatus;
import study.spring.umc_5.apiPayload.exception.handler.FoodCategoryHandler;
import study.spring.umc_5.converter.MemberConverter;
import study.spring.umc_5.converter.MemberPreferConverter;
import study.spring.umc_5.domain.FoodCategory;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.mapping.MemberPrefer;
import study.spring.umc_5.repository.FoodCategoryRepository;
import study.spring.umc_5.repository.member.MemberRepository;
import study.spring.umc_5.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommnadServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category)
                            .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).toList();

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        memberRepository.save(newMember);

        return newMember;
    }
}
