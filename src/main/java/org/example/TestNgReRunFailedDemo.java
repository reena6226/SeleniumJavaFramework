package org.example;

import listeners.ReTryAnalyser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgReRunFailedDemo {

    @Test
    public void test1(){

        System.out.println("Inside Test 1");
    }


    @Test
    public void test2(){
        //int i = 1/0;

        System.out.println("Inside Test 2");
    }

    @Test(retryAnalyzer = listeners.ReTryAnalyser.class)
    public void test3(){

        Assert.assertTrue(0>1);

        System.out.println("Inside Test 3");
    }
}
