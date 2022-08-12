package TestDay2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTestDay1 {
  @Test
  public void f() {
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}

package dat1.test;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;



public class NewTestDay1 {
    WebDriver driver;
  @Test
  public void f() {
      //click on register
      driver.findElement(By.linkText("Register")).click();
      //click on male
      driver.findElement(By.id("gender-male")).click();
      //type first name as Raj
      driver.findElement(By.name("FirstName")).sendKeys("Raj");
      //type last name as Pandey
      driver.findElement(By.name("LastName")).sendKeys("Pandey");
      //type email name as raj@gmail.com
      driver.findElement(By.name("Email")).sendKeys("panderaj78652@gmail.com");
      //type Password name as raj123
      driver.findElement(By.name("Password")).sendKeys("raj123");
      //type ConfirmPassword name as raj123
      driver.findElement(By.name("ConfirmPassword")).sendKeys("raj123");
     //click on submit-registration button
      driver.findElement(By.id("register-button")).click();
      
      
  }
  @BeforeMethod
  public void beforeMethod() {
      //launching browser
      System.setProperty("webdriver.chrome.driver","C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      
      //open url
      driver.get("http://demowebshop.tricentis.com");
  }
  



 @AfterMethod
  public void afterMethod() {
      //closing browser
      //driver.close();
  }



}
