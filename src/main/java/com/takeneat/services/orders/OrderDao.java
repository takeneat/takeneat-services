package com.takeneat.services.orders;

import com.takeneat.services.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author paoesco
 */
public interface OrderDao extends JpaRepository<Order, Long> {

    List<Order> findByConsumerId(long consumerId);

    @Query(name = "Order.findByCookId", value = "select o from Order o where o.product.cook.id = :cookId")
    List<Order> findByCookId(@Param("cookId") long cookId);

}
