package listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.ExcelDataProvider;




//@Listeners(value = TestNgListeners.class) - Removed since we added in TestNG XML
public class TestNgListenersDemo {

    public static WebDriver driver = null;
    static String browserName = null;

    @SneakyThrows
    @Test(dataProvider ="test1Data", dataProviderClass = ExcelDataProvider.class)
    public void test1(String username,String password){
        System.out.println("I am inside Test 1");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Test
    public void test2(){
        System.out.println("I am inside Test 2");
        Assert.assertTrue(false);

    }

    @Test
    public void test3(){
        System.out.println("I am inside Test 3");
        throw new SkipException("This is test skipped");
    }

    @Test
    public void test4(){
        System.out.println("I am inside Test 4");

    }

}
