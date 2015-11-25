package com.takeneat.services.api.v1;

import com.takeneat.services.api.v1.dto.ProductDTO;
import com.takeneat.services.test.AbstractWebIntegrationTest;
import com.takeneat.services.test.TestConstants;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author paoesco
 */
public class ProductsRestControllerTest extends AbstractWebIntegrationTest {

    @Test
    @Ignore
    public void testSearch() {
        ProductDTO[] results = restTemplate.postForObject(getPathV1() + "/products/search", null, ProductDTO[].class);
        Assert.assertNotNull(results);
        Assert.assertEquals(TestConstants.COOK_ID, results.length);
        for (ProductDTO dto : results){
            Assert.assertEquals("Cook firstname Cook lastname", dto.getCook());
        }
    }
}
