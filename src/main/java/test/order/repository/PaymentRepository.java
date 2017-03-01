package test.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.order.domain.Payment;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> , PaymentRepositoryCustom {
}
