package study.spring.umc_5.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import study.spring.umc_5.domain.FoodCategory;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.common.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

    public void addMember(Member member) {
        this.member = member;
        member.getMemberPrefers().add(this);
    }
}
