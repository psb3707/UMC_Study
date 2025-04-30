package study.spring.umc_5.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.umc_5.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
