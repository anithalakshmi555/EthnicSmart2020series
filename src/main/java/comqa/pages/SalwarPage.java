package comqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalwarPage {
	WebDriver driver;
	
	@FindBy(xpath="//h1[text()='Salwar Suits']")
	WebElement salwar;
	
	@FindBy(xpath="	//img[@id='product-collection-image-225100']")
	WebElement salwarSuitcatalogue;
	

	

	
	SalwarPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public String header() {
		return salwar.getText();
	}
	

}
