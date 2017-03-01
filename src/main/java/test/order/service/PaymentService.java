package test.order.service;

import test.order.domain.Payment;
import test.order.domain.dto.billing.BillingReturnDto;
import test.order.domain.dto.PaymentDto;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public interface PaymentService {

    Payment buidPayment(PaymentDto paymentDto);

    void updateBillingApprove(BillingReturnDto returnDto);

}
