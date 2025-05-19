package study.spring.umc_5.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.spring.umc_5.apiPayload.ApiResponse;
import study.spring.umc_5.converter.MemberConverter;
import study.spring.umc_5.service.member.MemberCommandService;
import study.spring.umc_5.service.member.MemberService;
import study.spring.umc_5.validator.AlreadyChanllenging;
import study.spring.umc_5.web.dto.MemberRequestDTO;
import study.spring.umc_5.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
public class MemberController {

    private final MemberService memberService;

    private final MemberCommandService memberCommandService;

    @PostMapping("/api/members/missions/{missionId}")
    public ApiResponse<?> challengeMission(@AlreadyChanllenging @PathVariable Long missionId) {
        return ApiResponse.onSuccess(memberService.challengeMission(missionId));
    }

    @PostMapping("/api/members")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        MemberResponseDTO.JoinResultDTO response = MemberConverter.toJoinResultDTO(memberCommandService.joinMember(request));
        return ApiResponse.onSuccess(response);
    }
}
