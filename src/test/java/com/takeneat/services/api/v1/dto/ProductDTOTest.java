package com.takeneat.services.api.v1.dto;

import com.takeneat.services.api.utils.WebServiceUtils;
import com.takeneat.services.model.Product;
import com.takeneat.services.model.User;
import com.takeneat.services.test.TestConstants;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author paoesco
 */
public class ProductDTOTest {
    
    @Test
    public void testMapping() {
        
        Product p = new Product();
        User cook = new User();
        cook.setId(TestConstants.COOK_ID);
        cook.setFirstname("Firstname");
        cook.setLastname("Lastname");
        p.setCook(cook);
        p.setCreationDate(new Date());
        p.setId(TestConstants.LASAGNA_PRODUCT_ID);
        p.setPrice(7.55);
        ProductDTO result = new ProductDTO(p);
        
        Assert.assertEquals(p.getCook().getId(), result.getCookId());
        Assert.assertEquals(p.getCook().getFullname(), result.getCookName());
        Assert.assertEquals(WebServiceUtils.formatDate(p.getCreationDate()), result.getCreationDate());
        Assert.assertEquals(p.getId(), result.getId());
        Assert.assertEquals(p.getName(), result.getName());
        Assert.assertEquals(p.getPrice(), result.getPrice());
        Assert.assertNotNull(result.getDistance());
        
    }
    
}
