package com.atmecs.archetype.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.archetype.constant.FilePathConstants;
import com.atmecs.archetype.utils.PropertyReader;
import com.atmecs.archetype.utils.TestNGListeners;

public class BasePage 
{
	public static WebDriver driver;
	Properties properties;
	String baseUrl;
	String browserUrl;

	@BeforeMethod
	@Parameters("browser")
	
	public void beforeTest(String browser) throws InterruptedException, IOException 
	{
		properties = PropertyReader.readProperties(FilePathConstants.CONFIG_FILE_PATH);
		baseUrl = properties.getProperty("url");
		browserUrl = properties.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty(FilePathConstants.CHROME_DRIVER, FilePathConstants.CHROME_DRIVER_FILE);
			driver = new ChromeDriver();
			driver.get(baseUrl);
		}
		
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty(FilePathConstants.GECKO_DRIVER, FilePathConstants.GECKO_DRIVER_FILE);
			driver = new FirefoxDriver();
			driver.get(baseUrl);
		}
		
	  System.out.println(driver.getCurrentUrl()); 
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
	  
	  TestNGListeners.driver = driver;
	 
	}
	
	@BeforeTest
	public void initBrowser() throws MalformedURLException 
	{
		String gridUrl = "http://192.168.163.1:4445/wd/hub";
		Capabilities cabs = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL(gridUrl), cabs);
	}
	 
	@AfterMethod
	public void afterTest()
	{
		driver.close();

	}
}
