package comqa.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.utils.ElementUtil;
import com.qa.utils.ExcelUtil;
import com.qa.utils.JavaScriptUtil;

public class CheckoutPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil js;
	ProductDescPage productdescpage;
	CartPage cartpage;
	ExcelUtil excel ;
	Object[][] data;
	@FindBy(xpath="//h1")
	WebElement header;
	
	@FindBy(xpath="//div[@class='input-box']/input[@id='billing:firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//div[@class='input-box']/input[@id='billing:lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//div[@class='input-box']/input[@id='billing:company']")
	WebElement company;

	
	@FindBy(xpath="//div[@class='input-box']/input[@id='billing:street1']")
	WebElement street1;
	
	@FindBy(xpath="//div[@class='input-box']/input[@id='billing:street2']")
	WebElement street2;
	
	@FindBy(xpath="//div[@class='input-box']/input[@id='billing:vat_id']")
	WebElement gstNumber;
	
	@FindBy(xpath="//div[@class='input-box']/input[@id='billing:city']")
	WebElement city;
	
	@FindBy(xpath="//div[@class='input-box']/input[@id='billing:region']")
	WebElement state;
	
	
	@FindBy(xpath="//div[@class='input-box']/input[@id='billing:postcode']")
	WebElement postalcode;
	
	
	@FindBy(xpath="//div[@class='input-box']/select[@id='billing:country_id']")
	WebElement country;
	
	@FindBy(xpath="//div[@class='input-box']/input[@id='billing:telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//li/input[@id='billing:use_for_shipping_yes']")
	WebElement shipToThisAddressRadiobtn;
	
	@FindBy(xpath="//div[@id='billing-buttons-container']/button/span")
	WebElement billingContinueBtn;
	
	@FindBy(xpath="//div[@id='checkout-step-discountcode']/div/button")
	WebElement discountContinueBtn;
	

	@FindBy(xpath="//div[@id='shipping-method-buttons-container']/button/span")
	WebElement shippingContinueBtn;
	

	@FindBy(xpath="//div[@id='payment-buttons-container']/button/span")
	WebElement paymentContinueBtn;
	
	

	@FindBy(xpath="//input[@id='p_method_banktransfer' and @type='radio']")
	WebElement bookNowPayLater;
	
	
	
	@FindBy(xpath="//li[@id='opc-payment']/div/h2/parent::div//following-sibling::div/form/fieldset/dl/dt[3]/input[@id='p_method_phoenix_cashondelivery']")
	WebElement cashOnDelivery;
	
	

	@FindBy(xpath="//table[@id='checkout-review-table']/tbody/tr/td/h3")
	WebElement productNameInChkOutPage;
	
	

	@FindBy(xpath="//table[@id='checkout-review-table']/tbody/tr/td[2]/span[2]/span")
	WebElement priceOnChkoutPage;
	

	@FindBy(xpath="//table[@id='checkout-review-table']/tbody/tr/td[3]")
	WebElement qtyOnCheckOutPage;
	
	
	@FindBy(xpath="//table[@id='checkout-review-table']/tbody/tr/td[4]/span[2]/span")
	WebElement subTotalinCheckOutPage;
	
	@FindBy(xpath="//table[@id='checkout-review-table']/tfoot/tr[2]/td[2]/span")
	WebElement shippingChargesInChkoutPage;
	
	@FindBy(xpath="//table[@id='checkout-review-table']/tfoot/tr[4]/td[2]/span")
	WebElement gstChargesInCheckoutPage;
	
	@FindBy(xpath="//table[@id='checkout-review-table']/tfoot/tr[5]/td[2]/span")
	WebElement cashOnDelChargesInCheckoutPage;
	
	
	@FindBy(xpath="//table[@id='checkout-review-table']/tfoot/tr[6]/td[2]/strong/span")
	WebElement grandTotalInChekoutPage;
	

	@FindBy(xpath="//button[@class='button btn-checkout']")
	WebElement placeOrderBtn;
	
	
	
	public CheckoutPage(WebDriver driver) {
		this.driver= driver;
		elementUtil= new ElementUtil(driver);
		js= new JavaScriptUtil(driver);
		excel=new ExcelUtil(driver);
		PageFactory.initElements(driver, this);
		
		
	}
	
	public String getProductNameInChkOutPage()
	{
		return productNameInChkOutPage.getText();
	}
	public String getPriceOnChkoutPage()
	{
		return priceOnChkoutPage.getText();
	}
	public String getQtyOnCheckOutPage()
	{
		return qtyOnCheckOutPage.getText();
	}
	public String getSubTotalinCheckOutPage()
	{
		return subTotalinCheckOutPage.getText();
	}
	public String getShippingChargesInChkoutPage()
	{
		return shippingChargesInChkoutPage.getText();
	}
	
	public String getGstChargesInCheckoutPage()
	{
		return gstChargesInCheckoutPage.getText();
	}
	
	public void fillBillingDtls(String fn, String ln, String com,String str1, String str2, String cty,String ste,String post, String ph)
	{
		
		
	
		firstName.clear();
		//firstName.sendKeys("Manjula");
		firstName.sendKeys(fn);
		lastName.clear();
		//lastName.sendKeys("swamy");
		lastName.sendKeys(ln);
		company.clear();
		//company.sendKeys("tumkur");
		company.sendKeys(com);
		street1.clear();
		//street1.sendKeys("169");
		street1.sendKeys(str1);
		street2.clear();
		//street2.sendKeys("14th B cross");
		street2.sendKeys(str2);
		city.clear();
		//city.sendKeys("Bangalore");
		city.sendKeys(cty);
		state.clear();
		//state.sendKeys("karnataka");
		state.sendKeys(ste);
		postalcode.clear();
		//postalcode.sendKeys("560068");
		postalcode.sendKeys(post);
		Select sel = new Select(country);
		sel.selectByVisibleText("India");
		
		telephone.clear();
	//	telephone.sendKeys("9901700885");
		telephone.sendKeys(ph);
		
	//	shipToThisAddressRadiobtn.clear();
	//	shipToThisAddressRadiobtn.click();
	
		billingContinueBtn.click();
		discountContinueBtn.click();
		shippingContinueBtn.click();
		bookNowPayLater.click();
		paymentContinueBtn.click();
		//placeOrderBtn.click();
		//driver.switchTo().alert().accept();
	}

	
	
	
}
