package com.takeneat.services.api.v1.dto;

import com.takeneat.services.model.Order;
import com.takeneat.services.model.Product;
import com.takeneat.services.model.User;
import com.takeneat.services.test.TestConstants;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author paoesco
 */
public class OrderDTOTest {

    @Test
    public void testMappingConstructor() {
        Long consumerId = TestConstants.CONSUMER_ID;
        String firstname = "Firstname";
        String lastname = "Lastname";
        Long cookId = TestConstants.COOK_ID;
        Long orderId = (long) 1;
        Long productId = TestConstants.LASAGNA_PRODUCT_ID;
        String productName = "product";
        Double productPrice = 6.55;
       
        Order order = new Order();
        order.setConsumer(new User());
        order.getConsumer().setId(consumerId);
        order.getConsumer().setFirstname(firstname);
        order.getConsumer().setLastname(lastname);
        order.setProduct(new Product());
        order.getProduct().setCook(new User());
        order.getProduct().getCook().setId(cookId);
        order.getProduct().getCook().setFirstname(firstname);
        order.getProduct().getCook().setLastname(lastname);
        order.setId(orderId);
        order.getProduct().setId(productId);
        order.getProduct().setName(productName);
        order.getProduct().setPrice(productPrice);
        
        
        OrderDTO result = new OrderDTO(order);
        Assert.assertEquals(order.getConsumer().getId(), result.getConsumerId());
        Assert.assertEquals(order.getConsumer().getFullname(), result.getConsumerName());
        Assert.assertEquals(order.getProduct().getCook().getId(), result.getCookId());
        Assert.assertEquals(order.getProduct().getCook().getFullname(), result.getCookName());
        Assert.assertNotNull(result.getCreationDate());
        Assert.assertEquals(order.getId(), result.getOrderId());
        Assert.assertEquals(order.getProduct().getId(), result.getProductId());
        Assert.assertEquals(order.getProduct().getName(), result.getProductName());
        Assert.assertEquals(order.getProduct().getPrice(), result.getProductPrice());
    }

}
