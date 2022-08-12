package TestDay3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class LoginPage {
WebDriver driver;
	
	//locate login page class element
	By Email= By.id("Email");
	By Password=By.name("Password");
	By loginbutton=By.xpath("//input[@value='Log in']");
	
	//constructor
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
		}

		//method
		public void type_Email(String email)
		{
			driver.findElement(Email).sendKeys(email);
		}
		public void type_password(String pwd)
		{
			driver.findElement(Password).sendKeys(pwd);
		}
		public void click_login_button()
		{
			driver.findElement(loginbutton).click();
		}
		
	

	
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
