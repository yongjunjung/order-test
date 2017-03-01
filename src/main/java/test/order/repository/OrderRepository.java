package test.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.order.domain.Order;

/**
 * Created by yongjunjung on 2017. 2. 23..
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> , OrderRepositoryCustom{
    Order findByOrderNo(String orderNo);
}
