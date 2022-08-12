package TestDay3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class MyClass {
	WebDriver driver;
	HomePageClass hp;
	RegisterPageClass rpc;
	LoginPageFactoryClass lp;
	ExtentSparkReporter sparkReporter;//create customized html report
	ExtentReports report;
	ExtentTest logger;
	
	
  @Test(enabled=true,priority=1)
  public void registerTest() {
	  logger=report.createTest("Register Test Case");
	//Registration
			hp.click_register();
		hp.click_login();
		//log the status in the report
			logger.generateLog(Status.INFO, "Navigated to Register Page");
			rpc.click_gender();
			rpc.type_firstname("Ramya");
			rpc.type_lastname("Babu");
			rpc.type_email("ramyababu.07@gmail.com");
			rpc.type_password("test1234$$");
			rpc.type_confirmpsd("test1234$$");
			rpc.click_register_button();
		logger.generateLog(Status.PASS, "Register Success");
  }
  @Test(priority=2)
  public void LoginTest()
  {
	  logger=report.createTest("Login Test Case");
	  hp.click_login();
	  lp.perform_login("ramyababu.07@gmail.com","Test1234$$");
	  logger.log(Status.PASS, "Login Success");
  }
  @Test(priority=3)
  
	  public void Testcase3()
	  {
	  logger=report.createTest("test case 3");
	  logger.log(Status.INFO,MarkupHelper.createLabel("Running Test Case 3",ExtentColor.GREY));
	  driver.get("https://lkmdemoaut.accenture.com/TestMeApp");
	  AssertJUnit.assertEquals(driver.getTitle(), "Home");//Assertion will be passed
	  }
  @Test(priority=4)
  
  public void Testcase4()
  {
  logger=report.createTest("test case 4");
  logger.log(Status.INFO,MarkupHelper.createLabel("Running Test Case 4",ExtentColor.GREY));
  driver.get("https://www.google.com");
  AssertJUnit.assertEquals(driver.getTitle(), "MSN");//Assertion will be failed
  }
  @Test(priority=5)
  public void Testcase5()
  {
  logger=report.createTest("test case 5");
  logger.log(Status.INFO,MarkupHelper.createLabel("Running Test Case 5",ExtentColor.GREY));
  driver.get("https://in.yahoo.com");
  //AssertJUnit.assertEquals(driver.getTitle(), "MSN");//Assertion will be failed
  throw new SkipException("Intentionally skippinh this test case for demo purpose");
  }
  //this method will be executed after each test case method has been executed
  //@AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  if(result.getStatus()==ITestResult.SUCCESS) {
		  logger.log(Status.PASS, MarkupHelper.createLabel("Test Passed-"+result.getName(), ExtentColor.GREEN));
	  }else if(result.getStatus()==ITestResult.SKIP) {
          logger.log(Status.PASS, MarkupHelper.createLabel("Test Skipped -"+result.getName(), ExtentColor.AMBER));
	  }else if(result.getStatus()==ITestResult.FAILURE) {
		  logger.log(Status.FAIL, MarkupHelper.createLabel("Test Passed-"+result.getName(), ExtentColor.RED));
		 
		  //take screenshot if test case is failed
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  //store it as file
		  File screenshot=ts.getScreenshotAs(OutputType.FILE);
		  String loc="C:\\Softwares\\screenshot\\"+result.getName()+"screenshot1.png";
		  FileUtils.copyFile(screenshot, new File(loc));
		  logger.addScreenCaptureFromPath(loc);
	  }
  }
  
  @BeforeClass
  public void beforeClass() {
	//launching browser
      System.setProperty("webdriver.chrome.driver","C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      //report
      sparkReporter=new ExtentSparkReporter("C:\\Softwares\\Screenshot\\MyReport.html");
    	report=new ExtentReports();
    report.attachReporter(sparkReporter);
      //configure report name n theme
    sparkReporter.config().setReportName("My Extent Report");
    sparkReporter.config().setTheme(Theme.DARK);
    //system info defined using report class
    report.setSystemInfo("Tester Name", "Ramya");
    report.setSystemInfo("Testing type", "Functional Testing");
    report.setSystemInfo("Enviroment", "System Testing Environment");
    
      //open url
      driver.get("http://demowebshop.tricentis.com");
      //create an object of HomePageClass
      hp=new HomePageClass(driver);
      rpc=new RegisterPageClass(driver);
      //initialize loginpage class through page factory
      lp=PageFactory.initElements(driver,LoginPageFactoryClass.class);
      
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  //driver.switchTo().window(nameOrHandle);
	 report.flush();
  }

}
