package test.order.service;

import org.springframework.stereotype.Service;
import test.order.domain.PaymentDetail;
import test.order.domain.dto.PaymentDetailDto;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@Service
public class PaymentDetailServiceBean implements PaymentDetailService {

    @Override
    public PaymentDetail buidPayment(PaymentDetailDto paymentDetailDto) {

        PaymentDetail paymentDetail = new PaymentDetail();
        paymentDetail.setPaymentType(paymentDetailDto.getPaymentType());
        paymentDetail.setAmount(paymentDetailDto.getAmount());

        return paymentDetail;
    }
}
