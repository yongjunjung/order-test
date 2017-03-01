package test.order.common;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yongjunjung on 2017. 2. 16..
 */

//부모 클래스는 테이블 매핑을 하지 않고 상속 받는 자식 클래스에게 정보만 제공하고 싶을 때
@MappedSuperclass
public abstract class AbstractTimestamp {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = true, updatable = false)
    private Date registerDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = true)
    private Date updateDatetime;

    @PrePersist
    protected void onCreate() {
        updateDatetime = registerDatetime = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDatetime = new Date();
    }

    public Date getUpdateDate() {
        return updateDatetime;
    }

    public Date getCreateDate() {
        return registerDatetime;
    }
}
