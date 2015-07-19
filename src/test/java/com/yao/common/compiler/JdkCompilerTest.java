package com.yao.common.compiler;

import junit.framework.TestCase;

import java.lang.reflect.Method;

/**
 * Created by yao on 15/7/19.
 */
public class JdkCompilerTest extends TestCase {

    public void testDoCompile() throws Throwable {
        String name="com.yao.test.Hello";
        String sourceCode="package com.yao.test;\n" +
                "\n" +
                "public class Hello{\n" +
                "\tpublic static void say(){\n" +
                "\t\tSystem.out.println(\"Hello world\");\n" +
                "\t}\n" +
                "}";
        JdkCompiler compiler=new JdkCompiler();
        Class objectClass=compiler.doCompile(name, sourceCode);
        Method method=objectClass.getMethod("say");
        Object o =objectClass.newInstance();
        method.invoke(o);



    }
}