package com.takeneat.services.api.v1;

import com.takeneat.services.api.v1.dto.OrderDTO;
import com.takeneat.services.api.v1.dto.OrderRequestDTO;
import com.takeneat.services.test.AbstractWebIntegrationTest;
import com.takeneat.services.test.TestConstants;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author paoesco
 */
public class ConsumersRestControllerTest extends AbstractWebIntegrationTest {

    @Test
    public void testNewOrder() {
        OrderRequestDTO request = new OrderRequestDTO();
        request.setProductId(TestConstants.LASAGNA_PRODUCT_ID);
        Long orderId = restTemplate.postForObject(getPathV1()+ "/consumers/" + TestConstants.CONSUMER_ID + "/orders", request, Long.class);
        Assert.assertNotNull(orderId);
    }

    @Test
    public void testGetOrdersOfAConsumer() {
        OrderDTO[] orders = restTemplate.getForObject(getPathV1() + "/consumers/" + TestConstants.CONSUMER_2_ID + "/orders", OrderDTO[].class);
        Assert.assertNotNull(orders);
        Assert.assertEquals(1, orders.length);
        Assert.assertEquals(TestConstants.SUSHIS_PRODUCT_ID, orders[0].getProductId().longValue());
    }
}
