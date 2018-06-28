package com.sexycode.springboot.service;

import com.sexycode.springboot.dao.CustomerRepository;
import com.sexycode.springboot.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


/**
 * Created by hongzeyang
 * Time 2018/6/14 下午8:23
 * Desc
 */
@Service
public class TestTxService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createTwoTxStep2() {
        customerRepository.findAll();
    }

}
