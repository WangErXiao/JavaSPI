package com.yao.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * Created by yao on 15/8/27.
 */
@Aspect
public class AuthAspect {


    @Around("@annotation(com.yao.annotation.Auth)")
    public void check(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if(method==null){
            return;
        }
        Auth auth = method.getAnnotation(com.yao.annotation.Auth.class);
        if(auth!=null){
            if(!StringUtils.isEmpty(auth.value())&&auth.value().equals("auth")){
                System.out.println(method.getName()+" pass----------");
                joinPoint.proceed();
            }else{
                System.out.println(method.getName()+" no pass---");
            }

        }
    }


}
