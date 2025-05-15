package study.spring.umc_5.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.Region;
import study.spring.umc_5.domain.Store;
import study.spring.umc_5.repository.RegionRepository;
import study.spring.umc_5.repository.store.StoreRepository;
import study.spring.umc_5.web.dto.StoreCreateDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> stores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        stores.forEach(store -> System.out.println("Store: " + store));

        return stores;
    }

    @Override
    @Transactional
    public Long addStore(StoreCreateDto storeCreateDto) {

        Region region = regionRepository.findById(storeCreateDto.getRegionId())
                .orElseThrow();

        Store store = storeRepository.save(StoreCreateDto.toStore(storeCreateDto, region));
        return store.getId();
    }
}
