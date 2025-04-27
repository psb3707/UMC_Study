package study.spring.umc_5.domain;

import jakarta.persistence.*;
import lombok.*;
import study.spring.umc_5.domain.common.BaseEntity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@Builder
public class Alarm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarm_type_id")
    private AlarmType alarmType;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 40)
    private String content;

    @Column(nullable = false)
    private boolean isRead;
}
