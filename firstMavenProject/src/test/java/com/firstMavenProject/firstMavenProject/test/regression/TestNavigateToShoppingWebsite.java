package com.firstMavenProject.firstMavenProject.test.regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.firstMavenProject.firstMavenProject.repo.ui.DemoqastoreTransactionResultsPage;
import com.firstMavenProject.firstMavenProject.repo.ui.demoqastoreAccessoriesPage;
import com.firstMavenProject.firstMavenProject.repo.ui.demoqastoreCheckoutPage;
import com.firstMavenProject.firstMavenProject.repo.ui.demoqastoreDeliveryDetailsPage;
import com.firstMavenProject.firstMavenProject.repo.ui.demoqastoreLandingPage;
import com.firstMavenProject.firstMavenProject.test.config.testConfiguration;
import com.firstMavenProject.firstMavenProject.utils.DataHandlers;

public class TestNavigateToShoppingWebsite {
	
	WebDriver driver;
	demoqastoreLandingPage landing_page;
	demoqastoreAccessoriesPage accessories_page;
	demoqastoreCheckoutPage checkout_page;
	demoqastoreDeliveryDetailsPage delivery_details_page;
	DemoqastoreTransactionResultsPage transactions_results_page;
	
	@BeforeMethod
	public void setUp()
	{
		driver = testConfiguration.createDriverInstance();
		landing_page = new demoqastoreLandingPage (driver);
		accessories_page = new demoqastoreAccessoriesPage (driver);
		checkout_page = new demoqastoreCheckoutPage (driver);
		delivery_details_page = new demoqastoreDeliveryDetailsPage (driver);
		transactions_results_page = new DemoqastoreTransactionResultsPage (driver);
	}
	
	@Test
	public void testBuyMagicMouse() throws InterruptedException
	{
		//Navigate to DemoQA Store - Landing Page
		landing_page.waitForLandingPageToLoad();
		landing_page.getAccessoriesLink().click();
		accessories_page.waitForAccessoriesPageToLoad();
		
		//Add Magic Mouse to Cart
		accessories_page.getMagicMouseAddToCartLink().click();
		Thread.sleep(10000);
		accessories_page.getcheckoutLink().click();
		
		//Verify Product details in Checkout Page	
		checkout_page.waitForCheckoutPageToLoad();
		String actual_productName= checkout_page.getProductNameLabel().getText();
		String expected_productName = "Magic Mouse";
		Assert.assertEquals(actual_productName, expected_productName);
		String actual_productQuantity = checkout_page.getProductQuantityTextBox();
		String expected_productQuantity = "1";
		Assert.assertEquals(actual_productQuantity, expected_productQuantity);
		checkout_page.getContinueButton().click();
		
		//ENTER BILLING AND SHIPPING DETAILS
		delivery_details_page.waitForDeliveryDetailsPageToLoad();
		//delivery_details_page.getEmailAddressTextbox().sendKeys("hannairene89@gmail.com");
		delivery_details_page.getEmailAddressTextbox().sendKeys(DataHandlers.getDataFromExcel("Book1", "Customer Information", 2, 0));
		//sendKeys(DataHandler.getDataFromExcel("TestDataGuru99", "LoginData", 1, 0));
		delivery_details_page.getFirstNameBillingDetailsTextbox().sendKeys("Hanna");
		delivery_details_page.getLastNameBillingDetailsTextbox().sendKeys("Irene Sam");
		delivery_details_page.getAddressBillingDetailsTextarea().sendKeys("7187 Harwick Drive, Mississauga, Ontario L4T3A5");
		delivery_details_page.getCityBillingDetailsTextbox().sendKeys("Mississauga");
		delivery_details_page.getProvinceBillingDetailsTextbox().sendKeys("Ontario");
		delivery_details_page.getCountryBillingDetailsDropdown("Canada");
		delivery_details_page.getPostalCodeBillingDetailsTextbox().sendKeys("L4T 3A5");
		delivery_details_page.getPhoneNumberBillingDetailsTextbox().sendKeys("437-922-5986");
		delivery_details_page.getFirstNameShippingAddressTextbox().sendKeys("Hanna");
		delivery_details_page.getLastNameShippingAddressTextbox().sendKeys("IS");
		delivery_details_page.getAddressShippingAddressTextarea().sendKeys("7187 Harwick Drive, Mississauga, Ontario L4T3A5");
		delivery_details_page.getCityShippingAddressTextbox().sendKeys("Mississauga");
		delivery_details_page.getProvinceShippingAddressTextbox().sendKeys("Ontario");
		delivery_details_page.getCountryShippingAddressDropdown("Canada");
		delivery_details_page.getPostalCodeShippingAddressTextbox().sendKeys("L4T 3A5");
		delivery_details_page.getPurchaseButton().click();
		
		//Confirming order purchase in the Transactions Details Page
		transactions_results_page.waitForTransactionsResultsPageToLoad();
		String actualProductName = transactions_results_page.getPurchasedProductName().getText();
		String expectedProductName = "Magic Mouse";
		Assert.assertEquals(actualProductName, expectedProductName);
		
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
