package HRMscenario2;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")WebElement user;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")WebElement pws;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") WebElement btn;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a")List<WebElement> menu;
	@FindBy(xpath="//span[text()='Admin']")WebElement add;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")WebElement user1;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")WebElement btn2;
	@FindBy(xpath="//span[text()='(1) Record Found']")WebElement totalRecord;
	@FindBy(xpath="(//i[contains(@class,' oxd-select-text--arrow')])[1]")WebElement role;
	@FindBy(xpath="//div[@class='oxd-select-option']//span[text()='Admin']")WebElement rolead;
	@FindBy(xpath="//div[contains(@class,'orangehrm-vertical-padding')]//span")WebElement dropRecord;
	
	@FindBy(xpath="(//i[contains(@class,' oxd-select-text--arrow')])[2]")WebElement statusdrop;
	@FindBy(xpath="//div[@class='oxd-select-option']//span[text()='Enabled']")WebElement statusen;
	@FindBy(xpath="//div[contains(@class,'orangehrm-vertical-padding')]//span")WebElement recordin;
	
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un,String ps) {
		user.sendKeys(un);
		pws.sendKeys(ps);
		btn.click();
		}
	public int menucount()
	{
		return menu.size();
	}
	public void option()
	{
	for(WebElement i:menu)
	{
		System.out.println("option are:"+i.getText());
	}
	}
	public void addclick()
	{
		add.click();
	}
	public void verifyadd()
	{
		user1.sendKeys("Admin");
		btn2.click();
		System.out.println("when enter username Admin record found");
	System.out.println("record found:"+totalRecord.getText());
		
		driver.navigate().refresh();
		
		}
	public void dropdown() {
		role.click();
		rolead.click();
		btn2.click();
		System.out.println("when enter userRole Admin record found");
		System.out.println("Record found:" +dropRecord.getText());
		driver.navigate().refresh();
		
	}
	
	public void status() {
	statusdrop.click();
		statusen.click();
		btn2.click();
		System.out.println("when enter Enabled Status then record found");
		System.out.println("total nu of record found:"+recordin.getText());
		
	}

}
