package com.takeneat.services.products;

import com.takeneat.services.model.Product;
import com.takeneat.services.users.UserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service managing products.
 *
 * @author paoesco
 */
@Service
public class ProductsService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;

    /**
     * Return a list of products.
     *
     * @return
     */
    public List<Product> search() {
        return productDao.findAll();
    }

    /**
     * Create a new product.
     *
     * @param name
     * @param price
     * @param cookId
     * @return
     */
    @Transactional
    public Long create(String name, double price, long cookId) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCook(userDao.findOne(cookId));
        Product createdProduct = productDao.save(product);
        return createdProduct.getId();
    }

}
