package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GoogleSearchPage;

import java.time.Duration;

public class SeleniumWaitDemo {

    public static WebDriver driver = null;

    public static void main(String[] args) {
        seleniumWaits();
    }

    public static void seleniumWaits(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //implicit wait
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://google.com");

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("Adbsc")));


        driver.findElement(By.id("adbc")).click();

        driver.close();

    }
}
