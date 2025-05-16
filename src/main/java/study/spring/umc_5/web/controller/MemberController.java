package study.spring.umc_5.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import study.spring.umc_5.apiPayload.ApiResponse;
import study.spring.umc_5.service.member.MemberService;
import study.spring.umc_5.validator.AlreadyChanllenging;

@RestController
@RequiredArgsConstructor
@Validated
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/members/missions/{missionId}")
    public ApiResponse<?> challengeMission(@AlreadyChanllenging @PathVariable Long missionId) {
        return ApiResponse.onSuccess(memberService.challengeMission(missionId));
    }
}
