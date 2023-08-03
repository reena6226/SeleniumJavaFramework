package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

    public static String path = "/Users/pmgirish/IdeaProjects/DemoTwo/src/main/config/config.properties";

    static Properties properties = new Properties();

    public static void main(String[] args) {
        getProperties();
        setProperties();
        getProperties();
    }

    //Get Property from config.properties file
    public static void getProperties(){

        try {
            InputStream inputStream = new FileInputStream(path);
            properties.load(inputStream);
            String browser = properties.getProperty("browser");
            System.out.println("browser="+ browser);
           // GoogleSearchTestNGDemo.browserName = browser;

        }
        catch (Exception exp){
           System.out.println("message"+ exp.getMessage());
        }

    }

    //Set property

    public static void setProperties(){
        try{

            OutputStream outputStream = new FileOutputStream(path);
            properties.setProperty("Result","pass");
            properties.store(outputStream, null);


        }
        catch(Exception exp){
            System.out.println("message"+ exp.getMessage());
        }
    }



}
