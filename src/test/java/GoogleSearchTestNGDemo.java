    import config.PropertiesFile;
    import io.github.bonigarcia.wdm.WebDriverManager;
    import lombok.SneakyThrows;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.testng.annotations.*;
    import pages.GoogleSearchPage;
    import util.ExcelDataProvider;

    public class GoogleSearchTestNGDemo {

        public static WebDriver driver = null;
       static String browserName = null;

        @BeforeTest
       public void setUpTest(){

            PropertiesFile.getProperties();
            if(browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            }else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

       }

      @Test
        public static void googleSearchTest(){

            GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
            driver.get("https://google.com");
            googleSearchPage.sendTextBoxSearch("Automation Step by Step");
            googleSearchPage.click_button_Search();
        }


        @SneakyThrows
        @Test(dataProvider ="test1Data", dataProviderClass = ExcelDataProvider.class)
        public void test(String username,String password){

            System.out.println(username+"  |   "+password);
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            Thread.sleep(2000);
            // driver.findElement(By.id("submit")).click();

        }

        @AfterTest
        public void tearDown(){
           driver.quit();
           PropertiesFile.setProperties();
        }
    }
