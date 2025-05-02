package study.spring.umc_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.umc_5.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
