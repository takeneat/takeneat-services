package com.takeneat.services.orders;

import com.takeneat.services.Boot;
import com.takeneat.services.model.Order;
import com.takeneat.services.test.Constants;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author paoesco
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Boot.class)
public class OrdersServiceTest {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderDao orderDao;

    @Test
    public void testCreate() {
        Long orderId = ordersService.create(Constants.CONSUMER_ID, Constants.LASAGNA_PRODUCT_ID);
        Assert.assertNotNull(orderId);
        Order order = orderDao.findOne(orderId);
        Assert.assertNotNull(order);
        Assert.assertEquals(Constants.CONSUMER_ID, order.getConsumer().getId().longValue());
        Assert.assertEquals(Constants.LASAGNA_PRODUCT_ID, order.getProduct().getId().longValue());
        Assert.assertNotNull(order.getCreationDate());
    }

    @Test
    public void testFindByConsumerId() {
        List<Order> orders = ordersService.getOrders(Constants.CONSUMER_2_ID);
        Assert.assertNotNull(orders);
        Assert.assertEquals(1, orders.size());
        Order order = orders.get(0);
        Assert.assertEquals(Constants.CONSUMER_2_ID, order.getConsumer().getId().longValue());
        Assert.assertEquals(Constants.SUSHIS_PRODUCT_ID, order.getProduct().getId().longValue());
    }
}
