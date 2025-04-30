package study.spring.umc_5.repository.StoreRepository;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.Store;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreRepositoryImplTest {

    @Autowired private CustomStoreRepository customStoreRepository;
    @Autowired private StoreRepository storeRepository;


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
        List<Store> result = customStoreRepository.dynamicQueryWithBooleanBuilder("춘리마라탕",4.0f);

        //then
        Assertions.assertThat(result).hasSize(1)
                .extracting(Store::getName, Store::getScore)
                .containsExactly(Tuple.tuple("춘리마라탕", 4.0f));
    }
}