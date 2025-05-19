package study.spring.umc_5.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import study.spring.umc_5.domain.common.BaseEntity;
import study.spring.umc_5.domain.enums.Gender;
import study.spring.umc_5.domain.enums.MemberStatus;
import study.spring.umc_5.domain.enums.SocialType;
import study.spring.umc_5.domain.mapping.MemberAgree;
import study.spring.umc_5.domain.mapping.MemberMission;
import study.spring.umc_5.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@Builder
@DynamicUpdate
@DynamicInsert
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    private String phoneNumber;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus memberStatus;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private LocalDate inactiveDate;

    private String email;

    @ColumnDefault("0")
    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberAgree> memberAgrees = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberPrefer> memberPrefers = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();

    public void removePrefer(FoodCategory foodCategory) {
        memberPrefers.removeIf(m -> m.getFoodCategory().equals(foodCategory));
    }

}
