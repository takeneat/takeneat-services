package com.takeneat.services.api.v1;

import com.takeneat.services.orders.OrdersService;
import com.takeneat.services.api.v1.dto.OrderDTO;
import com.takeneat.services.api.v1.dto.OrderRequestDTO;
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
@RestController
@RequestMapping("/consumers")
public class ConsumersRestController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/{id}/orders", method = RequestMethod.POST)
    public Long newOrder(@PathVariable("id") Long consumerId, @RequestBody OrderRequestDTO request) {
        return ordersService.newOrder(consumerId, request.getProductId());
    }

    @RequestMapping(value = "/{id}/orders", method = RequestMethod.GET)
    public List<OrderDTO> getOrders(@PathVariable("id") Long consumerId) {
        return ordersService
                .getOrders(consumerId)
                .stream()
                .map(o -> {
                    OrderDTO dto = new OrderDTO();
                    dto.setCook(o.getProduct().getUser().getFirstname() + " " + o.getProduct().getUser().getLastname());
                    dto.setOrderId(o.getId());
                    dto.setProductId(o.getProduct().getId());
                    dto.setProductName(o.getProduct().getName());
                    dto.setProductPrice(o.getProduct().getPrice());
                    dto.setDate(o.getCreationDate().toString());
                    // TODO : Date to String
                    return dto;
                })
                .collect(Collectors.toList());
    }

}
