package study.spring.umc_5.repository.StoreRepository;

import study.spring.umc_5.domain.Store;

import java.util.List;

public interface CustomStoreRepository{
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
