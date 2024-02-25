import PageCLasses.DashBoard;
import PageCLasses.LoginPageClass;
import baseClasses.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.UtilityFile;

import java.time.Duration;

public class TestRediffLogin extends BaseClass {

    DashBoard dashBoard;
    LoginPageClass loginPageCLass;

    @Test
    public void verifyRediffMail(){
        test = extentReports.createTest("VerifyRediffmail");
        dashBoard =new DashBoard(driver);
        test.log(Status.INFO ,"click rediff mail button");
        loginPageCLass  =dashBoard.clickRediffMailButton();
        test.log(Status.INFO ,"assert user name presence");
        Assert.assertTrue( loginPageCLass.isUserNameTextDisplayed());
        test.log(Status.PASS , "tc001 is passed");
    }

}
