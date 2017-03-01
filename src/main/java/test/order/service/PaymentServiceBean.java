package test.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.order.domain.Payment;
import test.order.domain.PaymentDetail;
import test.order.domain.dto.billing.BillingReturnDto;
import test.order.domain.dto.PaymentDetailDto;
import test.order.domain.dto.PaymentDto;
import test.order.repository.PaymentRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@Service
public class PaymentServiceBean implements PaymentService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment buidPayment(PaymentDto paymentDto) {

        Payment payment = new Payment();
        payment.setAmount(paymentDto.getAmount());

        List<PaymentDetailDto> paymentDetailDtoList = paymentDto.getPayDetails();
        for (PaymentDetailDto paymentDetailDto : paymentDetailDtoList) {
            PaymentDetail paymentDetail = buidPaymentDetail(paymentDetailDto);
            payment.addPaymentDetail(paymentDetail);
        }

        return payment;
    }

    private PaymentDetail buidPaymentDetail (PaymentDetailDto paymentDetailDto) {

        PaymentDetail paymentDetail = new PaymentDetail();
        paymentDetail.setPaymentType(paymentDetailDto.getPaymentType());
        paymentDetail.setAmount(paymentDetailDto.getAmount());

        return paymentDetail;
    }

    @Transactional
    @Override
    public void updateBillingApprove(BillingReturnDto returnDto) {
        Payment payment = paymentRepository.findByOrderNo(returnDto.getServiceTradeNo());
        payment.setBillingTradeNo(returnDto.getBillingTradeNo());
        payment.setPayAuthToken(returnDto.getPayAuthToken());
    }
}
