package test.order.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import test.order.domain.Payment;
import test.order.domain.QPayment;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public class PaymentRepositoryImpl extends QueryDslRepositorySupport implements PaymentRepositoryCustom {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private final QPayment qPayment = new QPayment("payment");

    public PaymentRepositoryImpl() {
        super(Payment.class);
    }


    @Override
    public Payment findByOrderNo(String orderNo) {
        return from(qPayment)
                .where(qPayment.orderNo.eq(orderNo))
                .fetchOne();
    }
}
