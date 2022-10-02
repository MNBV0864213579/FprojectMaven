import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class Project {

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void project() throws IOException, InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get(Helper.WIKI);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.SERCH))).sendKeys("cow");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.BTSER))).click();

 //    לא הצלחתי להעתיק את הטקסט
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.WIKITXT))).getText();
        String copy=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.WIKITXT))).getText();
        File fileA =new File(Helper.FOLDER+"1.txt");
        FileWriter w= new FileWriter(fileA);
        w.write(copy);

        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,5000)");
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file1=new File(Helper.FOLDER+"i.jpg");
        FileUtils.copyFile(file,file1);

        jse.executeScript("window.scrollBy(0,-5000)");
        File file2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file3=new File(Helper.FOLDER+"i1.jpg");
        FileUtils.copyFile(file2,file3);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(Helper.AUTO);
        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.DRESS))).click();
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.CASUAL))).click();
        jse.executeScript("window.scroll(0,500)");
        File file4=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File file5=new File(Helper.FOLDER+"i2.jpg");
        FileUtils.copyFile(file4,file5);
        driver.navigate().back();

         wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.EVENING))).click();
         jse.executeScript("window.scroll(0,500)");
        File file6=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File file7=new File(Helper.FOLDER+"i3.jpg");
        FileUtils.copyFile(file6,file7);

        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.SINGIN))).click();
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.EMAIL))).sendKeys("coolkid work");
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.CREAT))).click();
        File file8=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File file9=new File(Helper.FOLDER+"i4.jpg");
        FileUtils.copyFile(file8,file9);



        driver.quit();



    }
}
