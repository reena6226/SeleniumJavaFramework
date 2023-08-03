import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.*;
import pages.GoogleSearchPage;

public class ExtentReportTestNGDemo {

    ExtentReports extent = null;
    WebDriver driver = null;

    ExtentTest test = null;


    //in case multiple test use suite
    @BeforeSuite
    public void setUp(){
        //start reporters
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Spark.html");

        //create ExtentReports and attach reporters - basically logs info about Test sessions, adding screenshots etc
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

    }

    @BeforeTest
    public void BeforeTest(){


        // just example for test
        ChromeDriverService service=new ChromeDriverService.Builder().withLogOutput(System.out).build();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

   @Test
    public void test(){

        test = extent.createTest("GoogleSearchTest","Description google validation");
        test.log(Status.INFO,"Starting test case");
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

        driver.get("https://google.com");

        //creates a toggle for given test, add all logs events under that test case


        test.pass("Navigates to google.com");
        test.addScreenCaptureFromPath("scrnshot.png");
    }

  @Test
    public void test2(){

        //creates a toggle for given test, add all logs events under that test case

        test = extent.createTest("GoogleSearchTest","Description google validation");

        test.log(Status.INFO,"Starting test case");
        test.pass("Navigates to google.com");
        test.addScreenCaptureFromPath("scrnshot.png");

        // just example for test
        ChromeDriverService service=new ChromeDriverService.Builder().withLogOutput(System.out).build();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }


   // @AfterSuite
    public void tearDown(){

        // it will write the report in logs..
        extent.flush();

    }
}
