package com.takeneat.services.products;

import com.takeneat.services.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service managing products.
 *
 * @author paoesco
 */
@Service
public class ProductsService {

    @Autowired
    private ProductDao productDao;

    /**
     * Return a list of products.
     *
     * @return
     */
    public List<Product> search() {
        return productDao.findAll();
    }

}
