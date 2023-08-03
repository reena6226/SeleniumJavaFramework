package util;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {


    public static WebDriver driver = null;
    static String browserName = null;
    @BeforeTest
    public void setUpTest(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
    }


    @SneakyThrows
    @Test(dataProvider ="test1Data" )
    public void test(String username,String password){

        System.out.println(username+"  |   "+password);
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
       // driver.findElement(By.id("submit")).click();

    }


    // how to use testNG annonation for data provider
    @DataProvider(name = "test1Data")
    public Object[][] getData(){

        String projectPath = System.getProperty("user.dir");

        Object data[][] = testData(projectPath+"/Excel/Book1.xlsx","DataSheet");
        return data;
    }

    //create a function and create object for excel util class
    public static Object[][] testData(String excelPath,String sheetName){

        ExcelUtils excelUtils = new ExcelUtils(excelPath,sheetName);
        int rowCount = excelUtils.getRowCount();
        int columnCount = excelUtils.getColumnCount();

        Object data[][] = new Object[rowCount-1][columnCount];

        for(int i =1; i<rowCount; i++){
            for(int j =0; j<columnCount;j++){
               String celldata =  excelUtils.getCellData(i,j);
                System.out.println("cell data"+celldata);
                data[i-1][j]= celldata;
            }
        }
        return data;
    }
}
