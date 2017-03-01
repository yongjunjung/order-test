package test.order.test;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderReserved is a Querydsl query type for OrderReserved
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderReserved extends EntityPathBase<OrderReserved> {

    private static final long serialVersionUID = 226296982L;

    public static final QOrderReserved orderReserved = new QOrderReserved("orderReserved");

    public final test.order.common.QAbstractTimestamp _super = new test.order.common.QAbstractTimestamp(this);

    public final StringPath orderNo = createString("orderNo");

    public final NumberPath<Long> orderReservedSeq = createNumber("orderReservedSeq", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> registerDatetime = _super.registerDatetime;

    public final StringPath reservedNo = createString("reservedNo");

    public final EnumPath<ReservedStatus> status = createEnum("status", ReservedStatus.class);

    //inherited
    public final DateTimePath<java.util.Date> updateDatetime = _super.updateDatetime;

    public QOrderReserved(String variable) {
        super(OrderReserved.class, forVariable(variable));
    }

    public QOrderReserved(Path<? extends OrderReserved> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderReserved(PathMetadata metadata) {
        super(OrderReserved.class, metadata);
    }

}

