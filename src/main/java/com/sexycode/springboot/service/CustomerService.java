package com.sexycode.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.sexycode.springboot.dao.CustomerRepository;
import com.sexycode.springboot.model.Customer;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


/**
 * Created by hongzeyang
 * Time 2018/6/14 下午8:23
 * Desc
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private TransactionTemplate transactionTemplate;

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }


    public void deleteAllAndAddOne(Customer customer) {
        System.out.println("go into deleteAllAndAddOne");
        deleteAllAndAddOneTransactional(customer);
    }


    @Transactional
    public void deleteAllAndAddOneTransactional(Customer customer) {
        doDeleteAllAndAddOne(customer);
    }

    private void doDeleteAllAndAddOne(Customer customer) {
        customerRepository.deleteAll();
        if ("Yang".equals(customer.getFirstName())) {
            throw new RuntimeException();
        }
        customerRepository.save(customer);
    }

    public void deleteAllAndAddOneUsingTransactionTemplate(Customer customer) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                doDeleteAllAndAddOne(customer);
            }
        });
    }

}
