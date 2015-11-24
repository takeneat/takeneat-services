package com.takeneat.services.products;

import com.takeneat.services.products.dto.ProductDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author paoesco
 */
@RestController
@RequestMapping("/products")
public class ProductsRestController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<ProductDTO> search() {
        return productsService
                .search()
                .stream()
                .map(p -> {
                    ProductDTO dto = new ProductDTO();
                    dto.setId(p.getId());
                    dto.setCook(p.getUser().getFirstname() + " " + p.getUser().getLastname());
                    dto.setName(p.getName());
                    dto.setPrice(p.getPrice());
                    dto.setPostedDate(p.getPostedDate().toString());
                    return dto;
                }).collect(Collectors.toList());

    }

}
