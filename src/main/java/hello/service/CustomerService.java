package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.dao.CustomerRepository;
import hello.model.Customer;


/**
 * Created by hongzeyang
 * Time 2018/6/14 下午8:23
 * Desc
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }


    public void deleteAllAndAddOne(Customer customer) {
        System.out.println("go into deleteAllAndAddOne");
        deleteAllAndAddOneTransactional(customer);
    }


    @Transactional
    public void deleteAllAndAddOneTransactional(Customer customer) {
        customerRepository.deleteAll();
        if ("Yang".equals(customer.getFirstName())) {
            throw new RuntimeException();
        }
        customerRepository.save(customer);
    }

    public void testAspect(){
        System.out.println("go into testAspect");
    }

    public void doTestAspect(){
        System.out.println("go into doTestAspect");
        testAspect();
    }
}
