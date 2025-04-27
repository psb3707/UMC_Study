package study.spring.umc_5.domain;

import jakarta.persistence.*;
import lombok.*;
import study.spring.umc_5.domain.common.BaseEntity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@Builder
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false)
    private double score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
}
