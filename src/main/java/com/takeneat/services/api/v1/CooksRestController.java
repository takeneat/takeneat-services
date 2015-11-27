package com.takeneat.services.api.v1;

import com.takeneat.services.api.utils.ApiConstants;
import com.takeneat.services.api.utils.WebServiceUtils;
import com.takeneat.services.api.v1.dto.CreateProductRequestDTO;
import com.takeneat.services.api.v1.dto.OrderDTO;
import com.takeneat.services.orders.OrdersService;
import com.takeneat.services.products.ProductsService;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
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

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/{id}/products", method = RequestMethod.POST)
    public Long addProduct(@PathVariable("id") Long cookId, @RequestBody @Valid CreateProductRequestDTO request) {
        return productsService.create(request.getName(), request.getPrice(), cookId);
    }

    @RequestMapping(value = "/{id}/orders", method = RequestMethod.GET)
    public List<OrderDTO> getOrders(@PathVariable("id") Long cookId) {
        return ordersService
                .getCookOrders(cookId)
                .stream()
                .map(order -> {
                    return new OrderDTO(order);
                })
                .collect(Collectors.toList());
    }

}
