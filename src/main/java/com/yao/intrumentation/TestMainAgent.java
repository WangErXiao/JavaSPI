package com.yao.intrumentation;


import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * Created by yao on 15/8/9.
 */
public class TestMainAgent {
    public static void main(String[]args) throws InterruptedException, IOException, AgentLoadException, AgentInitializationException, AttachNotSupportedException {
        VirtualMachine vm = VirtualMachine.attach(args[0]);
        vm.loadAgent("/Users/yao/workspace/private/JavaSPI/target/classes/agentmain.jar");
    }
}
