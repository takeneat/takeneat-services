package com.takeneat.services.api.v1;

import com.takeneat.services.api.exceptions.ExceptionDTO;
import com.takeneat.services.api.v1.dto.CreateProductRequestDTO;
import com.takeneat.services.api.v1.dto.OrderDTO;
import com.takeneat.services.test.AbstractWebIntegrationTest;
import com.takeneat.services.test.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author paoesco
 */
public class CooksRestControllerTest extends AbstractWebIntegrationTest {

    @Test
    public void testCreateProductOK() {
        CreateProductRequestDTO request = new CreateProductRequestDTO();
        request.setName("Eggs");
        request.setPrice(6.55);
        Long productId = restTemplate.postForObject(getPathV1() + "/cooks/" + TestConstants.COOK_2_ID + "/products", request, Long.class);
        Assert.assertNotNull(productId);
    }

    @Test
    public void testCreateProductBadRequestName() {
        CreateProductRequestDTO request = new CreateProductRequestDTO();
        request.setPrice(6.55);
        ResponseEntity<ExceptionDTO> response = restTemplate.postForEntity(getPathV1() + "/cooks/" + TestConstants.COOK_2_ID + "/products", request, ExceptionDTO.class);
        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testCreateProductBadRequestPrice() {
        CreateProductRequestDTO request = new CreateProductRequestDTO();
        request.setName("Eggs");
        ResponseEntity<ExceptionDTO> response = restTemplate.postForEntity(getPathV1() + "/cooks/" + TestConstants.COOK_2_ID + "/products", request, ExceptionDTO.class);
        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testGetOrdersOfACook() {
        OrderDTO[] orders = restTemplate.getForObject(getPathV1() + "/cooks/" + TestConstants.COOK_3_ID + "/orders", OrderDTO[].class);
        Assert.assertNotNull(orders);
        Assert.assertEquals(1, orders.length);
        OrderDTO order = orders[0];
        Assert.assertNotNull(order.getOrderId());
        Assert.assertEquals(TestConstants.TORTILLA_PRODUCT_ID, order.getProductId().longValue());
        Assert.assertEquals("Tortilla", order.getProductName());
        Assert.assertEquals(5.50, order.getProductPrice(), 0);
        Assert.assertEquals(TestConstants.COOK_3_ID, order.getCookId().longValue());
        Assert.assertEquals("Cook firstname Cook lastname", order.getCookName());
        Assert.assertEquals(TestConstants.CONSUMER_3_ID, order.getConsumerId().longValue());
        Assert.assertEquals("Consumer firstname Consumer lastname", order.getConsumerName());
        Assert.assertEquals("2015-01-02 02:00:00", order.getCreationDate());

    }

}
