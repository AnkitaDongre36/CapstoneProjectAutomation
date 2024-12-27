package com.DemoTestcase;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Demopages.HomePage;
import com.Demopages.IndexPage;
@Listeners(com.Demoutility.ExtentITestNGListeners.class)
public class Indexcases {
	public WebDriver driver;
	IndexPage ip;
  @Test(priority=1)
  public void verifygetcategory()
  {
	  ip.getcategory();
  }
  @Test(priority=2)
  public void verifyalloption()
  {
	  ip.getalloption();
	  ScreenUtility.getScreenshot(driver,"Option");
  }
  @Test(priority=3)
  public void verifyUrl()
  {
	 String acturl= ip.getAppUrlin();
	 System.out.println("current url is:"+acturl);
  }
  @Test(priority=4)
  public void verifyselect() {
	  ip.selectphone();
	 
  }
  @Test(priority=5)
  public void verifyadd()
  {
	ip.addoption();

	}
  @Test(priority=6)
  public void verifylink()
  {
	  ip.cart();
	  
  }
  
  
  @BeforeTest
 public void launch()
  
  {
	  driver=new ChromeDriver() ;
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ip=new IndexPage(driver);
	  
  }
}
