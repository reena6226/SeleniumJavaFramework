package org.example;

public class ExceptionHandlingDemo {

    public ExceptionHandlingDemo() {
    }

    public static void main(String[] args) {



        try{
            System.out.println("Hello world");
            int i = 1/0;
            System.out.println("Hello world two ");
            demo();
        }
        catch(Exception e){

            System.out.println("inside catch block");

            System.out.println("Message"+ e.getMessage());
            System.out.println("Cause"+  e.getCause());
            e.printStackTrace();

        }
        finally {
            System.out.println("I am inside finally block");
        }



    }


    //second way of handling exception using throws and handled in Main function where method is called

    public static void demo() throws Exception{

        System.out.println("Hello world from method");
        int i = 1/0;
    }

}
