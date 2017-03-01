package test.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import test.order.common.AbstractTimestamp;
import test.order.common.OrderStatusCode;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/**
 * Created by yongjunjung on 2017. 2. 23..
 */

@Entity
public class OrderDetail extends AbstractTimestamp {

    @Id
    @GeneratedValue
    private Long orderDetailSeq;
    private String orderDetailNo;       //orderNo_Shop 구조로 가도 괜찮겠다..
    private String shopNo;
    private String shopNm;
    private String shopAddress;
    private String shopOwnerNo;         //필요할까?
    private OrderStatusCode status;
    private Long amount;
    private Long discountAmount;
    private String orderTakeType;
    private String promotionType;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_seq")
    @JsonIgnore
    private Order order;

    public OrderDetail() {
        setStatus(OrderStatusCode.ORDER_REQUEST);
    }

    public Long getOrderDetailSeq() {
        return orderDetailSeq;
    }

    public void setOrderDetailSeq(Long orderDetailSeq) {
        this.orderDetailSeq = orderDetailSeq;
    }

    public String getOrderDetailNo() {
        return orderDetailNo;
    }

    public void setOrderDetailNo(String orderNo) {
        //todo + 연산이 아닌, stringBuffer 같은 것으로 바꿀 수 없을까?
        this.orderDetailNo = orderNo + "_" + this.shopNo;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getShopNm() {
        return shopNm;
    }

    public void setShopNm(String shopNm) {
        this.shopNm = shopNm;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopOwnerNo() {
        return shopOwnerNo;
    }

    public void setShopOwnerNo(String shopOwnerNo) {
        this.shopOwnerNo = shopOwnerNo;
    }

    public OrderStatusCode getStatus() {
        return status;
    }

    public void setStatus(OrderStatusCode status) {
        this.status = status;
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

    public String getOrderTakeType() {
        return orderTakeType;
    }

    public void setOrderTakeType(String orderTakeType) {
        this.orderTakeType = orderTakeType;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
