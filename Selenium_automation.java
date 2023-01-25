/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selenium_automation;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Sobhani
 */
public class Selenium_automation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here
        
                 Calendar calendar = Calendar.getInstance();
             int day = calendar.get(Calendar.DAY_OF_WEEK);
        
            ArrayList<String>keyword = new ArrayList<>();
            ArrayList<String>longest = new ArrayList<>();
            ArrayList<String>shortest = new ArrayList<>();
                  // Reading file from local directory
            FileInputStream file = new FileInputStream(new File("C:/Users/Sobhani/OneDrive/Documents/Excel.xlsx"));
  
            // Create Workbook instance holding reference to
            // .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
  
            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(day);
            
            int rows=sheet.getLastRowNum();
            for(int r=2;r<=rows;r++){
                XSSFRow row=sheet.getRow(r);
                
                
                    XSSFCell cell=row.getCell(2);
                    keyword.add(cell.getStringCellValue());
            }  
        
        
        
        
      System.setProperty("webdriver.chrome.driver","C:\\Users\\Sobhani\\OneDrive\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      
      driver.get("https://www.google.com");
      driver.manage().window().maximize();
      Thread.sleep(2000);
     for(int i=0;i<keyword.size();i++){
      driver.findElement(By.name("q")).sendKeys(keyword.get(i));
      Thread.sleep(5000);
      List<WebElement>list=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
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
      longest.add(max);
      shortest.add(min);
        System.out.println("Longest "+max+" Length: "+max.length());
        System.out.println("Shortest "+min+" Length: "+min.length());
        
      driver.findElement(By.name("q")).clear();
    }
     for(int p=0;p<longest.size();p++){
         System.out.println(longest.get(p));
     }
        System.out.println("##############");
     for(int q=0;q<longest.size();q++){
         System.out.println(shortest.get(q));
     }
     
     int n=0;
     for(int r=2;r<=rows;r++){
         XSSFRow row=sheet.getRow(r);
         XSSFCell cell2=row.createCell(3);
         cell2.setCellValue(longest.get(n));
         
         XSSFCell cell3=row.createCell(4);
         cell3.setCellValue(shortest.get(n));
         n++;
                    
      }
     file.close();
            
     try{
       FileOutputStream out = new FileOutputStream("C:/Users/Sobhani/OneDrive/Documents/Excel.xlsx");
       workbook.write(out);
       workbook.close();
       }catch (Exception e) {
          e.printStackTrace();
       }
        
    }
    
}
