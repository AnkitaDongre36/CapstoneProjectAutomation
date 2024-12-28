package com.HRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class practice {
	WebDriver driver;


  @Test
  public void f() {
	  driver=new ChromeDriver() ;
		
		driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		  driver.findElement(By.xpath("//span[text()='Admin']")).click();
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Admin");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
	  driver.navigate().refresh();
	  driver.findElement(By.xpath("(//i[contains(@class,' oxd-select-text--arrow')])[1]")).click();
	  driver.findElement(By.xpath("//div[@class='oxd-select-option']//span[text()='Admin']")).click();
	
	driver.navigate().refresh();
	  
	  driver.findElement(By.xpath("(//i[contains(@class,' oxd-select-text--arrow')])[2]")).click();
	  driver.findElement(By.xpath("//div[@class='oxd-select-option']//span[text()='Enabled']")).click();
  }
}
