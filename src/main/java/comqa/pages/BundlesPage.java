package comqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BundlesPage {

WebDriver driver;
	
	@FindBy(xpath="//h1[text()='Bundles']")
	WebElement bundles;
	

	
	BundlesPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public String header() {
		return bundles.getText();
	}
	
}
