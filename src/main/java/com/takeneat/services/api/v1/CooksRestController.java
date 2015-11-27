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
    public Long addProduct(@PathVariable("id") Long cookId, @RequestBody CreateProductRequestDTO request) {
        return productsService.create(request.getName(), request.getPrice(), cookId);
    }

    @RequestMapping(value = "/{id}/orders", method = RequestMethod.GET)
    public List<OrderDTO> getOrders(@PathVariable("id") Long cookId) {
        return ordersService
                .getCookOrders(cookId)
                .stream()
                .map(o -> {
                    OrderDTO dto = new OrderDTO();
                    dto.setCook(o.getProduct().getCook().getFirstname() + " " + o.getProduct().getCook().getLastname());
                    dto.setOrderId(o.getId());
                    dto.setProductId(o.getProduct().getId());
                    dto.setProductName(o.getProduct().getName());
                    dto.setProductPrice(o.getProduct().getPrice());
                    dto.setCreationDate(WebServiceUtils.formatDate(o.getCreationDate()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

}
