package com.takeneat.services.api.v1;

import com.takeneat.services.api.exceptions.ExceptionDTO;
import com.takeneat.services.api.v1.dto.OrderDTO;
import com.takeneat.services.api.v1.dto.OrderRequestDTO;
import com.takeneat.services.test.AbstractWebIntegrationTest;
import com.takeneat.services.test.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author paoesco
 */
public class ConsumersRestControllerTest extends AbstractWebIntegrationTest {

    @Test
    public void testNewOrderOK() {
        OrderRequestDTO request = new OrderRequestDTO();
        request.setProductId(TestConstants.LASAGNA_PRODUCT_ID);
        Long orderId = restTemplate.postForObject(getPathV1() + "/consumers/" + TestConstants.CONSUMER_ID + "/orders", request, Long.class);
        Assert.assertNotNull(orderId);
    }

    @Test
    public void testNewOrderBadRequest() {
        OrderRequestDTO request = new OrderRequestDTO();
        ResponseEntity<ExceptionDTO> response = restTemplate.postForEntity(getPathV1() + "/consumers/" + TestConstants.CONSUMER_ID + "/orders", request, ExceptionDTO.class);
        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testGetOrdersOfAConsumer() {
        OrderDTO[] orders = restTemplate.getForObject(getPathV1() + "/consumers/" + TestConstants.CONSUMER_2_ID + "/orders", OrderDTO[].class);
        Assert.assertNotNull(orders);
        Assert.assertEquals(1, orders.length);
        OrderDTO order = orders[0];
        Assert.assertNotNull(order.getOrderId());
        Assert.assertEquals(TestConstants.SUSHIS_PRODUCT_ID, order.getProductId().longValue());
        Assert.assertEquals("Sushis", order.getProductName());
        Assert.assertEquals(7.55, order.getProductPrice(), 0);
        Assert.assertEquals(TestConstants.COOK_ID, order.getCookId().longValue());
        Assert.assertEquals("Cook firstname Cook lastname", order.getCookName());
        Assert.assertEquals(TestConstants.CONSUMER_2_ID, order.getConsumerId().longValue());
        Assert.assertEquals("Consumer 2 firstname Consumer 2 lastname", order.getConsumerName());
        Assert.assertEquals("2015-01-02 02:00:00", order.getCreationDate());
    }
}
