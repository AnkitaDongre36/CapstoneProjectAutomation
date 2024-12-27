package com.DemoTestcase;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Demopages.HomePage;


@Listeners(com.Demoutility.ExtentITestNGListeners.class)
public class Hometestcase {
	public WebDriver driver;
	HomePage hp;

  @Test(priority=1)
  public void verifygettotalOption() {
	int num=  hp.gettotalOption();
	System.out.println("total is:"+num);
	
	  
  }
  @Test(priority=2)
  public void verifymenu()
  {
	  hp.nameoptionmenu();
	 
  }
  @Test(priority=3)
  public void verifyurl()
  {
	 String actaurl= hp.getAppUrl();
	 System.out.println("Current url is:"+actaurl);
  }
  @Test(priority=4)
  public void verifysign()
  
  {
	 hp.signlink();
	
  }
  @Test(priority=5)
  public void Verifyput()
  {
	  hp.putsign("NamanShrma", "namans12345");
	 
  }
  @Test(priority=6)
  public void login()
  {
	 hp.log("NamanShrma", "namans12345"); 

  }
 
 
  
  @BeforeTest
  public void launch()
  
  {
	  driver=new ChromeDriver() ;
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp=new HomePage(driver);
	  
  }
}
