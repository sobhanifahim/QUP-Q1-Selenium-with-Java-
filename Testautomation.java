/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testautomation;

/**
 *
 * @author Sobhani
 */
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Testautomation {
//C:/Users/Sobhani/OneDrive/Desktop/selenium/chromedriver_win32/chromedriver.exe
    /**
    
     * @param args the command line arguments
     
*/
    
    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException, InvalidFormatException {
      System.setProperty("webdriver.chrome.driver","C:\\Users\\Sobhani\\OneDrive\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      
      driver.get("https://www.google.com");
      driver.manage().window().maximize();
      Thread.sleep(2000);
      driver.findElement(By.name("q")).sendKeys("By");
      Thread.sleep(10000);
      String appTitle=driver.getTitle();
      System.out.println("Title: "+appTitle);
      List<WebElement>list=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
      System.out.println(list.size());
      System.out.println("***************");
      String max;
      max=list.get(0).getText();
      int len=max.length();
      for(int x=0;x<list.size();x++){
          String l=list.get(x).getText();
          
          if(l.length()>len){
             max= l;
             len=l.length();
          }
      }
      String min;
      min=list.get(0).getText();
      int len2=min.length();
      for(int j=0;j<list.size();j++){
          String l1=list.get(j).getText();
          
          if(l1.length()<len2){
             min= l1;
             len2=l1.length();
          }
      }
        System.out.println("Longest "+max+" Length: "+max.length());
        System.out.println("Shortest "+min+" Length: "+min.length());
      
      
      
      
    }
    
}
