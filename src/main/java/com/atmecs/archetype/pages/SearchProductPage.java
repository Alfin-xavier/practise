package com.atmecs.archetype.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProductPage 
{
	WebDriver driver;
	
	public SearchProductPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enterText(String xpath, String value)
	{
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	
	public void clickSearchButton(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
	}
}
