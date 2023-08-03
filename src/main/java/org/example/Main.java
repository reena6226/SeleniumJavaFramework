package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

        System.out.println("Hello world!");

        logger.info("This is infor message");
        logger.error("This is error");
        logger.warn("This is warn");
        logger.fatal("This is fatal");

        System.out.println("continue");

    }
}