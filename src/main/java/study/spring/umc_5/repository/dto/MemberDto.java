package study.spring.umc_5.repository.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class MemberDto {

    private Long memberId;

    private String name;

    private String email;

    private String phoneNumber;

    private Integer point;

    @QueryProjection
    public MemberDto(Long memberId, String name, String email, String phoneNumber, Integer point) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.point = point;
    }
}
