package Driver.stepDefs;

/**
 * 
 *	Author : Sivasankaramalan G
 */
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.Amazon_CartPage_OR;
import ObjectRepository.Amazon_HamburgerMenu_OR;
import ObjectRepository.Amazon_HomePage_OR;
import ObjectRepository.Amazon_LoginPage_OR;
import ObjectRepository.Amazon_OR;
import ObjectRepository.Amazon_ProductPage_OR;
import ObjectRepository.Amazon_SearchResultPage_OR;
import PageObjects.CommonMethodsFunctions;
import Utility.Log;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonStepDefinitions extends desiredCapabilities{

	
	PropertyData data = new PropertyData();
	CommonMethodsFunctions CF = new CommonMethodsFunctions();
	
	public static String ProductName = null;
	
	/**
	 * Launching the APP under test - First step of Test Cases Execution
	 * @throws Throwable
	 */
	@Given("Launch the Amazon app$")
	public void launch_the_Amazon_app() throws Throwable {

		Log.info("Launching the Application based on the Capabilities from the Driver file");
		System.out.println("Platform Name here is: " + driver.getCapabilities().getCapability("platformName"));
		

	}
	/**
	 * Action - Click 
	 * @param Button
	 * @throws Throwable
	 */
	
	@When("^User clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_button(String Button) throws Throwable {
		
		if(Button.equals("Start shopping")) {
			try {
				Log.info("Waiting for the Element" + Amazon_HomePage_OR.SkipSignIn);
				wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.SkipSignIn));
				Log.info("Click the Element " + Amazon_HomePage_OR.SkipSignIn);
				Amazon_HomePage_OR.SkipSignIn.click();
				Log.info("Waiting for the Element" + Amazon_HomePage_OR.HamburgerMenu);
				wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.HamburgerMenu));
			}
			catch(Exception E) {
				Log.info("Expected Element is not Presnet");
				System.out.println("Skip Sign in not Displayed Hence moving to HomePage");
			}

		}
		else if (Button.equals("hamburger")) {
		Log.info("Waiting for the Element" + Amazon_HomePage_OR.HamburgerMenu.toString());
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.HamburgerMenu));
		Log.info("Click the Element " + Amazon_HomePage_OR.HamburgerMenu.toString());
		Amazon_HomePage_OR.HamburgerMenu.click();
		Log.info("Waiting for the Element" + Amazon_HamburgerMenu_OR.HelloSignIn.toString());
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HamburgerMenu_OR.HelloSignIn));
		
		}
		else if (Button.equals("Amazon")) {
		Log.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		Log.info("Click the Element " + Amazon_HomePage_OR.AmazonLogo);
		Amazon_HomePage_OR.AmazonLogo.click();
		Log.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
			
		}
		else if (Button.equals("Proceed to Buy")) {
		Log.info("Waiting for the Element" + Amazon_CartPage_OR.ProceedToBuy);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.ProceedToBuy));
		Log.info("Click the Element " + Amazon_CartPage_OR.ProceedToBuy);
		Amazon_CartPage_OR.ProceedToBuy.click();
		try {
			Log.info("Waiting for the Element" + Amazon_CartPage_OR.AddMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.AddMobileNumber));
			System.out.println("Enter your Mobile Number to procced  Order");
		}
		catch(Exception E) {
			Log.info("Expected Element is not Presnet");
			System.out.println("Enter Address to procced your Order");
		}
			
		}
	}
	/**
	 * Assertion for Home Page
	 * @param Page
	 */
	
	@And("^Verify \"([^\"]*)\" is displayed$")
	public void verify_page_is_displayed(String Page) {
		
		if(Page.equals("Home page")) {
		Log.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		Log.info("Verify the presence of the " + Amazon_HomePage_OR.AmazonLogo + "in current Page");
		Assert.assertTrue(Amazon_HomePage_OR.AmazonLogo.isDisplayed());
	
		}
	}
	
	/**
	 * Login to the Amazon App
	 * @throws InterruptedException
	 */
	@And("^Login to amazon app$")
	public void login_to_amazon_app() throws InterruptedException {
		
		Log.info("Waiting for the Element" + Amazon_HamburgerMenu_OR.HelloSignIn);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HamburgerMenu_OR.HelloSignIn));
		
		Log.info("Get the Current Orientation of the Device");
		ScreenOrientation CurrentScreen = driver.getOrientation();
		System.out.println("The Oreintation of Current Page is : "+ CurrentScreen );
		
		Log.info("Rotate the Current Orientation to LANDSCAPE" );
		driver.rotate(ScreenOrientation.LANDSCAPE);
		Log.info("Rotate the Current Orientation to PORTRAIT" );
		driver.rotate(ScreenOrientation.PORTRAIT);	
		Log.info("Click the Element " + Amazon_HamburgerMenu_OR.HelloSignIn);
		Amazon_HamburgerMenu_OR.HelloSignIn.click();
		Log.info("Waiting for the Element" + Amazon_HamburgerMenu_OR.MobileNumberOrEmail);
		wait.until(ExpectedConditions.visibilityOf(Amazon_HamburgerMenu_OR.MobileNumberOrEmail));
		Log.info("Click the Element " + Amazon_HamburgerMenu_OR.MobileNumberOrEmail);
		Amazon_HamburgerMenu_OR.MobileNumberOrEmail.click();
		Log.info("Clear the text Field before entering any value");
		Amazon_HamburgerMenu_OR.MobileNumberOrEmail.clear();
		Log.info("Enter the text " + data.email + "to the text Field");
		Amazon_HamburgerMenu_OR.MobileNumberOrEmail.sendKeys(data.email);
		Log.info("Waiting for the Element" + Amazon_HamburgerMenu_OR.Continue);
		wait.until(ExpectedConditions.visibilityOf(Amazon_HamburgerMenu_OR.Continue));
		Log.info("Click the Element " + Amazon_HamburgerMenu_OR.Continue);
		Amazon_HamburgerMenu_OR.Continue.click();
		Log.info("Waiting for the Element" + Amazon_LoginPage_OR.Password);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_LoginPage_OR.Password));
		Log.info("Click the Element " + Amazon_LoginPage_OR.Password);
		Amazon_LoginPage_OR.Password.click();
		Log.info("Enter the text " + data.password + "to the text Field");
		Amazon_LoginPage_OR.Password.sendKeys(data.password);
		Log.info("Waiting for the Element" + Amazon_LoginPage_OR.Login);
		wait.until(ExpectedConditions.visibilityOf(Amazon_LoginPage_OR.Login));
		Log.info("Click the Element " + Amazon_LoginPage_OR.Login);
		Amazon_LoginPage_OR.Login.click();
		Log.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.visibilityOf(Amazon_HomePage_OR.AmazonLogo));
	}
	/**
	 * Assertion for Available Text
	 * @param Text
	 */
	
	@And("^Validate text \"([^\"]*)\" is displayed$")
	public void validate_text_displayed(String Text) {
		if(Text.endsWith("Amazon Logo")) {
		Log.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		Log.info("Verify the presence of the " + Amazon_HomePage_OR.AmazonLogo + "in current Page");
		Assert.assertTrue(Amazon_HomePage_OR.AmazonLogo.isDisplayed());
		
		}
	}
	
	/**
	 * Assertion for Available Menu	
	 * @param Options
	 */
	@And("^Validate \"([^\"]*)\" is displayed$")
	public void validate_options_menu(String Options) {
		if(Options.equals("Search Bar")) {
		Log.info("Waiting for the Element" + Amazon_SearchResultPage_OR.HomeSearch);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.HomeSearch));
		Log.info("Verify the presence of the " + Amazon_SearchResultPage_OR.HomeSearch + "in current Page");
		Assert.assertTrue(Amazon_SearchResultPage_OR.HomeSearch.isDisplayed());
		}
		else if (Options.equals("65-inch TV")) {
		Log.info("Waiting for the Element" + Amazon_SearchResultPage_OR.ResultsCount);	
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.ResultsCount));
		Log.info("Verify the presence of the " + Amazon_SearchResultPage_OR.ResultsCount + "in current Page");
		Assert.assertTrue(Amazon_SearchResultPage_OR.ResultsCount.isDisplayed());
		}
	}
	/**
	 * Verification of Suggestions Page
	 */
	@SuppressWarnings("static-access")
	@And("^Verify the Suggestion on the Home Page$")
	public void verify_the_suggestion_page() {
		Log.info("Swipe the Current Card with the Given Co-Ordinates");
		CF.swipeHorizontal(driver);
	}
	
	@And("^Choose the current location$")
	public void choose_the_current_location() {
		
		Log.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		Log.info("Click the Element " + Amazon_HomePage_OR.AmazonLogo);
		Amazon_HomePage_OR.AmazonLogo.click();
		Log.info("Waiting for the Element" + Amazon_HomePage_OR.Devliver);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.Devliver));
		Log.info("Click the Element " + Amazon_HomePage_OR.Devliver);
		Amazon_HomePage_OR.Devliver.click();
		Log.info("Waiting for the Element" + Amazon_HomePage_OR.useCurrentLocation);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.useCurrentLocation));
		Log.info("Click the Element " + Amazon_HomePage_OR.useCurrentLocation);
		Amazon_HomePage_OR.useCurrentLocation.click();
		Log.info("Waiting for the Element" + Amazon_ProductPage_OR.AllowPermission);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.AllowPermission));
		Log.info("Click the Element " + Amazon_ProductPage_OR.AllowPermission);
		Amazon_ProductPage_OR.AllowPermission.click();
	}
	
	/**
	 * Searching for the Product Based on the User Input
	 * @param Product
	 */
	@And("^Search for the product \"([^\"]*)\"$")
	public void search_for_product(String Product) {
		if(Product.equals("65-inch TV")) {
		Log.info("Waiting for the Element" + Amazon_ProductPage_OR.AllowPermission);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.HomeSearch));
		Log.info("Verify the presence of the " + Amazon_SearchResultPage_OR.HomeSearch + "in current Page");
		Assert.assertTrue(Amazon_SearchResultPage_OR.HomeSearch.isDisplayed());
		Log.info("Click the Element " + Amazon_SearchResultPage_OR.HomeSearch);
		Amazon_SearchResultPage_OR.HomeSearch.click();
			try {
				Log.info("Click the Element " + Amazon_CartPage_OR.ClearSearch);
				Amazon_CartPage_OR.ClearSearch.click();

			}
			catch(Exception E) {
				Log.info("Expected scenarios is not Presnet");
				System.out.println("Searching for the First Time");
			}
	
		Log.info("Enter the text " + data.Product + " to the text Field");
		Amazon_SearchResultPage_OR.HomeSearch.sendKeys(data.Product);
		Log.info("Waiting for the Element" + Amazon_SearchResultPage_OR.SearchDropDown);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.SearchDropDown));
		Log.info("Click the Element " + Amazon_SearchResultPage_OR.SearchDropDown);
		Amazon_SearchResultPage_OR.SearchDropDown.click();
		Log.info("Waiting for the Element" + Amazon_SearchResultPage_OR.ResultsCount);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.ResultsCount));
		
		}
	}
	/**
	 * Selecting the Product from the List
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	@And("^User selects the product from the list$")
	public void user_selects_the_list() throws MalformedURLException, InterruptedException {
		
		/**
		 * Scrolling to validate the list of Products
		 */
		Log.info("Scrolling to the Requested Element by Text");
		CF.scrollToText(data.Brand, driver);
		
		Log.info("Waiting for the Element" + Amazon_ProductPage_OR.RandomResult);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.RandomResult));
		Log.info("Verify the presence of the " + Amazon_ProductPage_OR.RandomResult + "in current Page");
		Assert.assertTrue(Amazon_ProductPage_OR.RandomResult.isDisplayed());
		Log.info("Waiting for the Element" + Amazon_ProductPage_OR.Inches);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.Inches));
		Log.info("Verify the presence of the " + Amazon_ProductPage_OR.Inches + "in current Page");
		Assert.assertTrue(Amazon_ProductPage_OR.Inches.isDisplayed());		
	}
	
	@And("^Verify product details are displayed$")
	public void verify_product_details() {

		Log.info("Waiting for the Element" + Amazon_ProductPage_OR.ProdcutName);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.ProdcutName));
		Log.info("Get the Details of ChoosenProduct");
		ProductName = Amazon_ProductPage_OR.ProdcutName.getText();
		System.out.println("The Selected Product is : " + ProductName);
		Log.info("Verify the Choosen Product is same as TV or not");
		Assert.assertTrue("The suggestions are not having expected Product", ProductName.contains(data.tv));
	}
	
	@And("^User chooses the product$")
	public void user_chooses_product() {
		Log.info("Waiting for the Element" + Amazon_ProductPage_OR.RandomResult);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.RandomResult));
		Log.info("Click the Element " + Amazon_ProductPage_OR.RandomResult);
		Amazon_ProductPage_OR.RandomResult.click();
		Log.info("Waiting for the Element" + Amazon_ProductPage_OR.Name);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.Name));
	}
	
	@And("^User Verifies the details of the selected Product$")
	public void user_verifies_the_details() throws MalformedURLException, InterruptedException {
		
		Log.info("Get the Name of ChoosenProduct");
		String ProductDetailsPage = Amazon_ProductPage_OR.ProdcutName.getText();
		Log.info("Verify the Choosen Product is same as TV or not");
		Assert.assertEquals(ProductDetailsPage, ProductName);
		System.out.println("The Name of the Choosen Prodcut is :"+ProductDetailsPage);
		Log.info("Get the Price of ChoosenProduct");
		String ProductPrice = Amazon_ProductPage_OR.Price.getText();
		System.out.println("The Price of the Choosen Prodcut is: "+ProductPrice);
		
//		CF.scrollToText("From the manufacturer", driver);
//		Assert.assertTrue(Amazon_OR.FromTheManufacturer.isDisplayed());
		
	}
	@And("^User Add's the product to the Cart$")
	public void user_adds_the_product_to_cart() throws MalformedURLException, InterruptedException {
		Log.info("Add the Procut to Cart by Scrolling to Add Cart Section");
		Thread.sleep(4000);
		CF.scrollToText("Add to Cart", driver);
//		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.AddToCart));
//		Amazon_ProductPage_OR.AddToCart.click();
		Log.info("Waiting for the Element" + Amazon_ProductPage_OR.AddedToCart);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.AddedToCart));
		Log.info("Verify the presence of the " + Amazon_ProductPage_OR.AddedToCart + "in current Page");
		Assert.assertTrue(Amazon_ProductPage_OR.AddedToCart.isDisplayed());
	}
	
	@And("^Navigate to the Cart menu$")
	public void navigate_to_the_cart_menu() {
		Log.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		Log.info("Click the Element " + Amazon_HomePage_OR.AmazonLogo);
		Amazon_HomePage_OR.AmazonLogo.click();
		Log.info("Waiting for the Element" + Amazon_CartPage_OR.CartMenu);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.CartMenu));
		Log.info("Click the Element " + Amazon_CartPage_OR.CartMenu);
		Amazon_CartPage_OR.CartMenu.click();
		Log.info("Waiting for the Element" + Amazon_CartPage_OR.ProceedToBuy);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.ProceedToBuy));
	}
	
	@And("^Verify the Product in Cart$")
	public void verify_Cart() {
		Log.info("Waiting for the Element" + Amazon_CartPage_OR.SubTotal);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.SubTotal));
		String ProductCartPage = Amazon_ProductPage_OR.ProdcutName.getText();
		Log.info("Verify the Expected Element is displayd on Current Page");
		Assert.assertTrue(Amazon_ProductPage_OR.ProdcutName.isDisplayed());
		Log.info("Verify the Product is TV or not");
		Assert.assertTrue("The product is not present in the Cart", ProductCartPage.contains(data.tv));
	}
	
	/**
	 * Final Step on Test Case Execution : Terminating the App from the User Session
	 * @throws Throwable
	 */
	@Then("^User closes the app$")
	public void user_closes_the_app() throws Throwable {
		Log.warn("Closing the App");
		driver.closeApp();
		
	}
}
	
