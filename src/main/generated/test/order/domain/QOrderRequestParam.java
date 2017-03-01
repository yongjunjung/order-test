package test.order.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderRequestParam is a Querydsl query type for OrderRequestParam
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderRequestParam extends EntityPathBase<OrderRequestParam> {

    private static final long serialVersionUID = 541098590L;

    public static final QOrderRequestParam orderRequestParam = new QOrderRequestParam("orderRequestParam");

    public final test.order.common.QAbstractTimestamp _super = new test.order.common.QAbstractTimestamp(this);

    public final StringPath orderNo = createString("orderNo");

    public final MapPath<String, String, StringPath> params = this.<String, String, StringPath>createMap("params", String.class, String.class, StringPath.class);

    //inherited
    public final DateTimePath<java.util.Date> registerDatetime = _super.registerDatetime;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> updateDatetime = _super.updateDatetime;

    public QOrderRequestParam(String variable) {
        super(OrderRequestParam.class, forVariable(variable));
    }

    public QOrderRequestParam(Path<? extends OrderRequestParam> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderRequestParam(PathMetadata metadata) {
        super(OrderRequestParam.class, metadata);
    }

}

