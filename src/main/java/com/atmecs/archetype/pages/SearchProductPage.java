package com.atmecs.archetype.pages;

import java.util.concurrent.TimeUnit;

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
	
	public void clickIcon(String xpath)
	{
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xpath)).click();
	
	}
}
