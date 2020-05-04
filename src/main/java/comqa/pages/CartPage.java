package comqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.ElementUtil;
import com.qa.utils.JavaScriptUtil;
import com.qa.utils.TimeUtils;
public class CartPage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil js;
	ProductDescPage productdescpage;
	CartPage cartpage;
	TimeUtils ts;
	@FindBy(xpath="//h1")
	WebElement header;
	
	@FindBy(xpath="//table[@id='shopping-cart-table']/tbody/tr/td[2]")
	WebElement productDesc;
	
	@FindBy(xpath="//table[@id='shopping-cart-table']/tbody/tr/td[3]")
	WebElement editItem;
	
	@FindBy(xpath="//table[@id='shopping-cart-table']/tbody/tr/td[4]")
	WebElement moveToWishList;

	
	@FindBy(xpath="//table[@id='shopping-cart-table']/tbody/tr/td[5]")
	WebElement costOfSingleItem;
	
	@FindBy(xpath="//table[@id='shopping-cart-table']/tbody/tr/td[6]")
	WebElement qtySelected;
	
	@FindBy(xpath="//table[@id='shopping-cart-table']/tbody/tr/td[7]")
	WebElement totalcost;
	
	@FindBy(xpath="//table[@id='shopping-cart-table']/tbody/tr/td[8]")
	WebElement delbtn;
	
	@FindBy(xpath="//div[@id='mini-cart']/a/span/span/following-sibling::span[@class='count']")
	WebElement qtyIncart;
	
	
	@FindBy(xpath="//button[@id='product-addtocart-button']")
	WebElement addToCart;
	
	
	@FindBy(xpath="//table[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span")
	WebElement subTotalinCartPage;
	
	@FindBy(xpath="//table[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")
	WebElement shippingChargesInCartPage;
	
	@FindBy(xpath="//table[@id='shopping-cart-totals-table']/tbody/tr[4]/td[2]/span")
	WebElement gstChargesIncartPage;
	
	@FindBy(xpath="//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")
	WebElement grandTotalInCartPage;
	

	@FindBy(xpath="//button[@title='Proceed to Checkout' and @class='button btn-proceed-checkout btn-checkout']/span/span")
	WebElement proceedTochkOutBtn;
	
	@FindBy(xpath="//table[@id='shopping-cart-table']/tbody/tr[1]/td[6]/input[@name='cart[482974][qty]']")
	WebElement setQtyToOne;
	
	@FindBy(xpath="//button[@name='update_cart_action']/span/span")
	WebElement updateCarPagebtn;
	
	
	
	public CartPage(WebDriver driver) {
		this.driver= driver;
		elementUtil= new ElementUtil(driver);
		js= new JavaScriptUtil(driver);
		ts= new TimeUtils();
		PageFactory.initElements(driver, this);
	}
	
	
	public String getSubTotalinCartPage()
	{
		setQtyToOne.clear();
		setQtyToOne.sendKeys("1");
		updateCarPagebtn.click();
		ts.shortWait();
	return subTotalinCartPage.getText();
	}
	
	public String getShippingChargesInCartPage()
	{
	return shippingChargesInCartPage.getText();
	}
	
	
	public String getGstChargesIncartPage()
	{
	return gstChargesIncartPage.getText();
	}
	
	
	public String getGrandTotalInCartPage()
	{
	return grandTotalInCartPage.getText();
	}
	
	

	public String getQtySelected()
	{
		return qtySelected.getText();
	}
	


	public String getQtyIncart()
	{
		return qtyIncart.getText();
	}
	
	public CheckoutPage clickProceedbtn()
	{
		setQtyToOne.clear();
		setQtyToOne.sendKeys("1");
		updateCarPagebtn.click();
		ts.shortWait();
		proceedTochkOutBtn.click();
		return new CheckoutPage(driver);
	}
	
	
	
	
}
