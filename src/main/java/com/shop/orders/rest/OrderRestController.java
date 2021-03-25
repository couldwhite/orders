package com.shop.orders.rest;

import com.shop.orders.domain.Orders;
import com.shop.orders.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders/")
public class OrderRestController {

    @Autowired
    OrderServiceInterface orderServiceInterface;

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> getOrder (@PathVariable("id") Long idOrder){
        if(idOrder==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Orders orders = this.orderServiceInterface.getById(idOrder);

        if(orders ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> saveOrder (@RequestBody @Validated Orders orders){
        if (orders ==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.orderServiceInterface.save(orders);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> updateOrder (@RequestBody @Validated Orders orders){
        if (orders ==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.orderServiceInterface.save(orders);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> deleteOrder (@PathVariable("id") Long idOrder){
        if (idOrder==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.orderServiceInterface.delete(idOrder);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Orders>> getAllOrders (){
        List<Orders> orders = this.orderServiceInterface.getOrders();
        if (orders == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
