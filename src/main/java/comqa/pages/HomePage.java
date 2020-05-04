package comqa.pages;

import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.basetest.BaseTest;
import com.qa.utils.JavaScriptUtil;
import com.qa.utils.TimeUtils;
public class HomePage extends BaseTest {
	
	
	public WebDriver driver;
	NewLaunchPage newlaunchpage;
	BundlesPage bundlespage;
	KurtisPage kurtispage;
	SalwarPage salwarpage;
	TimeUtils ts = new TimeUtils();
	JavaScriptUtil js;
	String cw;
	
	@FindBy(xpath="//div[@class='item item-left hide-below-960']/p")
	WebElement welMsg;
	
	@FindBy(xpath="//nav[@id='mainmenu']/ul/li/a/span[text()='New Launch']")
	WebElement newLaunch;
	
	@FindBy(xpath="//nav[@id='mainmenu']/ul/li/a/span[text()='Bundles']")
	WebElement bundles;
	
	
	@FindBy(xpath="//nav[@id='mainmenu']/ul/li/a/span[text()='Kurtis & Tops']")
	WebElement kurtisHomePage;
	
	@FindBy(xpath="//nav[@id='mainmenu']/ul/li/a/span[text()='Salwar Suits']")
	WebElement salwarSuit;
	
	@FindBy(xpath="//nav[@id='mainmenu']/ul/li/a/span[text()='Sarees']")
	WebElement sarees;
	
	@FindBy(xpath="//nav[@id='mainmenu']/ul/li/a/span[text()='Gowns']")
	WebElement gowns;
	

	By first = By.xpath("//div[@class='popover-body-message']");
	By firstBtn = By.xpath("//div[@class='popover-footer']/button[@id='onesignal-popover-cancel-button']");
	String fstr="75+ branded bundles launching on daily basis, click on ALLOW to see them !", ffstr;
	
	By second = By.xpath("//div[@id='at-cv-lightbox-message']/span");
	By secondBtn =By.xpath("//div[@id='at-cv-lightbox-button-holder']/a[@class='at-cv-button at-cv-lightbox-yesno at-cm-no-button']");
	String sstr="Login and Browse to use our coupon codes";
	
	By third = By.xpath("//div[@class='sendpulse-prompt-title sendpulse-prompt-message-text']");
	By thirdbtn =By.xpath("//div[@class='sendpulse-prompt-buttons']/button[@class='sendpulse-prompt-btn sendpulse-disallow-btn']");
	String tstr="Need launch alerts for your shop?";
	
