package com.yao.schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yao on 15/7/13.
 */
public class TestPeopleSchema {
    public static void main(String[]args){

        ApplicationContext context=
                new ClassPathXmlApplicationContext("classpath*:schema/peoples.xml");

        People people0= context.getBean("people0",People.class);
        People people1= context.getBean("people1",People.class);
        People people2= context.getBean("people2",People.class);
        System.out.println(people0.getName()+" "+people0.getAge());
        System.out.println(people1.getName()+" "+people1.getAge());
        System.out.println(people2.getName()+" "+people2.getAge());

    }
}
