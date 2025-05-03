package study.spring.umc_5.repository.store;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.TestEntityFactory;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Region;
import study.spring.umc_5.domain.Store;
import study.spring.umc_5.repository.RegionRepository;

import java.util.List;

@SpringBootTest
class StoreRepositoryImplTest {

//    @Autowired private CustomStoreRepository customStoreRepository;
    @Autowired private StoreRepository storeRepository;
    @Autowired private RegionRepository regionRepository;


    @DisplayName("QueryDSL을 활용한 동적 쿼리 작성")
    @Test
    @Transactional
    void dynamicQuery() {

        //given
        Store store1 = Store.builder()
                .name("춘리마라탕")
                .score(4.0f)
                .address("경기도")
                .build();
        Store store2 = Store.builder()
                .name("춘리마라탕")
                .address("경기도")
                .score(3.0f)
                .build();
        Store store3 = Store.builder()
                .address("경기도")
                .name("코딩치킨")
                .score(4.0f)
                .build();

        storeRepository.saveAll(List.of(store1, store2, store3));

        //when
        List<Store> result = storeRepository.dynamicQueryWithBooleanBuilder("춘리마라탕",4.0f);

        //then
        Assertions.assertThat(result).hasSize(1)
                .extracting(Store::getName, Store::getScore)
                .containsExactly(Tuple.tuple("춘리마라탕", 4.0f));
    }


    @DisplayName("")
    @Test
    void test(){

        //given
        Store store1 = TestEntityFactory.createTestStore();
        Store store2 = TestEntityFactory.createTestStore();
        Store store3 = TestEntityFactory.createTestStore();

        Region region = Region.builder()
                .name("군포시")
                .build();

        store1.setRegion(region);
        store2.setRegion(region);
        store3.setRegion(region);

        regionRepository.save(region);

//        storeRepository.saveAll(List.of(store1, store2, store3));

        //when
        storeRepository.findByRegionId(region.getId());


        //then
    }
}