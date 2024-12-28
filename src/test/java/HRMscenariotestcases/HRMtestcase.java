package HRMscenariotestcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import HRMscenario2.HRMloginpage;

public class HRMtestcase {
	public WebDriver driver;
	HRMloginpage hp;
  @Test
  public void verifylogin() {
	  hp.login("Admin", "admin123");

		AssertJUnit.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		System.out.println("login successfully");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new ChromeDriver() ;
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp=new  HRMloginpage(driver);
	  
  }

 

}
