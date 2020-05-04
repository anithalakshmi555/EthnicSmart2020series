package comqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.utils.ElementUtil;
import com.qa.utils.JavaScriptUtil;

public class ProductDescPage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil js;
	ProductDescPage productdescpage;
	CartPage cartpage;
	@FindBy(xpath="//h1[@itemprop='name']")
	WebElement imgDesc;
	
	@FindBy(xpath="//select[@id='select_131040']")
	WebElement size;
	
	@FindBy(xpath="//input[@id='qty']")
	WebElement qty;
	
	@FindBy(xpath="//button[@id='product-addtocart-button']")
	WebElement addToCart;
	
	
	String qtyTobeAdded="1";
	
	
	
	@FindBy(xpath="//a[@title='Sign up for price alert']/following-sibling::div//div[@class='price-box']/span/following-sibling::span/span/following-sibling::span")
	WebElement priceOfProduct;
	
	public ProductDescPage(WebDriver driver) {
		this.driver= driver;
		elementUtil= new ElementUtil(driver);
		js= new JavaScriptUtil(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectSize()
	{
		Select sel = new Select(size);
		sel.selectByVisibleText("5XL");
	}
	
	
	public CartPage addItem()
	{
		addToCart.click();
		return new CartPage(driver);
	}
	
	public String addQty()
	{
		qty.clear();
		qty.sendKeys(qtyTobeAdded);
		return qtyTobeAdded;
	}
	
}
