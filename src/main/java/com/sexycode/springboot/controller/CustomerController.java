package com.sexycode.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sexycode.springboot.service.CustomerService;
import com.sexycode.springboot.model.Customer;


/**
 * Created by hongzeyang
 * Time 2018/6/14 下午8:20
 * Desc
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Iterable<Customer> findAll() {
        return customerService.findAll();
    }


    @RequestMapping(value = "/v1.0/customer", method = RequestMethod.POST)
    public String deleteAllAndAddOneV1(@RequestBody Customer customer) {
        customerService.deleteAllAndAddOneTransactional(customer);
        return "success";
    }

    @RequestMapping(value = "/v2.0/customer", method = RequestMethod.POST)
    public String deleteAllAndAddOneV2(@RequestBody Customer customer) {
        customerService.deleteAllAndAddOne(customer);
        return "success";
    }

    @RequestMapping(value = "/v3.0/customer", method = RequestMethod.POST)
    public String deleteAllAndAddOneV3(@RequestBody Customer customer) {
        customerService.deleteAllAndAddOneUsingTransactionTemplate(customer);
        return "success";
    }

    @RequestMapping(value = "/createTwoTx", method = RequestMethod.POST)
    public String createTwoTx(@RequestBody Customer customer) {
        customerService.createTwoTx(customer);
        return "success";
    }

}

