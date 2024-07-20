package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
WebDriver driver=new ChromeDriver();
public  void LaunchUrl(String url){driver.get(url);}


}
