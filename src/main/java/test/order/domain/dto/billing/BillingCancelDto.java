package test.order.domain.dto.billing;

/**
 * Created by yongjunjung on 2017. 2. 28..
 */
public class BillingCancelDto {

    private String serviceId;
    private String serviceTradeNo;
    private String tradeNo;
    private String merchantKey;

    public BillingCancelDto(String serviceId, String serviceTradeNo, String tradeNo, String merchantKey) {
        this.serviceId = serviceId;
        this.serviceTradeNo = serviceTradeNo;
        this.tradeNo = tradeNo;
        this.merchantKey = merchantKey;
    }

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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }
}
