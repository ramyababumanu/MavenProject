package TestDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageClass {
	
	WebDriver driver;
	
	//locator for all the home page web elements
	By registerlink=By.linkText("Register");
	By loginlink=By.linkText("Log in");
	By searchbox=By.className("q");
	
	//constructor to initiate webdriver
	public HomePageClass(WebDriver driver) {
		this.driver=driver;
	}
	//create reusable methods
	public void click_register() {
		driver.findElement(registerlink).click();
	}
	public void click_login() {
		driver.findElement(loginlink).click();
	}
	public void type_search(String searchvalue) {
		driver.findElement(searchbox).sendKeys(searchvalue);
	}

}
