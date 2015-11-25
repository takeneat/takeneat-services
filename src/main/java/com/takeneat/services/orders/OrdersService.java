package com.takeneat.services.orders;

import com.takeneat.services.model.Order;
import com.takeneat.services.model.Product;
import com.takeneat.services.model.User;
import com.takeneat.services.products.ProductDao;
import com.takeneat.services.users.UserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author paoesco
 */
@Service
public class OrdersService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;

    @Transactional
    public Long newOrder(long consumerId, long productId) {
        Product product = productDao.findOne(productId);
        User consumer = userDao.findOne(consumerId);
        Order order = new Order();
        order.setProduct(product);
        order.setConsumer(consumer);
        Order createdOrder = orderDao.save(order);
        return createdOrder.getId();
    }

    public List<Order> getOrders(long consumerId) {
        return orderDao.findByConsumerId(consumerId);
    }

}
