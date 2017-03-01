package test.order.service;

import test.order.domain.PaymentDetail;
import test.order.domain.dto.PaymentDetailDto;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public interface PaymentDetailService {

    PaymentDetail buidPayment(PaymentDetailDto paymentDetailDto);


}
