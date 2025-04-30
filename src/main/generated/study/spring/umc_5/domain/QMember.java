package study.spring.umc_5.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1017307237L;

    public static final QMember member = new QMember("member1");

    public final study.spring.umc_5.domain.common.QBaseEntity _super = new study.spring.umc_5.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<study.spring.umc_5.domain.enums.Gender> gender = createEnum("gender", study.spring.umc_5.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<study.spring.umc_5.domain.mapping.MemberAgree, study.spring.umc_5.domain.mapping.QMemberAgree> memberAgreeList = this.<study.spring.umc_5.domain.mapping.MemberAgree, study.spring.umc_5.domain.mapping.QMemberAgree>createList("memberAgreeList", study.spring.umc_5.domain.mapping.MemberAgree.class, study.spring.umc_5.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<study.spring.umc_5.domain.mapping.MemberMission, study.spring.umc_5.domain.mapping.QMemberMission> memberMissionList = this.<study.spring.umc_5.domain.mapping.MemberMission, study.spring.umc_5.domain.mapping.QMemberMission>createList("memberMissionList", study.spring.umc_5.domain.mapping.MemberMission.class, study.spring.umc_5.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<study.spring.umc_5.domain.mapping.MemberPrefer, study.spring.umc_5.domain.mapping.QMemberPrefer> memberPreferList = this.<study.spring.umc_5.domain.mapping.MemberPrefer, study.spring.umc_5.domain.mapping.QMemberPrefer>createList("memberPreferList", study.spring.umc_5.domain.mapping.MemberPrefer.class, study.spring.umc_5.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final EnumPath<study.spring.umc_5.domain.enums.MemberStatus> memberStatus = createEnum("memberStatus", study.spring.umc_5.domain.enums.MemberStatus.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<study.spring.umc_5.domain.enums.SocialType> socialType = createEnum("socialType", study.spring.umc_5.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

