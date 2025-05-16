package study.spring.umc_5.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Min(1000)
    private Integer reward;

    @NotNull
    private LocalDateTime deadline;

    @NotBlank
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
