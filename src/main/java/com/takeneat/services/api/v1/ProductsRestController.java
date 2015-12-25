package com.takeneat.services.api.v1;

import com.takeneat.services.api.exceptions.NotFoundException;
import com.takeneat.services.api.utils.ApiConstants;
import com.takeneat.services.products.ProductsService;
import com.takeneat.services.api.v1.dto.ProductDTO;
import com.takeneat.services.model.Product;
import com.takeneat.services.products.ProductDao;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author paoesco
 */
@Api
@RestController
@RequestMapping(ApiConstants.PATH_V1 + "/products")
public class ProductsRestController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductDao productDao;

    /**
     * Search a list of products.
     *
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<ProductDTO> search() {
        return productsService
                .search()
                .stream()
                .map(p -> new ProductDTO(p))
                .collect(Collectors.toList());

    }

    /**
     * Get a product information.
     *
     * @param productId
     * @return
     * @throws com.takeneat.services.api.exceptions.NotFoundException
     */
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ProductDTO get(@PathVariable("productId") Long productId) throws NotFoundException {
        Product product = productDao.findOne(productId);
        if (product == null) {
            throw new NotFoundException(String.valueOf(productId));
        }
        return new ProductDTO(product);
    }

}
