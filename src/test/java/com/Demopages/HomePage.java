package com.Demopages;

import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoTestcase.ScreenUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"navbarExample\"]/ul/li/a")List<WebElement>menu;
	@FindBy(id="signin2")WebElement sign;
	@FindBy(id="sign-username")WebElement usern;
	@FindBy(id="sign-password")WebElement pws;
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")WebElement signup;
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")WebElement close;
	@FindBy(id="login2")WebElement login;
	@FindBy(id="loginusername")WebElement userlog;
	@FindBy(id="loginpassword")WebElement pwslog;
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")WebElement logbtn;
	
	
	public int gettotalOption()
	{
		return menu.size();
	}
	public void nameoptionmenu()
	{
		for(WebElement i: menu)
		{
			System.out.println("option:"+i.getText());
		}
	}
	public String getAppUrl()
	{
		return driver.getCurrentUrl();
	}
	public void signlink()
	{
		sign.click();
		 ScreenUtility.getScreenshot(driver, "link");
		 
	}
	public void putsign(String nm,String ps)
	{
		usern.sendKeys(nm);
		pws.sendKeys(ps);
		signup.click();
		try
		{
		Thread.sleep(1500);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		
		Alert alt;
		alt=driver.switchTo().alert();
		System.out.println("Alert is:"+alt.getText());
		alt.accept();
		close.click();
		ScreenUtility.getScreenshot(driver, "link3");
	}
	public void log(String nm,String ps)
	{
		login.click();
		userlog.sendKeys(nm);
		pwslog.sendKeys(ps);
		logbtn.click();
		
		ScreenUtility.getScreenshot(driver, "link4");
	}
	
	
	
}
