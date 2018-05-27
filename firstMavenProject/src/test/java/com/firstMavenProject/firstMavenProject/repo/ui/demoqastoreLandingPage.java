package com.firstMavenProject.firstMavenProject.repo.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.firstMavenProject.firstMavenProject.utils.DropDownHandlers;

public class demoqastoreLandingPage {
	WebDriver driver;
	public demoqastoreLandingPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void waitForLandingPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));
	}
	public WebElement gethomePageLink()
	{
		return driver.findElement(By.xpath(".//*[@id='menu-item-15']/a"));
	}
	public WebElement getAccessoriesLink()
	{
		WebElement productCategoryLink = driver.findElement(By.xpath(".//*[@id='menu-item-33']/a"));
		Actions act = new Actions (driver);
		act.moveToElement(productCategoryLink).perform();
		return driver.findElement(By.xpath(".//*[@id='menu-item-34']/a"));
	}
	
	
	
}
