package study.spring.umc_5.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlarmType is a Querydsl query type for AlarmType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlarmType extends EntityPathBase<AlarmType> {

    private static final long serialVersionUID = 918269066L;

    public static final QAlarmType alarmType = new QAlarmType("alarmType");

    public final study.spring.umc_5.domain.common.QBaseEntity _super = new study.spring.umc_5.domain.common.QBaseEntity(this);

    public final ListPath<Alarm, QAlarm> alarms = this.<Alarm, QAlarm>createList("alarms", Alarm.class, QAlarm.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<study.spring.umc_5.domain.enums.SendType> sendType = createEnum("sendType", study.spring.umc_5.domain.enums.SendType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAlarmType(String variable) {
        super(AlarmType.class, forVariable(variable));
    }

    public QAlarmType(Path<? extends AlarmType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlarmType(PathMetadata metadata) {
        super(AlarmType.class, metadata);
    }

}

