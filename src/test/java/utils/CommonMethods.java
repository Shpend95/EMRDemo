package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void launchBrowser(){
        driver=new EdgeDriver();
        driver.get("https://demo.openemr.io/openemr/portal");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        initializePageObjects();
    }

    public static void selectFromDropDown(WebElement dropDown, int index){
        Select select=new Select(dropDown);
        select.selectByIndex(index);
    }

    public static void selectFromDropDown(WebElement dropDown,String visibleText){
        Select select=new Select(dropDown);
        select.selectByVisibleText(visibleText);
    }

    public static void selectFromDropDown(String value,WebElement dropDown){
        Select select=new Select(dropDown);
        select.selectByValue(value);
    }

    public void selectTime(String time){
        WebElement timeSlot=driver.findElement(By.linkText(time));
        timeSlot.click();
    }
    public void selectTimeX(String time){
        WebElement timeSlot=driver.findElement(By.xpath("//a[text()='" + time +"']"));
        timeSlot.click();
    }

    public void selectTimeFlexible(String time){
        WebElement timeSlot=driver.findElement(By.xpath("//a[contains(text(),'" + time + "')]"));
        timeSlot.click();
    }

    public static void sendText(String text,WebElement element){
        element.clear();
        element.sendKeys(text);
    }

    public  static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        return wait;
    }

    public static void waitForElementToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
}
