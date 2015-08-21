package com.yao.concurrent.collection.countdown;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yao on 15/8/21.
 */
public class CountBigListTest extends TestCase {

    @Test
    public void testSum() throws Exception {

        List<Integer>list=new ArrayList<>();
        for (int i=0;i<45000000;i++){
            list.add(i);
        }

        long start=System.currentTimeMillis();
        CountBigList countBigList=new CountBigList(list,4);
        System.out.println(countBigList.sum());
        System.out.println("total time:"+(System.currentTimeMillis()-start));

        long start1=System.currentTimeMillis();
        long rel=0;
        for (Integer ele:list){
            rel+=ele;
        }
        System.out.println(rel);
        System.out.println("total time:"+(System.currentTimeMillis()-start1));



    }
}