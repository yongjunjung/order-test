package test.order.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderDetail is a Querydsl query type for OrderDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderDetail extends EntityPathBase<OrderDetail> {

    private static final long serialVersionUID = 92732273L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderDetail orderDetail = new QOrderDetail("orderDetail");

    public final test.order.common.QAbstractTimestamp _super = new test.order.common.QAbstractTimestamp(this);

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final NumberPath<Long> discountAmount = createNumber("discountAmount", Long.class);

    public final QOrder order;

    public final StringPath orderDetailNo = createString("orderDetailNo");

    public final NumberPath<Long> orderDetailSeq = createNumber("orderDetailSeq", Long.class);

    public final StringPath orderTakeType = createString("orderTakeType");

    public final StringPath promotionType = createString("promotionType");

    //inherited
    public final DateTimePath<java.util.Date> registerDatetime = _super.registerDatetime;

    public final StringPath shopAddress = createString("shopAddress");

    public final StringPath shopNm = createString("shopNm");

    public final StringPath shopNo = createString("shopNo");

    public final StringPath shopOwnerNo = createString("shopOwnerNo");

    public final EnumPath<test.order.common.OrderStatusCode> status = createEnum("status", test.order.common.OrderStatusCode.class);

    //inherited
    public final DateTimePath<java.util.Date> updateDatetime = _super.updateDatetime;

    public QOrderDetail(String variable) {
        this(OrderDetail.class, forVariable(variable), INITS);
    }

    public QOrderDetail(Path<? extends OrderDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderDetail(PathMetadata metadata, PathInits inits) {
        this(OrderDetail.class, metadata, inits);
    }

    public QOrderDetail(Class<? extends OrderDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.order = inits.isInitialized("order") ? new QOrder(forProperty("order"), inits.get("order")) : null;
    }

}

