package study.spring.umc_5.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlarmSetting is a Querydsl query type for AlarmSetting
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlarmSetting extends EntityPathBase<AlarmSetting> {

    private static final long serialVersionUID = -723398880L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlarmSetting alarmSetting = new QAlarmSetting("alarmSetting");

    public final study.spring.umc_5.domain.common.QBaseEntity _super = new study.spring.umc_5.domain.common.QBaseEntity(this);

    public final study.spring.umc_5.domain.QAlarmType alarmType;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final BooleanPath enabled = createBoolean("enabled");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final study.spring.umc_5.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAlarmSetting(String variable) {
        this(AlarmSetting.class, forVariable(variable), INITS);
    }

    public QAlarmSetting(Path<? extends AlarmSetting> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlarmSetting(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlarmSetting(PathMetadata metadata, PathInits inits) {
        this(AlarmSetting.class, metadata, inits);
    }

    public QAlarmSetting(Class<? extends AlarmSetting> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.alarmType = inits.isInitialized("alarmType") ? new study.spring.umc_5.domain.QAlarmType(forProperty("alarmType")) : null;
        this.member = inits.isInitialized("member") ? new study.spring.umc_5.domain.QMember(forProperty("member")) : null;
    }

}

