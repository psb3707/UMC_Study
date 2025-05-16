package study.spring.umc_5.service.mission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.TestEntityFactory;
import study.spring.umc_5.domain.Region;
import study.spring.umc_5.domain.Store;
import study.spring.umc_5.repository.RegionRepository;
import study.spring.umc_5.repository.store.StoreRepository;
import study.spring.umc_5.web.dto.MissionCreateDto;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MissionServiceTest {

    @Autowired private MissionService missionService;

    @Autowired private RegionRepository regionRepository;


    @DisplayName("특정 가게에 미션을 추가할 수 있다.")
    @Test
    @Rollback(false)
    void addMission(){

        //given
        Store store = TestEntityFactory.createTestStore();

        Region region = TestEntityFactory.createTestRegion();

        store.setRegion(region);

        regionRepository.save(region);

        MissionCreateDto missionCreateDto = new MissionCreateDto(1000, LocalDateTime.now(), "밥 10000원어치 사먹기");

        //when
        Long savedMissionId = missionService.addMission(missionCreateDto, store.getId());

        //then
        Assertions.assertThat(savedMissionId).isNotNull();
    }

}