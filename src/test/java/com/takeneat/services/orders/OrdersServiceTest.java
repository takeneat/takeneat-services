package com.takeneat.services.orders;

import com.takeneat.services.model.Order;
import com.takeneat.services.test.AbstractServiceTest;
import com.takeneat.services.test.TestConstants;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author paoesco
 */
public class OrdersServiceTest extends AbstractServiceTest {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderDao orderDao;

    @Test
    public void testCreate() {
        Long orderId = ordersService.create(TestConstants.CONSUMER_ID, TestConstants.LASAGNA_PRODUCT_ID);
        Assert.assertNotNull(orderId);
        Order order = orderDao.findOne(orderId);
        Assert.assertNotNull(order);
        Assert.assertEquals(TestConstants.CONSUMER_ID, order.getConsumer().getId().longValue());
        Assert.assertEquals(TestConstants.LASAGNA_PRODUCT_ID, order.getProduct().getId().longValue());
        Assert.assertNotNull(order.getCreationDate());
    }

    @Test
    public void testFindByConsumerId() {
        List<Order> orders = ordersService.getOrders(TestConstants.CONSUMER_2_ID);
        Assert.assertNotNull(orders);
        Assert.assertEquals(1, orders.size());
        Order order = orders.get(0);
        Assert.assertEquals(TestConstants.CONSUMER_2_ID, order.getConsumer().getId().longValue());
        Assert.assertEquals(TestConstants.SUSHIS_PRODUCT_ID, order.getProduct().getId().longValue());
    }
}
