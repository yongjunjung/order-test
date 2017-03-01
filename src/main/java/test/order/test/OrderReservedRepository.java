package test.order.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yongjunjung on 2017. 2. 16..
 */

@Repository
public interface OrderReservedRepository extends JpaRepository<OrderReserved, Long> {

    OrderReserved findByOrderNo(String orderNo);
}

