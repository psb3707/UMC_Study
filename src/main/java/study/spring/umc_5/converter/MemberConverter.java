package study.spring.umc_5.converter;

import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.enums.Gender;
import study.spring.umc_5.web.dto.MemberRequestDTO;
import study.spring.umc_5.web.dto.MemberResponseDTO;

import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt()).build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPrefers(new ArrayList<>())
                .build();

    }
}
