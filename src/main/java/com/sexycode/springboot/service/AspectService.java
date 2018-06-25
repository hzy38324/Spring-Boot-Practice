package com.sexycode.springboot.service;

import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author: hzy created on 2018/06/16
 */
@Service
public class AspectService {

    public AspectService(){
        System.out.println("go into aspectService constructor");
    }

    public void testAspect(){
        System.out.println("go into testAspect");
    }

    public void doTestAspect(){
        System.out.println("go into doTestAspect");
        testAspect();
    }
}
