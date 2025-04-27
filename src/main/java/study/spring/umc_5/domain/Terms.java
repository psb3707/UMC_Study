package study.spring.umc_5.domain;

import jakarta.persistence.*;
import lombok.*;
import study.spring.umc_5.domain.common.BaseEntity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@Builder
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 2000)
    private String body;

    @Column(nullable = false)
    private boolean optional;
}
