package study.spring.umc_5.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.spring.umc_5.apiPayload.ApiResponse;
import study.spring.umc_5.service.store.StoreQueryService;
import study.spring.umc_5.web.dto.StoreCreateDto;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreQueryService storeQueryService;

    @PostMapping("/api/regions/{regionId}/stores")
    public ApiResponse<?> addStore(@PathVariable("regionId") Long regionId,
                                   @Valid @RequestBody StoreCreateDto storeCreateDto) {
        return ApiResponse.onSuccess(storeQueryService.addStore(regionId, storeCreateDto));
    }
}
