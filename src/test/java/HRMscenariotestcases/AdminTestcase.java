package HRMscenariotestcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HRMscenario2.AdminPage;



public class AdminTestcase {
	
		public WebDriver driver;
		AdminPage ad;
	  @Test(priority=1)
	  public void verifylogin() {
		  ad.login("Admin","admin123");
		  Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		  System.out.println("login successfully");
	  }
	  @Test(priority=2)
	  public void verifycount() {
		 int numb= ad.menucount();
		 System.out.println("number:"+numb);
		 
	  }
	  @Test(priority=2)
	  public void verifyoption() {
		  ad.option();
		  Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		  System.out.println("login successfully");
	  }
	  @Test(priority=3)
	  public void verifyclick()
	  {
		  ad.addclick();
		  Assert.assertTrue(driver.getCurrentUrl().contains("viewSystemUsers"));
		  System.out.println("Test case pass");
		  
	  }
	  @Test(priority=4)
	  public void verifyadmin() {
		  ad.verifyadd();
		
	  }
	
	  @Test(priority=5)
	  public void verifydrop()
	  
	  {
		  ad.dropdown();
	  }
	  
	  @Test(priority=6)
	  public void verifystatus() {
		  ad.status();
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
		  driver=new ChromeDriver() ;
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			ad=new  AdminPage(driver);
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }
}

	

  
