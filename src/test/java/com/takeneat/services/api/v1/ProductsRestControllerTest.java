package com.takeneat.services.api.v1;

import com.takeneat.services.api.v1.dto.ProductDTO;
import com.takeneat.services.test.AbstractWebIntegrationTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author paoesco
 */
public class ProductsRestControllerTest extends AbstractWebIntegrationTest {

    @Test
    public void testSearch() {
        ProductDTO[] results = restTemplate.postForObject(getBaseurl() + "/products/search", null, ProductDTO[].class);
        Assert.assertNotNull(results);
        Assert.assertEquals(2, results.length);
        for (ProductDTO dto : results){
            Assert.assertEquals("Cook firstname Cook lastname", dto.getCook());
        }
    }
}
