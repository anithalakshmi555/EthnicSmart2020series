package comqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunchPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//h1[text()='New Launch']")
	WebElement newLaunchHeader;
	

	
	NewLaunchPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public String header() {
		return newLaunchHeader.getText();
	}
	
	
	
}
