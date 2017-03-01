package test.order.domain.dto.billing;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Arrays;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

public class BillingReturnDto {

    private String serviceId;
    private String serviceTradeNo;
    private String billingTradeNo;
    private String payAuthToken;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceTradeNo() {
        return serviceTradeNo;
    }

    public void setServiceTradeNo(String serviceTradeNo) {
        this.serviceTradeNo = serviceTradeNo;
    }

    public String getBillingTradeNo() {
        return billingTradeNo;
    }

    public void setBillingTradeNo(String billingTradeNo) {
        this.billingTradeNo = billingTradeNo;
    }

    public String getPayAuthToken() {
        return payAuthToken;
    }

    public void setPayAuthToken(String payAuthToken) {
        this.payAuthToken = payAuthToken;
    }

    @Override
    public String toString() {
        return "BillingReturnDto{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceTradeNo='" + serviceTradeNo + '\'' +
                ", billingTradeNo='" + billingTradeNo + '\'' +
                ", payAuthToken='" + payAuthToken + '\'' +
                '}';
    }
}
