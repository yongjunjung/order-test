package test.order.repository;

import test.order.domain.Payment;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public interface PaymentRepositoryCustom {

    Payment findByOrderNo(String orderNo);
}
