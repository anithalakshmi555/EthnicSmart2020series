package com.qa.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.qa.utils.OptionsManager;

public class BaseTest
{
	public WebDriver driver;
	Properties prop;
	OptionsManager optionManager;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	public Properties init_properties()
	{
		 prop = new Properties();
		 try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Miss Jaydevappa\\eclipse-workspace\\HubSpot\\HubSpot\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;	 
	}
	
	public WebDriver initialization(Properties prop)
	{
		
		 String browser = prop.getProperty("browser");
		 optionManager =new OptionsManager(prop);
		 if(browser.equalsIgnoreCase("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\Miss Jaydevappa\\SeleniumStandaloneJarFiles\\chromedriver_win32\\chromedriver.exe");
			// driver= new ChromeDriver(optionManager.getChromeOptions());
			 tlDriver.set( new ChromeDriver(optionManager.getChromeOptions()));
			 getDriver().manage().window().maximize();
			 System.out.println(prop.getProperty("url"));
			 getDriver().get(prop.getProperty("url"));
			 getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 System.out.println(getDriver().getTitle());
		 }
		 else if(browser.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.gecko.driver","C:\\Users\\Miss Jaydevappa\\eclipse-workspace\\Selenium_EbaySearchTest\\target\\classes\\drivers\\chromedriver.exe" );
			// driver= new FirefoxDriver(optionManager.getFirefoxOptions());
			 tlDriver.set( new FirefoxDriver(optionManager.getChromeOptions()));
			 getDriver().manage().window().maximize();
			 getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 System.out.println(getDriver().getTitle());
		 }
		 else if (browser.equalsIgnoreCase("safari")) {
			 System.setProperty("webdriver.safari.driver","C:\\Users\\Miss Jaydevappa\\eclipse-workspace\\Selenium_EbaySearchTest\\target\\classes\\drivers\\chromedriver.exe" );
			// driver= new SafariDriver();
			// driver= new FirefoxDriver(optionManager.getFirefoxOptions());
			 tlDriver.set(new SafariDriver());
			 getDriver().manage().window().maximize();
			 getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 System.out.println(getDriver().getTitle());
		 }
		 return getDriver();
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/ScreenShots/"+ System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	

}


