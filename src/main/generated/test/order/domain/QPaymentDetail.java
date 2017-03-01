package test.order.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaymentDetail is a Querydsl query type for PaymentDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPaymentDetail extends EntityPathBase<PaymentDetail> {

    private static final long serialVersionUID = 1338308521L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaymentDetail paymentDetail = new QPaymentDetail("paymentDetail");

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final StringPath billingApporveNo = createString("billingApporveNo");

    public final QPayment payment;

    public final NumberPath<Long> paymentDetailSeq = createNumber("paymentDetailSeq", Long.class);

    public final StringPath paymentInfo = createString("paymentInfo");

    public final StringPath paymentType = createString("paymentType");

    public QPaymentDetail(String variable) {
        this(PaymentDetail.class, forVariable(variable), INITS);
    }

    public QPaymentDetail(Path<? extends PaymentDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaymentDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaymentDetail(PathMetadata metadata, PathInits inits) {
        this(PaymentDetail.class, metadata, inits);
    }

    public QPaymentDetail(Class<? extends PaymentDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.payment = inits.isInitialized("payment") ? new QPayment(forProperty("payment"), inits.get("payment")) : null;
    }

}

