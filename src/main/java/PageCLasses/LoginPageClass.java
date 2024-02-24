package PageCLasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageClass {


    WebDriver driver;
    public LoginPageClass(WebDriver driver){

        this.driver=driver;
    }


    public boolean  isUserNameTextDisplayed(){
        return driver.findElement(By.xpath("//p[text()='Username']")).isDisplayed();
    }
}
