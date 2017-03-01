package test.order.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = -692242688L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrder order = new QOrder("order1");

    public final test.order.common.QAbstractTimestamp _super = new test.order.common.QAbstractTimestamp(this);

    public final StringPath Address = createString("Address");

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final NumberPath<Long> discountAmount = createNumber("discountAmount", Long.class);

    public final StringPath modifyId = createString("modifyId");

    public final ListPath<OrderDetail, QOrderDetail> orderDetails = this.<OrderDetail, QOrderDetail>createList("orderDetails", OrderDetail.class, QOrderDetail.class, PathInits.DIRECT2);

    public final StringPath orderNo = createString("orderNo");

    public final NumberPath<Long> orderSeq = createNumber("orderSeq", Long.class);

    public final StringPath orderTelNo = createString("orderTelNo");

    public final StringPath orderType = createString("orderType");

    public final QPayment payment;

    //inherited
    public final DateTimePath<java.util.Date> registerDatetime = _super.registerDatetime;

    public final StringPath requestMessage = createString("requestMessage");

    public final StringPath serviceId = createString("serviceId");

    public final EnumPath<test.order.common.OrderStatusCode> status = createEnum("status", test.order.common.OrderStatusCode.class);

    public final StringPath telNo = createString("telNo");

    //inherited
    public final DateTimePath<java.util.Date> updateDatetime = _super.updateDatetime;

    public final StringPath userId = createString("userId");

    public QOrder(String variable) {
        this(Order.class, forVariable(variable), INITS);
    }

    public QOrder(Path<? extends Order> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrder(PathMetadata metadata, PathInits inits) {
        this(Order.class, metadata, inits);
    }

    public QOrder(Class<? extends Order> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.payment = inits.isInitialized("payment") ? new QPayment(forProperty("payment"), inits.get("payment")) : null;
    }

}

