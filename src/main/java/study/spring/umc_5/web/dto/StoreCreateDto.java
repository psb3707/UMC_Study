package study.spring.umc_5.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.umc_5.domain.Region;
import study.spring.umc_5.domain.Store;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreCreateDto {
    private String name;
    private String address;
    private Long regionId;

    public static Store toStore(StoreCreateDto dto, Region region) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .score(0.0f)
                .region(region)
                .build();
    }

}
