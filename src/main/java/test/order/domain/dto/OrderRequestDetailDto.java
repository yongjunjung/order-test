package test.order.domain.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public class OrderRequestDetailDto {

    @NotEmpty(message = "업소번호 누락")
    private String shopNo;
    @NotEmpty(message = "업소명 누락")
    private String shopNm;
    @NotEmpty(message = "업주정보 누락")
    private String shopOwnerNo;
    @NotEmpty(message = "업소주소 누락")
    private String shopAddress;
    @NotNull(message = "주문금액 누락")
    private Long amount;
    private Long discountAmount;
    @NotEmpty(message = "주문접수방식 누락")
    private String orderTakeType;
    private String promotionType;

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

    public String getShopOwnerNo() {
        return shopOwnerNo;
    }

    public void setShopOwnerNo(String shopOwnerNo) {
        this.shopOwnerNo = shopOwnerNo;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
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
}
