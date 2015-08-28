package com.yao.annotation;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yao on 15/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:annotation/spring-aop.xml")
public class HelloWorldTest extends TestCase {

    @Autowired
    private HelloWorld helloWorld;

    @Test
    public void testSay() throws Exception {
        helloWorld.say();
    }
    @Test
    public void testSay1() throws Exception {
        helloWorld.say1();
    }
}