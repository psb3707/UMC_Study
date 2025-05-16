package study.spring.umc_5.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.spring.umc_5.apiPayload.ApiResponse;
import study.spring.umc_5.service.mission.MissionService;
import study.spring.umc_5.web.dto.MissionCreateDto;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/api/stores/{storeId}/missions")
    public ApiResponse<?> addMission(@PathVariable("storeId") Long storeId, @Valid @RequestBody MissionCreateDto missionCreateDto) {
        return ApiResponse.onSuccess(missionService.addMission(missionCreateDto, storeId));
    }
}
