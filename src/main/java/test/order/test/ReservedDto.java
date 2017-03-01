package test.order.test;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by yongjunjung on 2017. 2. 16..
 */
public class ReservedDto {

    @NotEmpty(message = "주문번호 누락")
    private String orderNo;
    @NotEmpty(message = "예약시간 누락")
//    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private Date reservedDatetime;
    @NotEmpty(message = "서비스ID 누락")
    private String serviceId;
    @NotEmpty(message = "업소번호 누락")
    private String shopNo;
    @NotEmpty(message = "주문메뉴명 누락")
    private String orderMenu;
    @NotEmpty(message = "주문접수수단 누락")
    private String orderTakeType;
    @NotEmpty(message = "회원정보 누락")
    private String userId;
    @NotEmpty(message = "연락처 누락")
    private String mobileNo;
    @NotEmpty(message = "내용 누락")
    private String content;
//    @NotEmpty(message = " 누락")
//    private boolean memberYn;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getReservedDatetime() {
        return reservedDatetime;
    }

    public void setReservedDatetime(Date reservedDatetime) {
        this.reservedDatetime = reservedDatetime;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(String orderMenu) {
        this.orderMenu = orderMenu;
    }

    public String getOrderTakeType() {
        return orderTakeType;
    }

    public void setOrderTakeType(String orderTakeType) {
        this.orderTakeType = orderTakeType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ReservedDto{" +
                "orderNo='" + orderNo + '\'' +
                ", reservedDatetime=" + reservedDatetime +
                ", serviceId='" + serviceId + '\'' +
                ", shopNo='" + shopNo + '\'' +
                ", orderMenu='" + orderMenu + '\'' +
                ", orderTakeType='" + orderTakeType + '\'' +
                ", userId='" + userId + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
