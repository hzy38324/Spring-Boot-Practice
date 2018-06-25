package com.sexycode.springboot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * Created by hongzeyang
 * Time 2018/6/15 下午12:25
 * Desc
 */
@Aspect
@Component
public class MyAspect {
    @Before("execution(* com.sexycode.springboot.service.AspectService.testAspect())")
    public void processBeforeTestAspect(){
        System.out.println("process before test aspect");
    }
}
