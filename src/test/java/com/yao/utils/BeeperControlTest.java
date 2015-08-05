package com.yao.utils;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by yao on 15/8/5.
 */
public class BeeperControlTest extends TestCase {

    @Test
    public void testBeepForAndHour() throws Exception {
        BeeperControl control=new BeeperControl();
        control.beepForAndHour();
    }
}