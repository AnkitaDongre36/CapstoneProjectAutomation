package com.HRM;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class loginandlogout {
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index=1;
	WebDriver driver;
	
  @Test(dataProvider = "getLoginData")
  public void login(String sn, String up)  {
	  
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys(sn);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(up);
		Screenshotutility.getScreenshot(driver, "images");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Invalid Credentials");
		System.out.print("login successfully /n");
  }
		
		  
 @AfterMethod
 
	  public void logout()
	  {
		  cell = sheet.getRow(index).getCell(2);
		  if(driver.getCurrentUrl().contains("dashboard"))
		  {
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
				driver.findElement(By.partialLinkText("Log")).click();
				System.out.println("logout successfully");
				
		  
			
		  }
		  else
		  {
			  System.out.println("invalid credential");
			 
		  
		  }
		  index++;
		
	  }
  


  @DataProvider
	public Object[][] getLoginData() {
		
		int rows = sheet.getPhysicalNumberOfRows();
		String[][]loginData = new String[rows-1][2];
		
		for(int i = 0; i < rows-1; i++)
		{
			row = sheet.getRow(i+1);
			for(int j = 0; j < 2; j++)
			{
				cell = row.getCell(j);
				loginData[i][j] = cell.getStringCellValue();
			
		
				}
			
		}
		
		  
	
	
		return loginData;
	
	}
  @BeforeTest
 
	  public void beforeTest() throws IOException {
	  file=new File("Excel sheet//HRMdata.xlsx");
		  fis=new FileInputStream(file);
		  wb= new XSSFWorkbook(fis);
		  sheet=wb.getSheet("data");
		  fos = new FileOutputStream(file);
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  }
  

  @AfterTest
  
	  public void afterTest() throws IOException {
		  wb.write(fos);
		 wb.close();
		  fis.close();
			  driver.close();
		  }
	  
  }


