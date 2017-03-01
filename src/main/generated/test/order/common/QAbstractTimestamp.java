package test.order.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractTimestamp is a Querydsl query type for AbstractTimestamp
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractTimestamp extends EntityPathBase<AbstractTimestamp> {

    private static final long serialVersionUID = 2060258605L;

    public static final QAbstractTimestamp abstractTimestamp = new QAbstractTimestamp("abstractTimestamp");

    public final DateTimePath<java.util.Date> registerDatetime = createDateTime("registerDatetime", java.util.Date.class);

    public final DateTimePath<java.util.Date> updateDatetime = createDateTime("updateDatetime", java.util.Date.class);

    public QAbstractTimestamp(String variable) {
        super(AbstractTimestamp.class, forVariable(variable));
    }

    public QAbstractTimestamp(Path<? extends AbstractTimestamp> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractTimestamp(PathMetadata metadata) {
        super(AbstractTimestamp.class, metadata);
    }

}

