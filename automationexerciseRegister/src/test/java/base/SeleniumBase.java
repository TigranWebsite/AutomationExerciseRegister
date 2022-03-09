package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class SeleniumBase {

    public WebDriver driver;
     private String baseUrl = "https://automationexercise.com/";


    public String setBaseUrl() {
        this.baseUrl = baseUrl;
        return baseUrl;
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32_99/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.getLogLevel();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        //  driver.get(baseUrl);
    }
}