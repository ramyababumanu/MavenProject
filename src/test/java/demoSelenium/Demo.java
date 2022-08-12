package demoSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
	
	WebDriver driver;
	
  @Test
  public void f() {
	  
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\Training1\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("http://www.google.co.in");
	 driver.findElement(By .linkText("Gmail")).click();
  }
}
