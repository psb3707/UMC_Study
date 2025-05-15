package study.spring.umc_5.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.umc_5.domain.Mission;
import study.spring.umc_5.domain.Region;
import study.spring.umc_5.domain.Store;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MissionCreateDto {

    private int reward;
    private LocalDateTime deadline;
    private String missionSpec;

    public static Mission toMission(MissionCreateDto missionCreateDto, Region region, Store store) {
        Mission mission = Mission.builder()
                .reward(missionCreateDto.getReward())
                .deadline(missionCreateDto.getDeadline())
                .missionSpec(missionCreateDto.getMissionSpec())
                .build();

        mission.setRegion(region);
        mission.setStore(store);

        return mission;
    }
}
