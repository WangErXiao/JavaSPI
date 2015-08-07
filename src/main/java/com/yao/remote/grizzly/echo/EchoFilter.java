package com.yao.remote.grizzly.echo;

import org.glassfish.grizzly.filterchain.BaseFilter;
import org.glassfish.grizzly.filterchain.FilterChainContext;
import org.glassfish.grizzly.filterchain.NextAction;

import java.io.IOException;

/**
 * Created by yao on 15/8/7.
 */
public class EchoFilter extends BaseFilter {


    @Override
    public NextAction handleRead(FilterChainContext ctx)
            throws IOException {

        final Object peerAddress = ctx.getAddress();

        final Object message = ctx.getMessage();

        ctx.write(peerAddress, message, null);

        return ctx.getStopAction();
    }

}
