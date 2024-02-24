package PageCLasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard {

    WebDriver driver;
    public DashBoard(WebDriver driver){

        this.driver=driver;
    }

    public LoginPageClass clickRediffMailButton(){
        driver.findElement(By.className("mailicon")).click();
        return new LoginPageClass(driver);
    }



}
