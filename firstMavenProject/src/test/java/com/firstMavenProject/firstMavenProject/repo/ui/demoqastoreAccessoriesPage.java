package com.firstMavenProject.firstMavenProject.repo.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demoqastoreAccessoriesPage {
	
	WebDriver driver;
	public demoqastoreAccessoriesPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void waitForAccessoriesPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='post-105']")));
	}
	
	public WebElement getMagicMouseProductLink()
	{
		return driver.findElement(By.xpath(".//*[@id='default_products_page_container']/div[3]/div[2]/h2/a"));
	}
	public WebElement getMagicMouseAddToCartLink()
	{
		return driver.findElement(By.xpath("//div[h2[a[text()='Magic Mouse']]]/form/div/div/span/input[@name='Buy']"));
	}
	public WebElement getcheckoutLink()
	{
		return driver.findElement(By.xpath("//a[@title='Checkout']"));
	}
	/*public String getAddToCartConfirmationMessage()
	{
		WebElement hiddenconfirmationMessage = driver.findElement(By.xpath("//div[h2[a[text()='Magic Mouse']]]/form/div/div/div/\r\n" + 
				"p[text()='Item has been added to your cart!']"));
		String confirmationMessage = hiddenconfirmationMessage.getAttribute('p');
		return confirmationMessage;
	}*/
}
