package PageObjectModel;


import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver = new ChromeDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void LaunchUrl(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public String getTitle(){return driver.getTitle();}

    public void ClickonOpenPosition() {
        HighLightText(Locators.openposisionBy);
        driver.findElement(Locators.openposisionBy).click();
    }
    public boolean IsWhatsyourPassionVisible(){
        HighLightText(Locators.whatsyourPassionBy);
        return driver.findElement(Locators.whatsyourPassionBy).isDisplayed();
    }
    public boolean IscatogoryPresent(String catogory){
        HighLightText(Locators.catagoryBy(catogory));
        return driver.findElement(Locators.catagoryBy(catogory)).isDisplayed();
    }
    public boolean IsErrorPresent(String catogory){
        HighLightText(Locators.errorBy(catogory));
        return driver.findElement(Locators.errorBy(catogory)).isDisplayed();
    }
    public boolean Is404ErrorPresent(String catogory){
        HighLightText(Locators.PageError(catogory));
        return driver.findElement(Locators.PageError(catogory)).isDisplayed();
    }
    public void ClickCatogory(String name){
        HighLightText(Locators.catagoryBy(name));
        driver.findElement(Locators.catagoryBy(name)).click();
    }
    public void ClickRemoteJobs(){
        HighLightText(Locators.remoteJobBy);
        js.executeScript("arguments[0].click()",driver.findElement(Locators.remoteJobBy)
        );
        //driver.findElement(Locators.remoteJobBy).click();
    }
    public void ClickApplyNow(){
        HighLightText(Locators.applyNowBy);
        driver.findElement(Locators.applyNowBy).click();
    }
    public void ClickSubmitNow(){
        HighLightText(Locators.submitBy);
        driver.findElement(Locators.submitBy).click();
    }
    public void Clickopenings(String name){
        HighLightText(Locators.aButtonBy(name));
        driver.findElement(Locators.aButtonBy(name)).click();
    }
    public void HighLightText(By element) {
        js.executeScript("arguments[0].style.background='yellow'", driver.findElement(element));}
    public void SwitchtoWindow(String title){
        String[] windoHandles=driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(windoHandles[1]);
    }

    private static class Locators {
        public static By openposisionBy = By.xpath("//a[text()='Open Positions']");
        public static By whatsyourPassionBy = By.xpath("//h2[text()='What’s your passion?']");
        public static By remoteJobBy = By.xpath("//span[text()='Remote Jobs']");
        public static By applyNowBy = By.xpath("(//lyte-yield[text()='Apply Now'])[1]");
        //public static By firstNamedd = By.xpath("//lyte-drop-button[@data-zcqa='manual_Salutation']");
        public static By submitBy = By.xpath("//lyte-yield[text()='Submit Application']");
        public static By catagoryBy(String name){return By.xpath(String.format("//h6[contains(text(),'%s')]",name));}
        public static By aButtonBy(String name){return By.xpath(String.format("//a[contains(text(),'%s')]",name));}
        public static By errorBy(String name){return By.xpath(String.format("//span[text()='%s cannot be empty']",name));}
        public static By PageError(String name){return By.xpath(String.format("//h1[text()='%s']",name));}
    }

}
