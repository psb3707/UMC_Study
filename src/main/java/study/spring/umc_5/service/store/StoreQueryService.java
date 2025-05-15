package study.spring.umc_5.service.store;

import study.spring.umc_5.domain.Store;
import study.spring.umc_5.web.dto.StoreCreateDto;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Long addStore(StoreCreateDto storeCreateDto);
}
