package com.takeneat.services.api.v1;

import com.takeneat.services.api.v1.dto.CreateProductRequestDTO;
import com.takeneat.services.test.AbstractWebIntegrationTest;
import com.takeneat.services.test.TestConstants;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author paoesco
 */
public class CooksRestControllerTest extends AbstractWebIntegrationTest {

    @Test
    public void testCreateProduct() {
        CreateProductRequestDTO request = new CreateProductRequestDTO();
        request.setName("Eggs");
        request.setPrice(6.55);
        Long productId = restTemplate.postForObject(getPathV1() + "/cooks/" + TestConstants.COOK_2_ID + "/products", request, Long.class);
        Assert.assertNotNull(productId);
    }

}
