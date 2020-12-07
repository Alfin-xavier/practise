package com.atmecs.archetype.testscript;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
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
	
	@Test
	public void searchProduct()
	{
		searchProduct.enterText(locaterProps.getProperty("searchBox"), "kurties");
	}
}
