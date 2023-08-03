package org.example;

import org.testng.annotations.Test;

@Test(groups = {"AllClasstests"})
public class TestNGGroupsDemo {

    @Test(groups = {"sanity"})
    public void one(){

      System.out.println("Sanity one");

    }

    @Test(groups = {"smoke","sanity"})
    public void two(){

        System.out.println("Sanity+smoke one");

    }


    @Test(groups = {"smoke"})
    public void three(){
        System.out.println("smoke one");


    }

    @Test(groups = {"regression"})
    public void four(){
        System.out.println("regression one");


    }


}
