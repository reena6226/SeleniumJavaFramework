package org.example;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {

    @Test(dependsOnMethods = {"test2", "test3"},priority = 1)
    public void test1(){

        System.out.println("test 1");
    }

    @Test(dependsOnGroups = {"Sanity"})
    public void test2(){

        System.out.println("test 2");
    }

    @Test(groups = {"Sanity"})
    public void test3(){

        System.out.println("test 3");
    }


}
