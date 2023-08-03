package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

   public WebDriver driver = null;
   // constructor used to initiate the driver when the object of this class is created
   public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    //Defined the object locators
   public By textBoxSearch = By.id("input");
   public By buttonSearch = By.id("container");

//defined the object methods where actions are performed.
    public void sendTextBoxSearch(String text){

        try {
            driver.findElement(textBoxSearch).sendKeys(text);

        }
        catch (NoSuchElementException exp){

            System.out.println("Exception %s%n"+ exp.getCause());

        }


    }

    public void click_button_Search() throws NoSuchElementException{

        driver.findElement(buttonSearch).sendKeys(Keys.RETURN);

    }


}
