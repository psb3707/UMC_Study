package study.spring.umc_5.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.umc_5.domain.Region;
import study.spring.umc_5.domain.Store;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreCreateDto {
    @NotBlank
    private String name;
    @NotBlank
    private String address;

    public static Store toStore(StoreCreateDto dto, Region region) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .score(0.0f)
                .region(region)
                .build();
    }

}
