package study.spring.umc_5.repository.store;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.QStore;
import study.spring.umc_5.domain.Store;

import java.util.List;

import static study.spring.umc_5.domain.QStore.store;

@Repository
@RequiredArgsConstructor
@Transactional
public class StoreRepositoryImpl implements CustomStoreRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {

        BooleanBuilder booleanBuilder = new BooleanBuilder();

         QStore qStore = store;

        if(name != null){
            booleanBuilder.and(qStore.name.eq(name));
        }

        if(score != null){
            booleanBuilder.and(qStore.score.goe(score));
        }

        return queryFactory.select(qStore).from(qStore).where(booleanBuilder).fetch();
    }

    @Override
    public List<Store> findByRegionId(Long regionId) {
        return queryFactory.selectFrom(store).where(store.region.id.eq(regionId)).fetch();
    }


}
