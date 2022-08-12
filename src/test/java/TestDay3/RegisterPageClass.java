package TestDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageClass {
	WebDriver driver;
	
	//locate register page class element
	By gender= By.id("gender-female");
	By fn=By.name("FirstName");
	By ln=By.name("LastName");
	By email=By.name("Email");
	By psd=By.name("Password");
	By confirmpsd=By.name("ConfirmPassword");
	By registerbutton=By.name("register-button");
	
	//constructor
	public RegisterPageClass(WebDriver driver)
	{
		this.driver=driver;
	}

	//method
	public void click_gender()
	{
		driver.findElement(gender).click();
	}
	public void type_firstname(String firstname)
	{
		driver.findElement(fn).sendKeys(firstname);
	}
	public void type_lastname(String lastname)
	{
		driver.findElement(ln).sendKeys(lastname);
	}
	public void type_email(String e)
	{
		driver.findElement(email).sendKeys(e);
	}
	public void type_password(String pwd)
	{
		driver.findElement(psd).sendKeys(pwd);
	}
	public void type_confirmpsd(String cpwd)
	{
		driver.findElement(confirmpsd).sendKeys(cpwd);
	}
	public void click_register_button()
	{
		driver.findElement(registerbutton).click();
	}
}
