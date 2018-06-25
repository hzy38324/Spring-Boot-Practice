package com.sexycode.springboot.practice.beanPostProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author: hzy created on 2018/06/16
 */
@Component
public class Bean4BBP implements InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(Bean4BBP.class);

    public Bean4BBP(){
        log.info("construct Bean4BBP");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("init Bean4BBP");
    }
}
