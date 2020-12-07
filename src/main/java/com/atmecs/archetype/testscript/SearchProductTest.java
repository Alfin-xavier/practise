package com.atmecs.archetype.testscript;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.archetype.constant.FilePathConstants;
import com.atmecs.archetype.pages.BasePage;
import com.atmecs.archetype.pages.SearchProductPage;
import com.atmecs.archetype.utils.PropertyReader;

public class SearchProductTest extends BasePage
{
	WebDriver driver;
	
	SearchProductPage searchProduct = new SearchProductPage(driver);
	
	Properties locaterProps = PropertyReader.readProperties(FilePathConstants.LOCATOR_FILE_PATH);
	
	@BeforeMethod
	public void initBrowser() throws MalformedURLException
	{
		String gridUrl = "localhost:4444";
		Capabilities cabs = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL(gridUrl), cabs);
	}
	
	@Test
	public void searchProduct()
	{
		searchProduct.clickIcon(locaterProps.getProperty("clickIcon"));
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
