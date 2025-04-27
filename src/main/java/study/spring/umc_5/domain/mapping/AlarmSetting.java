package study.spring.umc_5.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import study.spring.umc_5.domain.AlarmType;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.common.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class AlarmSetting extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarm_type_id")
    private AlarmType alarmType;

    private boolean enabled;
}
