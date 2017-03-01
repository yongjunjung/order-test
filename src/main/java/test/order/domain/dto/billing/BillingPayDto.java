package test.order.domain.dto.billing;

import java.util.List;
import java.util.Map;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public class BillingPayDto {

    private String serviceId;
    private String site;
    private String userId;
    private String userName;
    private String userEmail;
    private String userIp;
    private String userTel;
    private String userAddr;
    private String serviceTradeNo;
    private Long amount;
    private String itemName;
    private String merchantKey;
    private String returnUrl;
    private String resultUrl;
    private String closeUrl;
    private String etc1;
    private String etc2;
    private String etc3;
    private List<Map<String,Object>> payDetails;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getServiceTradeNo() {
        return serviceTradeNo;
    }

    public void setServiceTradeNo(String serviceTradeNo) {
        this.serviceTradeNo = serviceTradeNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl, String orderNo) {

        this.resultUrl = resultUrl + "/" + orderNo;
    }

    public String getCloseUrl() {
        return closeUrl;
    }

    public void setCloseUrl(String closeUrl) {
        this.closeUrl = closeUrl;
    }

    public String getEtc1() {
        return etc1;
    }

    public void setEtc1(String etc1) {
        this.etc1 = etc1;
    }

    public String getEtc2() {
        return etc2;
    }

    public void setEtc2(String etc2) {
        this.etc2 = etc2;
    }

    public String getEtc3() {
        return etc3;
    }

    public void setEtc3(String etc3) {
        this.etc3 = etc3;
    }

    public List<Map<String, Object>> getPayDetails() {
        return payDetails;
    }

    public void setPayDetails(List<Map<String, Object>> payDetails) {
        this.payDetails = payDetails;
    }
}
