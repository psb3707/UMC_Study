package study.spring.umc_5.domain;

import jakarta.persistence.*;
import lombok.*;
import study.spring.umc_5.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@Builder
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, length = 2000)
    private String body;

    @Column(nullable = false)
    private double score;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    @Builder.Default
    private List<ReviewImage> reviewImages = new ArrayList<>();
}
