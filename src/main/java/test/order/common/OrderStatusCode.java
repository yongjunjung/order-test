package test.order.common;

/**
 * Created by yongjunjung on 2017. 2. 23..
 */
public enum OrderStatusCode {

    ORDER_WAIT,             //대기중 (대신, 예약주문에서 사용할 것)
    ORDER_OK,               //완료
    ORDER_CANCEL,           //취소
    ORDER_FAIL_OK,          //주문실패
    ORDER_FAIL_CANCEL,      //취소실패
    ORDER_PART_CANCEL,      //부분취소
    ORDER_REQUEST,          //요청

}
