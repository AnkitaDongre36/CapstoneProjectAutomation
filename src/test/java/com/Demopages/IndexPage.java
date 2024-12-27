package com.Demopages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoTestcase.ScreenUtility;

public class IndexPage {
	WebDriver driver;
	public IndexPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"contcont\"]/div/div[1]/div")List<WebElement>allcategory;
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div/div/div/h4/a")List<WebElement>alloption;
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")WebElement phone;
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div[2]/div/a")WebElement addopt;
	@FindBy(id="cartur")WebElement cartlink;
	@FindBy(xpath="//*[@id=\"page-wrapper\"]/div/div[2]/button")WebElement placebtn;
	@FindBy(id="name")WebElement name;
	@FindBy(id="country")WebElement country;
	@FindBy(id="city")WebElement city;
	@FindBy(id="card")WebElement cardnu;
	@FindBy(id="month")WebElement monthna;
	@FindBy(id="year")WebElement yearnu;
	@FindBy(xpath="//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")WebElement purchsebtn;
	
	
	
	public void getcategory()
	{
		for(WebElement i:allcategory)
		{
			System.out.println("category is:"+i.getText());
		}
	}
	public void getalloption()
	{
		try
		{
			for(WebElement i:allcategory)
			{
				System.out.println("category is:"+i.getText());
				System.out.println("option same");
				for(WebElement j:alloption)
				{
					System.out.println("option are:"+j.getText());
				}
			}
		}catch(StaleElementReferenceException s)
		{
		System.out.println("Page Refresh..");	
		}
	}
	public String getAppUrlin()
	{
		return driver.getCurrentUrl();
	}
	
	public void selectphone() {
		phone.click();
	}
	public void addoption()
	{
		addopt.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alt;
		alt=driver.switchTo().alert();
		System.out.println("alert msg:"+alt.getText());
		alt.accept();
	}
	public void cart()
	{
		cartlink.click();
		ScreenUtility.getScreenshot(driver, "link5");
		placebtn.click();
		ScreenUtility.getScreenshot(driver, "link6");
		name.sendKeys("NamanShrma");
		country.sendKeys("India");
		city.sendKeys("Nagpur");
		cardnu.sendKeys("in23456@sdr");
		monthna.sendKeys("December");
		yearnu.sendKeys("2024");
		ScreenUtility.getScreenshot(driver, "link7");
		
		purchsebtn.click();
		ScreenUtility.getScreenshot(driver, "link8");
		
		
	}
	
	
}

