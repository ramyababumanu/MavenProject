package TestDay3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewLoginPageModel {
	WebDriver driver;
    HomePageClass hpc;
    LoginPage lpc;
    
  @Test
  public void f() {
	  hpc.click_login();
      lpc.type_Email("ramyababu.07@gmail.com");
      lpc.type_password("test1234$$");
      lpc.click_login_button();
  }
  @BeforeClass
  public void beforeClass() {
	//launching browser
      System.setProperty("webdriver.chrome.driver","C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      
      //open url
      driver.get("http://demowebshop.tricentis.com");
      
      hpc = new HomePageClass(driver);
      lpc = new LoginPage(driver);
  }

  @AfterClass
  public void afterClass() {
	//closing browser
      driver.close();
  }

}
