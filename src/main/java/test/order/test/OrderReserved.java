package test.order.test;

import test.order.common.AbstractTimestamp;

import javax.persistence.*;

/**
 * Created by yongjunjung on 2017. 2. 16..
 */

@Entity
public class OrderReserved extends AbstractTimestamp {

    @Id
    @GeneratedValue
    private Long orderReservedSeq;
    private String reservedNo;
    private String orderNo;

    @Enumerated(EnumType.STRING)
    private ReservedStatus status;

//    private Date reservedDatetime;
//    private String serviceId;
//    private String shopNo;
//    private String orderMenu;
//    private String orderTakeType;
//    private String userId;
//    private String mobileNo;
//    private String content;
//    private boolean memberYn;

    protected OrderReserved() {
    }

    public OrderReserved(String reservedNo, String orderNo) {
        this.reservedNo = reservedNo;
        this.orderNo = orderNo;
        this.status = ReservedStatus.REQUEST;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setStatus(ReservedStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderReserved{" +
                "orderReservedSeq=" + orderReservedSeq +
                ", reservedNo='" + reservedNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", status=" + status.name() +
                '}';
    }
}
