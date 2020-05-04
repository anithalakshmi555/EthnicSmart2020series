package comqa.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.basetest.BaseTest;
//import com.qa.pages.ethnicSmartHomePage;
import com.qa.utils.TimeUtils;
public class LoginPage extends BaseTest {
	
	
	WebDriver driver;
	HomePage homePage;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement password;
	
	
	@FindBy(css="input.checkbox[name='persistent_remember_me']")
	WebElement checkBox;
	
	@FindBy(xpath="//button[@id='send2']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Log In']")
	WebElement LoginLnk;
	

	@FindBy(xpath="//h1/a[@title='EthnicSmart.com']")
	WebElement logoName;
	
	
	String usr="anithalakshmij@gmail.com",ps="Nisarga@123";
	TimeUtils ts = new TimeUtils();
	
	
	

	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle()
	{		
			String str2 = driver.getTitle();
			return str2;
	}	
	
	public boolean checkLogo()
	{

		return(logoName.isDisplayed());
		
	}
	
	public HomePage clickLoginBtn(String un,String ps)
	{
		//driver.switchTo().alert().accept();
		LoginLnk.click();
		email.sendKeys(un);
		password.sendKeys(ps);
		ts.LongWait();
		ts.LongWait();
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		loginBtn.click();
		return new HomePage(driver);
		
	}
	
	/*
	 * public ethnicSmartHomePage loginToEthnicSmart() { email.sendKeys(usr);
	 * password.sendKeys(ps); if (!checkBox.isSelected()) checkBox.click();
	 * loginBtn.click(); return homePage; }
	 */

}
