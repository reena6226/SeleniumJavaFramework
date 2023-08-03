import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import pages.GoogleSearchPage;

public class ExtentReportsBasicDemo {

    public static void main(String[] args) {

        WebDriver driver = null;
        //start reporters

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Spark.html");

        //create ExtentReports and attach reporters - basically logs info about Test sessions, adding screenshots etc

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        //creates a toggle for given test, add all logs events under that test case

        ExtentTest test = extent.createTest("GoogleSearchTest","Description google validation");


        // just example for test
        ChromeDriverService service=new ChromeDriverService.Builder().withLogOutput(System.out).build();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        test.log(Status.INFO,"Starting test case");

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

        driver.get("https://google.com");

        test.pass("Navigates to google.com");

        googleSearchPage.sendTextBoxSearch("Automation Step by Step");

        test.fail("Not able to find ...");

        googleSearchPage.click_button_Search();



        driver.close();
        driver.quit();
        test.pass("close browser");
        test.info("test completed");

        // it will write the report in logs..
        extent.flush();






    }
}
