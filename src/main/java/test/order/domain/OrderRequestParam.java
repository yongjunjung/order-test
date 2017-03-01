package test.order.domain;

import test.order.common.AbstractTimestamp;
import test.order.common.convert.MapToJsonConverter;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@Entity
public class OrderRequestParam extends AbstractTimestamp {

    @Id
    @GeneratedValue
    private Long seq;

    private String orderNo;

    @Column(name = "params", length = 4000)
    @Convert(converter = MapToJsonConverter.class)
    private Map<String, String> params;

}
