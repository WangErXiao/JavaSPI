package com.yao.intrumentation;


import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by yao on 15/8/9.
 */
public class PeopleClassFileTransformer implements ClassFileTransformer {

    /**
     * 通过javassist修改字节码
     * @param loader
     * @param className
     * @param classBeingRedefined
     * @param protectionDomain
     * @param classfileBuffer
     * @return
     * @throws IllegalClassFormatException
     */
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("load class:"+className);

        if("com/yao/intrumentation/People".equals(className)){
            try {
                //通过javassist修改sayHello方法字节码

                CtClass ctClass= ClassPool.getDefault().get(className.replace('/','.'));

                CtMethod sayHelloMethod=ctClass.getDeclaredMethod("sayHello");

                sayHelloMethod.insertBefore("System.out.println(\"before sayHello----\");");

                sayHelloMethod.insertAfter("System.out.println(\"after sayHello----\");");

                return ctClass.toBytecode();

            } catch (NotFoundException e) {
                e.printStackTrace();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return classfileBuffer;
    }
}
