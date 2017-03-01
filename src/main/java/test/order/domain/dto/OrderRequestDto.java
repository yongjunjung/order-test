package test.order.domain.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public class OrderRequestDto {

    @NotEmpty(message = "회원정보 누락")
    private String userId;
    @NotNull(message = "총 주문금액 누락")
    @Min(value = 0, message = "총 주문금액 오류")
    private Long amount;
    private Long discountAmount;
    @NotEmpty(message = "주문자연락처 누락")
    private String telNo;
    private String orderTelNo;
    @NotEmpty(message = "배송주소 누락")
    private String address;
    @NotEmpty(message = "주문타입 누락")
    private String orderType;
    private String requestMessage;
    @NotEmpty(message = "서비스ID 누락")
    private String serviceId;
    @Valid
    private List<OrderRequestDetailDto> orderDetails;
    @Valid
    private PaymentDto payment;

    //각 주문금액의 합계
    public Long getOrderDetailRequestDtoSum() {
        return orderDetails.stream().mapToLong(detail -> detail.getAmount()).sum();
    }

    //결제금액 = 주문금액 - 할인금액
    public Long getPaymentDtoAmount() {
        return amount - discountAmount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getOrderTelNo() {
        return orderTelNo;
    }

    public void setOrderTelNo(String orderTelNo) {
        this.orderTelNo = orderTelNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public List<OrderRequestDetailDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderRequestDetailDto> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public PaymentDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "OrderRequestDto{" +
                "userId='" + userId + '\'' +
                ", amount=" + amount +
                ", discountAmount=" + discountAmount +
                ", telNo='" + telNo + '\'' +
                ", orderTelNo='" + orderTelNo + '\'' +
                ", address='" + address + '\'' +
                ", orderType='" + orderType + '\'' +
                ", requestMessage='" + requestMessage + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", orderDetails=" + orderDetails.toString() +
                ", payment=" + payment.toString() +
                '}';
    }
}
