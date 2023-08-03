import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSearchTest {

    public static WebDriver driver = null;

    public static void main(String[] args) {

        googleSearchTest();
    }

    public static void googleSearchTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        driver.get("https://google.com");
        googleSearchPage.sendTextBoxSearch("Automation Step by Step");
        googleSearchPage.click_button_Search();
        driver.close();
        driver.quit();
    }
}
