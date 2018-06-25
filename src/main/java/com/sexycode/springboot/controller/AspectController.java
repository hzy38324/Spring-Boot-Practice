package com.sexycode.springboot.controller;

import com.sexycode.springboot.service.AspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author: hzy created on 2018/06/16
 */
@RestController
public class AspectController {
    @Autowired
    private AspectService aspectService;

    @RequestMapping("/aspect")
    public String hello() {
        aspectService.testAspect();
        return "hello";
    }
}
