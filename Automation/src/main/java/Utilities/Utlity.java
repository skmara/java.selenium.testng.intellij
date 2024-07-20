package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

public class Utlity  {
    private static WebDriver driver;
    private static String date= LocalDateTime.now().format(DateTimeFormatter.ofPattern("_yyyyMMddHHmmss"));
    public static void takeScreenshot(WebDriver driver,String scenarioname) throws IOException {
        TakesScreenshot screenshot=(TakesScreenshot) driver;
//        File dir=new File("screenshots");
//        if(!dir.exists()){dir.mkdir();}
        File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
        File dir=new File("Screenshots");
        if(!dir.exists()){dir.mkdir();}
        File destFile=new File(dir,scenarioname+date+".jpg");
        FileUtils.copyFile(srcFile,destFile);
    }
    public  static WebDriver getWebdriver(){
        if(driver==null){
         driver=new ChromeDriver();
        }return driver;
    }
    public static void CleanUP(){
        if(driver!=null){
            driver.quit();
        }}
//    public static void getProperties() throws IOException {
//
//        Properties properties=new Properties();
//        properties.load();
//
//            properties.getProperty("url");
//
//        }
    }




