package com.atmecs.archetype.testscript;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.atmecs.archetype.constant.FilePathConstants;
import com.atmecs.archetype.pages.BasePage;
import com.atmecs.archetype.pages.SearchProductPage;
import com.atmecs.archetype.utils.PropertyReader;

public class SearchProductTest extends BasePage
{
	
	SearchProductPage searchProduct = new SearchProductPage(driver);
	
	Properties locatorProps = PropertyReader.readProperties(FilePathConstants.LOCATOR_FILE_PATH);
	
	@Test
	public void searchProduct()
	{
		WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));
		searchBox.sendKeys("tops");
		searchBox.sendKeys(Keys.ENTER);
	}
	
}
