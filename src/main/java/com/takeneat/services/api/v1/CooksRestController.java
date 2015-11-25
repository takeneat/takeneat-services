package com.takeneat.services.api.v1;

import com.takeneat.services.api.utils.ApiConstants;
import com.takeneat.services.api.v1.dto.CreateProductRequestDTO;
import com.takeneat.services.products.ProductsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author paoesco
 */
@Api
@RestController
@RequestMapping(ApiConstants.PATH_V1 + "/cooks")
public class CooksRestController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/{id}/products", method = RequestMethod.POST)
    public Long addProduct(@PathVariable("id") Long cookId, @RequestBody CreateProductRequestDTO request) {
        return productsService.create(request.getName(), request.getPrice(), cookId);
    }

}
