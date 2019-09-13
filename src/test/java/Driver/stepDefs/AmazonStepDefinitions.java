package Driver.stepDefs;

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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonStepDefinitions extends desiredCapabilities{

	
	PropertyData data = new PropertyData();
	CommonMethodsFunctions CF = new CommonMethodsFunctions();
	
	public static String ProductName = null;
	
	@Given("Launch the Amazon app$")
	public void launch_the_Amazon_app() throws Throwable {

		System.out.println("Platform Name here is: " + driver.getCapabilities().getCapability("platformName"));
		
	}
	
	@When("^User clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_button(String Button) throws Throwable {
		
		if(Button.equals("Start shopping")) {
			try {
				
				wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.SkipSignIn));
				Amazon_HomePage_OR.SkipSignIn.click();
				wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.HamburgerMenu));
			}
			catch(Exception E) {
				System.out.println("Skip Sign in not Displayed Hence moving to HomePage");
			}

		}
		else if (Button.equals("hamburger")) {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.HamburgerMenu));
		Amazon_HomePage_OR.HamburgerMenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HamburgerMenu_OR.HelloSignIn));
		
		}
		else if (Button.equals("Amazon")) {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		Amazon_HomePage_OR.AmazonLogo.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
			
		}
		else if (Button.equals("Proceed to Buy")) {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.ProceedToBuy));
		Amazon_CartPage_OR.ProceedToBuy.click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.AddMobileNumber));
			System.out.println("Enter your Mobile Number to procced  Order");
		}
		catch(Exception E) {
			System.out.println("Enter Address to procced your Order");

		}
			
		}
	}
	
	@And("^Verify \"([^\"]*)\" is displayed$")
	public void verify_page_is_displayed(String Page) {
		
		if(Page.equals("Home page")) {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		Assert.assertTrue(Amazon_HomePage_OR.AmazonLogo.isDisplayed());
	
		}
	}
	
	@And("^Login to amazon app$")
	public void login_to_amazon_app() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HamburgerMenu_OR.HelloSignIn));
		
		ScreenOrientation CurrentScreen = driver.getOrientation();
		System.out.println("The Oreintation of Current Page is : "+ CurrentScreen );
		
		driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.rotate(ScreenOrientation.PORTRAIT);		
		Amazon_HamburgerMenu_OR.HelloSignIn.click();
		wait.until(ExpectedConditions.visibilityOf(Amazon_HamburgerMenu_OR.MobileNumberOrEmail));
		Amazon_HamburgerMenu_OR.MobileNumberOrEmail.click();
		Amazon_HamburgerMenu_OR.MobileNumberOrEmail.clear();
		Amazon_HamburgerMenu_OR.MobileNumberOrEmail.sendKeys(data.email);
		wait.until(ExpectedConditions.visibilityOf(Amazon_HamburgerMenu_OR.Continue));
		Amazon_HamburgerMenu_OR.Continue.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_LoginPage_OR.Password));
		Amazon_LoginPage_OR.Password.click();
		Amazon_LoginPage_OR.Password.sendKeys(data.password);
		wait.until(ExpectedConditions.visibilityOf(Amazon_LoginPage_OR.Login));
		Amazon_LoginPage_OR.Login.click();
		wait.until(ExpectedConditions.visibilityOf(Amazon_HomePage_OR.AmazonLogo));
		
		

	}
	@And("^Validate text \"([^\"]*)\" is displayed$")
	public void validate_text_displayed(String Text) {
		if(Text.endsWith("Amazon Logo")) {
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		Assert.assertTrue(Amazon_HomePage_OR.AmazonLogo.isDisplayed());
		
		}
	}
		
	@And("^Validate \"([^\"]*)\" is displayed$")
	public void validate_options_menu(String Options) {
		if(Options.equals("Search Bar")) {
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.HomeSearch));
		Assert.assertTrue(Amazon_SearchResultPage_OR.HomeSearch.isDisplayed());
		}
		else if (Options.equals("65-inch TV")) {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.ResultsCount));
		Assert.assertTrue(Amazon_SearchResultPage_OR.ResultsCount.isDisplayed());
		}
		
	}
	@SuppressWarnings("static-access")
	@And("^Verify the Suggestion on the Home Page$")
	public void verify_the_suggestion_page() {
		CF.swipeHorizontal(driver);
	}
	@And("^Choose the current location$")
	public void choose_the_current_location() {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		Amazon_HomePage_OR.AmazonLogo.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.Devliver));
		Amazon_HomePage_OR.Devliver.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.useCurrentLocation));
		Amazon_HomePage_OR.useCurrentLocation.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.AllowPermission));
		Amazon_ProductPage_OR.AllowPermission.click();
	}
	
	@And("^Search for the product \"([^\"]*)\"$")
	public void search_for_product(String Product) {
		if(Product.equals("65-inch TV")) {
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.HomeSearch));
		Assert.assertTrue(Amazon_SearchResultPage_OR.HomeSearch.isDisplayed());
		Amazon_SearchResultPage_OR.HomeSearch.click();
			try {
				Amazon_CartPage_OR.ClearSearch.click();

			}
			catch(Exception E) {
				System.out.println("Searching for the First Time");
			}
	
		Amazon_SearchResultPage_OR.HomeSearch.sendKeys(data.Product);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.SearchDropDown));
		Amazon_SearchResultPage_OR.SearchDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.ResultsCount));
		
		}
	}
	@And("^User selects the product from the list$")
	public void user_selects_the_list() throws MalformedURLException, InterruptedException {
		
		/**
		 * Scrolling to validate the list of Products
		 */
		
		CF.scrollToText(data.Brand, driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.RandomResult));
		Assert.assertTrue(Amazon_ProductPage_OR.RandomResult.isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.Inches));
		Assert.assertTrue(Amazon_ProductPage_OR.Inches.isDisplayed());		
		
	}
	@And("^Verify product details are displayed$")
	public void verify_product_details() {
		
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Amazon_ProductPage_OR.UseMyCurrentLocarion.click();
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.AllowPermission));
			Amazon_ProductPage_OR.AllowPermission.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			ProductName = Amazon_ProductPage_OR.ProdcutName.getText();
			System.out.println("The Selected Product is : " + ProductName);
			
			Assert.assertTrue("The suggestions are not having expected Product", ProductName.contains(data.tv));
			}
		catch(Exception E) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			ProductName = Amazon_ProductPage_OR.ProdcutName.getText();
			System.out.println("The Selected Product is :" + ProductName);
			Assert.assertTrue("The suggestions are not having expected Product", ProductName.contains(data.tv));
		}
		
		
	}
	@And("^User chooses the product$")
	public void user_chooses_product() {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.RandomResult));
		Amazon_ProductPage_OR.RandomResult.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.Name));
		

	}
	@And("^User Verifies the details of the selected Product$")
	public void user_verifies_the_details() throws MalformedURLException, InterruptedException {
		
		String ProductDetailsPage = Amazon_ProductPage_OR.ProdcutName.getText();
		Assert.assertEquals(ProductDetailsPage, ProductName);
		System.out.println("The Name of the Choosen Prodcut is :"+ProductDetailsPage);
		
		String ProductPrice = Amazon_ProductPage_OR.Price.getText();
		System.out.println("The Price of the Choosen Prodcut is: "+ProductPrice);
		
//		CF.scrollToText("From the manufacturer", driver);
//		Assert.assertTrue(Amazon_OR.FromTheManufacturer.isDisplayed());
	}
	@And("^User Add's the product to the Cart$")
	public void user_adds_the_product_to_cart() throws MalformedURLException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		CF.scrollToText("Add to Cart", driver);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.AddToCart));
		Amazon_ProductPage_OR.AddToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.AddedToCart));
		Assert.assertTrue(Amazon_ProductPage_OR.AddedToCart.isDisplayed());
	}
	@And("^Navigate to the Cart menu$")
	public void navigate_to_the_cart_menu() {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.CartMenu));
		Amazon_CartPage_OR.CartMenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.ProceedToBuy));
		
	}
	@And("^Verify the Product in Cart$")
	public void verify_Cart() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.SubTotal));
		String ProductCartPage = Amazon_ProductPage_OR.ProdcutName.getText();
		Assert.assertTrue(Amazon_ProductPage_OR.ProdcutName.isDisplayed());
		Assert.assertTrue("The product is not present in the Cart", ProductCartPage.contains(data.tv));
	}
	
	@Then("^User closes the app$")
	public void user_closes_the_app() throws Throwable {

		driver.closeApp();
		
	}
	}
	
