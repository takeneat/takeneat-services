package com.takeneat.services.orders;

import com.takeneat.services.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author paoesco
 */
public interface OrderDao extends JpaRepository<Order, Long> {

    List<Order> findByConsumerId(long consumerId);

}
