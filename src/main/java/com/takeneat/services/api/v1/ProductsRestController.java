package com.takeneat.services.api.v1;

import com.takeneat.services.api.utils.ApiConstants;
import com.takeneat.services.api.utils.WebServiceUtils;
import com.takeneat.services.products.ProductsService;
import com.takeneat.services.api.v1.dto.ProductDTO;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<ProductDTO> search() {
        return productsService
                .search()
                .stream()
                .map(p -> {
                    ProductDTO dto = new ProductDTO();
                    dto.setId(p.getId());
                    dto.setCook(p.getCook().getFirstname() + " " + p.getCook().getLastname());
                    dto.setName(p.getName());
                    dto.setPrice(p.getPrice());
                    dto.setCreationDate(WebServiceUtils.formatDate(p.getCreationDate()));
                    return dto;
                }).collect(Collectors.toList());

    }

}
