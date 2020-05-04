package comqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.ElementUtil;
import com.qa.utils.JavaScriptUtil;

public class ProductListPage {
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil js;
	ProductDescPage productdescpage;
	
	@FindBy(xpath="(//div[@class='advanced-search-summary']/ul/li)[position()=1]")
	WebElement name;
	
	@FindBy(xpath="(//div[@class='advanced-search-summary']/ul/li)[position()=2]")
	WebElement desc;
	
	@FindBy(xpath="(//div[@class='advanced-search-summary']/ul/li)[position()=3]")
	WebElement stock;
	
	
	@FindBy(xpath="//ul[@class='products-grid category-products-grid itemgrid itemgrid-adaptive itemgrid-2col single-line-name centered hover-effect equal-height']/li//a/img[@alt='Bundle of 04 Wholesale Kurti - Catalog Jhon Vol 26']")
	WebElement Bundleof04WholesaleKurtiCatalog_Jhon_Vol_26;
	
	@FindBy(xpath="//ul[@class='products-grid category-products-grid itemgrid itemgrid-adaptive itemgrid-2col single-line-name centered hover-effect equal-height']/li//a/img[@alt='Bundle of 06 wholesale Kurti - Catalog Jhon Vol 23']")
	WebElement Bundleof06wholesaleKurtiCatalogJhon_Vol_23;
	
	public ProductListPage(WebDriver driver) {
		this.driver= driver;
		elementUtil= new ElementUtil(driver);
		js= new JavaScriptUtil(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String kurtiName() {
		System.out.println(name.getText());
		return name.getText();
	}
	
	public String kurtiDesc() {
		System.out.println(desc.getText());
		return desc.getText();
	}
	
	public String kurtiStockAvailabality() {
		System.out.println(stock.getText());
		return stock.getText();
	}
	

	public ProductDescPage clickImage() {
		Bundleof04WholesaleKurtiCatalog_Jhon_Vol_26.click();
		return new ProductDescPage(driver);
	}
	
}
