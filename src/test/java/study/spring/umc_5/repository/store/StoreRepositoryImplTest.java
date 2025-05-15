package study.spring.umc_5.repository.store;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
@Transactional
class StoreRepositoryImplTest {

//    @Autowired private CustomStoreRepository customStoreRepository;
    @Autowired private StoreRepository storeRepository;
    @Autowired private RegionRepository regionRepository;
    @PersistenceContext
    private EntityManager entityManager;


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
        Store store4 = TestEntityFactory.createTestStore();
        Store store5 = TestEntityFactory.createTestStore();
        Store store6 = TestEntityFactory.createTestStore();
        Store store7 = TestEntityFactory.createTestStore();
        Store store8 = TestEntityFactory.createTestStore();
        Store store9 = TestEntityFactory.createTestStore();

        Region region1 = Region.builder()
                .name("군포시")
                .build();

        Region region2 = Region.builder()
                .name("군포시")
                .build();

        Region region3 = Region.builder()
                .name("군포시")
                .build();

        store1.setRegion(region1);
        store2.setRegion(region1);
        store3.setRegion(region1);
        
        store4.setRegion(region2);
        store5.setRegion(region2);
        store6.setRegion(region2);
        
        store7.setRegion(region3);
        store8.setRegion(region3);
        store9.setRegion(region3);
        
        

        regionRepository.saveAll(List.of(region1, region2, region3));

        entityManager.flush();
        entityManager.clear();

//        storeRepository.saveAll(List.of(store1, store2, store3));

        //when
//        List<Region> regions = regionRepository.findAll();

        List<Region> regions = regionRepository.findByName("군포시");

        for (Region region : regions) {
            for (Store store : region.getStores()) {
                System.out.println("store.getName() = " + store.getName());
            }
        }
//        storeRepository.findByRegionId(region.getId());


        //then
    }
}