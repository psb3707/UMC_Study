package study.spring.umc_5.service.store;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.spring.umc_5.TestEntityFactory;
import study.spring.umc_5.domain.Region;
import study.spring.umc_5.repository.RegionRepository;
import study.spring.umc_5.web.dto.StoreCreateDto;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreQueryServiceImplTest {

    @Autowired private StoreQueryService storeQueryService;
    @Autowired private RegionRepository regionRepository;


    @DisplayName("특정 지역에 가게를 추가할 수 있다.")
    @Test
    void addStore(){

        //given
        Region region = regionRepository.save(TestEntityFactory.createTestRegion());

        StoreCreateDto storeCreateDto = new StoreCreateDto("춘리마라탕", "경기도 군포시 산본동", region.getId());

        //when
        Long savedStoreId = storeQueryService.addStore(storeCreateDto);

        //then
        Assertions.assertThat(savedStoreId).isNotNull();
    }
}