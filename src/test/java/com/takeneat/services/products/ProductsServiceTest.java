package com.takeneat.services.products;

import com.takeneat.services.model.Product;
import com.takeneat.services.test.AbstractServiceTest;
import com.takeneat.services.test.TestConstants;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author paoesco
 */
public class ProductsServiceTest extends AbstractServiceTest {

    @Autowired
    private ProductsService productsService;
    @Autowired
    private ProductDao productDao;

    @Test
    public void testFindAll() {
        List<Product> results = productsService.search();
        Assert.assertEquals(2, results.size());
    }

    @Test
    public void testCreate() {
        Long id = productsService.create("Eggs", 6.55, TestConstants.COOK_ID);
        Assert.assertNotNull(id);

        Product product = productDao.findOne(id);
        Assert.assertNotNull(product);
        Assert.assertEquals("Eggs", product.getName());
        Assert.assertEquals(6.55, product.getPrice(), 0);
        Assert.assertNotNull(product.getCook());
        Assert.assertEquals(TestConstants.COOK_ID, product.getCook().getId().longValue());
    }
}
