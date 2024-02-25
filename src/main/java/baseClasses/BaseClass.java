package baseClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.UtilityFile;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    public WebDriver driver;

   public ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\extentReport"+ UtilityFile.getCurrentTime() + ".html");
    public ExtentReports extentReports = new ExtentReports();
    public ExtentTest test;

    @BeforeMethod(alwaysRun = true)
    public   void setup(){
         extentReports.attachReporter(extentSparkReporter);
         extentReports.setUsingNaturalConf(true);
        String browser = UtilityFile.readProperty("C:\\Users\\Sachin\\IdeaProjects\\PageObjectModel\\config.properties", "browser");
        if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("121");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty( "webdriver.gecko.driver" , "C:\\Users\\Sachin\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else{
            System.out.println("browser not available");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("browser open");
        driver.get(UtilityFile.readProperty("C:\\Users\\Sachin\\IdeaProjects\\PageObjectModel\\config.properties", "env1"));
    }

    @AfterMethod(alwaysRun = true)
    public void terminate(ITestResult result) throws IOException {
        if (result.getStatus()== ITestResult.FAILURE){
            String path =UtilityFile.captureSS(driver,result.getName());
            test.log(Status.FAIL ,"Test case fail",MediaEntityBuilder.createScreenCaptureFromPath(path).build());

        }
        driver.quit();
        extentReports.flush();
        System.out.println("browser close");
    }

}
