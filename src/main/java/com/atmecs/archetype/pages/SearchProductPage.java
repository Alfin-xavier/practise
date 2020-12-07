package com.atmecs.archetype.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchProductPage 
{
	WebDriver driver;
	
	public SearchProductPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enterText(String xpath, String value)
	{
		WebElement searchBox = driver.findElement(By.xpath(xpath));
		searchBox.sendKeys(value);
		searchBox.sendKeys(Keys.ENTER);
	}
}
