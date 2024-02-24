package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class UtilityFile {

    public static String  readProperty(String path, String key)  {

        Properties prop = new Properties();
        try {
            FileReader reader = new FileReader(path);
            prop.load(reader);
        }
        catch (Exception exc){
            System.out.println("File not found");
        }

       return prop.getProperty(key);


    }


   public static String captureSS(WebDriver driver, String name)  {
     File source=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     File dest= new File(System.getProperty("user.dir") + "\\test-output\\" + name + getCurrentTime()+ ".png" );
     try {
         FileHandler.copy(source, dest);
     }
     catch (Exception e){
         System.out.println("not able to take SS");
     }

        return System.getProperty("user.dir") + "\\test-output\\" + name +getCurrentTime()+ ".png";
 }



 public static String getCurrentTime(){
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
     LocalDateTime now = LocalDateTime.now();
     return dtf.format(now);
 }
}
