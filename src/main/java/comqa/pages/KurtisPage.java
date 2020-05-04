package comqa.pages;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.ElementUtil;
import com.qa.utils.JavaScriptUtil;
import com.qa.utils.TimeUtils;

import com.qa.basetest.BaseTest;

public class KurtisPage extends BaseTest {
	
WebDriver driver;
TimeUtils ts = new TimeUtils();
ElementUtil elementUtil;
KurtisPage kurtisPage;
JavaScriptUtil  js ;
ProductListPage  productlistpage;


	@FindBy(xpath="//h1[text()='Kurtis & Tops']")
	WebElement kurtis;
	
	
	By navigationMenu = By.xpath("//nav[@id='mainmenu']/ul/li/a");
	
	@FindBy(xpath="//nav[@id='mainmenu']/ul/li/a/span[text()='Kurtis & Tops']")
	WebElement kurtisTopLink;
	
	@FindBy(xpath="//nav[@id='mainmenu']/ul/li/a/span[text()='Kurtis & Tops']//following-sibling::span")
	WebElement KurtisLinkcaretSymbol;
	
	@FindBy(xpath="//nav[@id='mainmenu']/ul/li/a/span[text()='Kurtis & Tops']//following-sibling::span//parent::a//following-sibling::ul//child::li/a/span[text()='Choose By Size']")
	WebElement KuthisChooseBySize;
	
	@FindBy(xpath="//nav[@id='mainmenu']/ul/li/a/span[text()='Kurtis & Tops']//following-sibling::span//parent::a//following-sibling::ul//child::li/a/span[text()='Choose By Size']//parent::a//following-sibling::ul/li/a/span[text()='5XL']")
	WebElement KuthisChooseBySize5XL;
	
		
	@FindBy(xpath="(//div[@class='advanced-search-summary']/ul/li)[position()=1]")
	WebElement desc;
	
	@FindBy(xpath="(//div[@class='advanced-search-summary']/ul/li)[position()=2]")
	WebElement stock;
	
	@FindBy(xpath="(//div[@class='advanced-search-summary']/ul/li)[position()=3]")
	WebElement name;
	
	
	
	
	
	public KurtisPage(WebDriver driver) {
		this.driver= driver;
		elementUtil= new ElementUtil(driver);
		js= new JavaScriptUtil(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String header() {
		return kurtis.getText();
	}
	
	
	public String kurtiName() {
		System.out.println(name.getText());
		return desc.getText();
	}
	
	public String kurtiDesc() {
		System.out.println(desc.getText());
		return stock.getText();
	}
	
	public String kurtiStockAvailabality() {
		System.out.println(name.getText());
		return name.getText();
	}
	
	
	public ProductListPage chooseBySize(WebDriver driver) {
				driver.switchTo().defaultContent();
				
				Actions act = new Actions(driver);
				act.moveToElement(kurtisTopLink).build().perform();
				ts.MediumWait();
				act.moveToElement(KurtisLinkcaretSymbol).build().perform();
				KuthisChooseBySize.click();
				KuthisChooseBySize5XL.click();
				return new ProductListPage(driver);
				
	}	

	

	

public static void doMouseHover(WebDriver driver, By bylocator)
{
	Actions act = new Actions(driver);
	WebElement ele = driver.findElement(bylocator);
	act.moveToElement(ele).build().perform();
}
	


	

}
