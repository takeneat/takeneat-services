package com.takeneat.services.products;

import com.takeneat.services.Boot;
import com.takeneat.services.model.Product;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author paoesco
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Boot.class)
public class ProductsServiceTest {

    @Autowired
    private ProductsService productsService;

    @Test
    public void testFindAll() {
        List<Product> results = productsService.search();
        Assert.assertEquals(2, results.size());
    }
}
