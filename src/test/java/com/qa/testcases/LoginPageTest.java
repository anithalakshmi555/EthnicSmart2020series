package com.qa.testcases;



import org.testng.annotations.Test;



import com.qa.basetest.BaseTest;

import comqa.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import com.qa.utils.Constants;

@Epic("This epic is for teh login test")
@Story("USD 105 : This is for login test")
public class LoginPageTest extends BaseTest {
	Properties prop;
	WebDriver driver;
	BaseTest baseTest  = new BaseTest();
	LoginPage loginPage;
	Constants constant;
	
	String tit="Wholesale kurtis | Salwar dress materials | Sarees for starting own clothing shop #StartYourBoutique";
	
	@Description("Epic 101 : Design login feature")
	@Severity(SeverityLevel.NORMAL)	
  @Test(priority=1)
  public void getTitle() {
	  String str1 = loginPage.getTitle();
	  Assert.assertEquals(str1, constant.LOGIN_PAGE_TITLE);
  }
  
  
	@Description("Epic 101 : check logo")
	@Severity(SeverityLevel.NORMAL)	
  @Test(priority=2)
  public void checkLogo() {
	  
	  Assert.assertTrue(loginPage.checkLogo());
	
  }
  
	@Description("Epic 101 : login")
	@Severity(SeverityLevel.CRITICAL)	
	@Step("Details of user name :{0} and password is {1}")
  @Test(priority=3)
  public void login() {
	
	 // driver.switchTo().alert().accept();
	  loginPage.clickLoginBtn(prop.getProperty("username"),prop.getProperty("pwd"));
	 
	
	
  }
  
  
  
  @BeforeTest
  public void beforeTest() {
	 prop= baseTest.init_properties();
	 driver=baseTest.initialization(prop);
	 loginPage = new LoginPage(driver);
  }

  @AfterTest
  public void afterTest() {
	 driver.quit();
  }

}
