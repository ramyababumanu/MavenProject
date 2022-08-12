package TestDay3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactoryClass {
	WebDriver driver;
	@FindBy(name="Email")public WebElement email;
	@FindBy(name="Password")public WebElement pwd;
	@FindBy(xpath="//input[@value='Log in']")public WebElement loginbutton;
	
	public LoginPageFactoryClass(WebDriver driver)
	{
		this.driver=driver;
	}

	public void perform_login(String e,String p)
	{
		email.sendKeys(e);
		pwd.sendKeys(p);
		loginbutton.click();
	}
}
