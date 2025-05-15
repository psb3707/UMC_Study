package study.spring.umc_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.spring.umc_5.domain.Region;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    @Query("select r from Region r join fetch r.stores where r.name = :name")
    List<Region> findByName(@Param("name") String name);
}
