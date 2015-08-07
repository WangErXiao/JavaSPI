package com.yao.remote.grizzly.echo;

import org.glassfish.grizzly.filterchain.BaseFilter;
import org.glassfish.grizzly.filterchain.FilterChainContext;
import org.glassfish.grizzly.filterchain.NextAction;

import java.io.IOException;

/**
 * Created by yao on 15/8/7.
 */
public class ClientFilter extends BaseFilter{

    @Override
    public NextAction handleRead(final FilterChainContext ctx) throws IOException {
        // We get String message from the context, because we rely prev. Filter in chain is StringFilter
        final String serverResponse = ctx.getMessage();
        System.out.println("Server echo: " + serverResponse);

        return ctx.getStopAction();
    }


}
