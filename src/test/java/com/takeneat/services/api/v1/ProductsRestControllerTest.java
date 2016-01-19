package com.takeneat.services.api.v1;

import com.takeneat.services.api.v1.dto.ProductDTO;
import com.takeneat.services.test.AbstractWebIntegrationTest;
import com.takeneat.services.test.TestConstants;
import java.text.SimpleDateFormat;
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
        for (ProductDTO dto : results) {
            Assert.assertEquals("Cook firstname Cook lastname", dto.getCookName());
        }
    }

    @Test
    public void testGet() {
        ProductDTO result = restTemplate.getForObject(getPathV1() + "/products/" + TestConstants.LASAGNA_PRODUCT_ID, ProductDTO.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(TestConstants.LASAGNA_PRODUCT_ID, result.getId().longValue());
        Assert.assertEquals(TestConstants.COOK_ID, result.getCookId().longValue());
        Assert.assertEquals("Cook firstname Cook lastname", result.getCookName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals("2015-01-01 01:00:00", sdf.format(result.getCreationDate()));
        Assert.assertNotNull(result.getDistance());
        Assert.assertEquals("Lasagna", result.getName());
        Assert.assertEquals(5.50, result.getPrice(), 0);
    }
}