	By navigationMenu = By.xpath("//nav[@id='mainmenu']/ul/li/a");
	int	i=1;
	boolean b ;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		js= new JavaScriptUtil(driver);
	}


	

	public String checkWelcomeMessage()
	{
		System.out.println(1);
		ts.LongWait();
	
		Set  pw  = driver.getWindowHandles();
		
			while(i<=3) {
				ts.MediumWait();
				 if (!pw.isEmpty())
				 {
					 Iterator<String> itr1 = pw.iterator();
					  while(itr1.hasNext())
					  { 
						  cw=itr1.next();
						  System.out.println("inside the loop " + i );
						  clickOnPopupWindow1(driver,cw);
								 
//						  System.out.println(driver.switchTo().window(cw).getTitle());
//						  if(i==1) {   clickOnPopupWindow( driver,  cw,  first, firstBtn, i) ;   }
//						  if(i==2) { clickOnPopupWindow( driver,  cw,  second, secondBtn, i) ;  }
//						  if(i==3) { clickOnPopupWindow( driver,  cw,  third, thirdbtn, i) ; }
//						  	
					  }
				
				 ts.MediumWait();
				pw = driver.getWindowHandles();
				i=i+1;
				 System.out.println("After loop " + i);
			}
				 
			}
			
			String str = welMsg.getText();
			 System.out.println("complete" + str);
		return str;

	}
	
	
	public void clickOnPopupWindow(WebDriver driver, String cw, By loc1, By loc2, int i) {
		  
//		if(i==1) {
//			  if(fstr.equalsIgnoreCase(driver.switchTo().window(cw).findElement(loc1).getText())) {
//				  System.out.println(driver.switchTo().window(cw).findElement(loc1).getText());	 
//				  js.flash(driver.switchTo().window(cw).findElement(loc2));	
//			  	  driver.switchTo().window(cw).findElement(loc2).click();}
//		  		  }
//		
//		
//			  if(i==2)
//			  {
//			  if(sstr.equalsIgnoreCase(driver.switchTo().window(cw).findElement(loc1).getText()))
//			  {
//				  System.out.println(driver.switchTo().window(cw).findElement(loc1).getText());	
//				  js.flash(driver.switchTo().window(cw).findElement(loc2));
//				  driver.switchTo().window(cw).findElement(loc2).click();
//			  } 
//			  }
//			  
//			  
//			  if(i==3) {
//			  if(tstr.equalsIgnoreCase(driver.switchTo().window(cw).findElement(loc1).getText()))
//			  {
//				  System.out.println(driver.switchTo().window(cw).findElement(loc1).getText());	
//				  js.flash(driver.switchTo().window(cw).findElement(loc2));
//				  driver.switchTo().window(cw).findElement(loc2).click();
//			  }
//			  }
			  
			  
			  if(fstr.equalsIgnoreCase(driver.switchTo().window(cw).findElement(first).getText())) {
				  System.out.println(driver.switchTo().window(cw).findElement(first).getText());	 
				  js.flash(driver.switchTo().window(cw).findElement(firstBtn));	
			  	  driver.switchTo().window(cw).findElement(firstBtn).click();
		  		  }
			 
			  if(sstr.equalsIgnoreCase(driver.switchTo().window(cw).findElement(second).getText()))
			  {
				  System.out.println(driver.switchTo().window(cw).findElement(second).getText());	
				  js.flash(driver.switchTo().window(cw).findElement(secondBtn));
				  driver.switchTo().window(cw).findElement(secondBtn).click();
			  }
				 
			 
			  if(tstr.equalsIgnoreCase(driver.switchTo().window(cw).findElement(third).getText()))
			  {
				  System.out.println(driver.switchTo().window(cw).findElement(third).getText());	
				  js.flash(driver.switchTo().window(cw).findElement(thirdbtn));
				  driver.switchTo().window(cw).findElement(thirdbtn).click();
			  
			  }
			  
	}	  
		
	
	
	public String checkWelcomeMessage1()
	{
		ts.shortWait();
		Set  pw  = driver.getWindowHandles();
		Iterator<String> itr = pw.iterator();
					  while(itr.hasNext())
					  { 
						  cw=itr.next();
						  System.out.println("inside the loop " + i );
						  clickOnPopupWindow1(driver,cw);
					  }
				
		String str = welMsg.getText();
		 System.out.println("complete" + str);
		return str;

	}
	public void clickOnPopupWindow1(WebDriver driver, String cw) {
		  
	  
			  if(fstr.equalsIgnoreCase(driver.switchTo().window(cw).findElement(first).getText())) {
				  System.out.println(driver.switchTo().window(cw).findElement(first).getText());	 
				  js.flash(driver.switchTo().window(cw).findElement(firstBtn));	
			  	  driver.switchTo().window(cw).findElement(firstBtn).click();
		  		  }
			 
			  if(sstr.equalsIgnoreCase(driver.switchTo().window(cw).findElement(second).getText()))
			  {
				  System.out.println(driver.switchTo().window(cw).findElement(second).getText());	
				  js.flash(driver.switchTo().window(cw).findElement(secondBtn));
				  driver.switchTo().window(cw).findElement(secondBtn).click();
			  }
				 
			 
			  if(tstr.equalsIgnoreCase(driver.switchTo().window(cw).findElement(third).getText()))
			  {
				  System.out.println(driver.switchTo().window(cw).findElement(third).getText());	
				  js.flash(driver.switchTo().window(cw).findElement(thirdbtn));
				  driver.switchTo().window(cw).findElement(thirdbtn).click();
			  
			  }
			  
	}	  
		
			  

	
	
	public NewLaunchPage clickNewLaunch()
	{
		js.flash(newLaunch);
		newLaunch.click();
		return new NewLaunchPage(driver);
		
	}
	
	public BundlesPage clickBundles()
	{
		js.flash(bundles);
		bundles.click();
		return new BundlesPage(driver);
		
	}
	
	public KurtisPage clickKurtis()
	{
		js.flash(kurtisHomePage);
		kurtisHomePage.click();
		return new KurtisPage(driver);
		
	}
	
	public SalwarPage clickSalwarSuit()
	{
		js.flash(salwarSuit);
		salwarSuit.click();
		return new SalwarPage(driver);
		
	}
	
	
	
}
