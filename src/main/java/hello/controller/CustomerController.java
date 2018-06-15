package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.service.CustomerService;
import hello.model.Customer;


/**
 * Created by hongzeyang
 * Time 2018/6/14 下午8:20
 * Desc
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/customer")
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

    @RequestMapping("/v1.0/aspect")
    public String testAspectV1() {
        customerService.testAspect();
        return "success";
    }

    @RequestMapping("/v2.0/aspect")
    public String testAspectV2() {
        customerService.doTestAspect();
        return "success";
    }

}

