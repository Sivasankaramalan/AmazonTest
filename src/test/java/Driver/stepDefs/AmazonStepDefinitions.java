package Driver.stepDefs;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.Amazon_OR;
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
				
				wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.SkipSignIn));
				Amazon_OR.SkipSignIn.click();
				wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.HamburgerMenu));
			}
			catch(Exception E) {
				System.out.println("Skip Sign in not Displayed Hence moving to HomePage");
			}

		}
		else if (Button.equals("hamburger")) {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.HamburgerMenu));
		Amazon_OR.HamburgerMenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.HelloSignIn));
		
		}
		else if (Button.equals("Amazon")) {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.AmazonLogo));
		Amazon_OR.AmazonLogo.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.AmazonLogo));
			
		}
		else if (Button.equals("Proceed to Buy")) {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.ProceedToBuy));
		Amazon_OR.ProceedToBuy.click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.AddMobileNumber));
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
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.AmazonLogo));
		Assert.assertTrue(Amazon_OR.AmazonLogo.isDisplayed());
	
		}
	}
	
	@And("^Login to amazon app$")
	public void login_to_amazon_app() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.HelloSignIn));
		
		ScreenOrientation CurrentScreen = driver.getOrientation();
		System.out.println("The Oreintation of Current Page is : "+ CurrentScreen );
		
		driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.rotate(ScreenOrientation.PORTRAIT);		
		Amazon_OR.HelloSignIn.click();
		wait.until(ExpectedConditions.visibilityOf(Amazon_OR.MobileNumberOrEmail));
		Amazon_OR.MobileNumberOrEmail.click();
		Amazon_OR.MobileNumberOrEmail.clear();
		Amazon_OR.MobileNumberOrEmail.sendKeys(data.email);
		wait.until(ExpectedConditions.visibilityOf(Amazon_OR.Continue));
		Amazon_OR.Continue.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.Password));
		Amazon_OR.Password.click();
		Amazon_OR.Password.sendKeys(data.password);
		wait.until(ExpectedConditions.visibilityOf(Amazon_OR.Login));
		Amazon_OR.Login.click();
		wait.until(ExpectedConditions.visibilityOf(Amazon_OR.AmazonLogo));
		
		

	}
	@And("^Validate text \"([^\"]*)\" is displayed$")
	public void validate_text_displayed(String Text) {
		if(Text.endsWith("Amazon Logo")) {
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.AmazonLogo));
		Assert.assertTrue(Amazon_OR.AmazonLogo.isDisplayed());
		
		}
	}
		
	@And("^Validate \"([^\"]*)\" is displayed$")
	public void validate_options_menu(String Options) {
		if(Options.equals("Search Bar")) {
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.HomeSearch));
		Assert.assertTrue(Amazon_OR.HomeSearch.isDisplayed());
		}
		else if (Options.equals("65-inch TV")) {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.ResultsCount));
		Assert.assertTrue(Amazon_OR.ResultsCount.isDisplayed());
		}
		
	}
	@SuppressWarnings("static-access")
	@And("^Verify the Suggestion on the Home Page$")
	public void verify_the_suggestion_page() {
		CF.swipeHorizontal(driver);
	}
	@And("^Choose the current location$")
	public void choose_the_current_location() {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.AmazonLogo));
		Amazon_OR.AmazonLogo.click();
		Amazon_OR.Devliver.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.useCurrentLocation));
		Amazon_OR.useCurrentLocation.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.AllowPermission));
		Amazon_OR.AllowPermission.click();
	}
	
	@And("^Search for the product \"([^\"]*)\"$")
	public void search_for_product(String Product) {
		if(Product.equals("65-inch TV")) {
		
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.HomeSearch));
			Assert.assertTrue(Amazon_OR.HomeSearch.isDisplayed());
			Amazon_OR.HomeSearch.click();
			try {
				Amazon_OR.ClearSearch.click();

			}
			catch(Exception E) {
				System.out.println("Searching for the First Time");

			}
			
			Amazon_OR.HomeSearch.sendKeys(data.Product);
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.SearchDropDown));
			Amazon_OR.SearchDropDown.click();
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.ResultsCount));
		
		}
	}
	@And("^User selects the product from the list$")
	public void user_selects_the_list() throws MalformedURLException, InterruptedException {
		
		/**
		 * Scrolling to validate the list of Products
		 */
		
		CF.scrollToText(data.Brand, driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.RandomResult));
		Assert.assertTrue(Amazon_OR.RandomResult.isDisplayed());
		
	}
	@And("^Verify product details are displayed$")
	public void verify_product_details() {
		
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Amazon_OR.UseMyCurrentLocarion.click();
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.AllowPermission));
			Amazon_OR.AllowPermission.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			ProductName = Amazon_OR.ProdcutName.getText();
			System.out.println("The Selected Product is : " + ProductName);
			
			Assert.assertTrue("The suggestions are not having expected Product", ProductName.contains("TV"));
			}
		catch(Exception E) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			ProductName = Amazon_OR.ProdcutName.getText();
			System.out.println("The Selected Product is :" + ProductName);
			Assert.assertTrue("The suggestions are not having expected Product", ProductName.contains("TV"));
		}
		
		
	}
	@And("^User chooses the product$")
	public void user_chooses_product() {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.RandomResult));
		Amazon_OR.RandomResult.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.Name));
		

	}
	@And("^User Verifies the details of the selected Product$")
	public void user_verifies_the_details() throws MalformedURLException, InterruptedException {
		
		String ProductDetailsPage = Amazon_OR.ProdcutName.getText();
		Assert.assertEquals(ProductDetailsPage, ProductName);
		System.out.println("The Name of the Choosen Prodcut is :"+ProductDetailsPage);
		
		String ProductPrice = Amazon_OR.Price.getText();
		System.out.println("The Price of the Choosen Prodcut is: "+ProductPrice);
		
		CF.scrollToText("From the manufacturer", driver);
		
		Assert.assertTrue(Amazon_OR.FromTheManufacturer.isDisplayed());
	}
	@And("^User Add's the product to the Cart$")
	public void user_adds_the_product_to_cart() throws MalformedURLException, InterruptedException {
		
		driver.navigate().back();
		CF.scrollToText(data.Brand, driver);
		Thread.sleep(2000);
		CF.scrollToText("Add to Cart", driver);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.AddToCart));
		Amazon_OR.AddToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.CartMenu));
	}
	@And("^Navigate to the Cart menu$")
	public void navigate_to_the_cart_menu() {
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.AmazonLogo));
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.CartMenu));
		Amazon_OR.CartMenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.ProceedToBuy));
		
	}
	@And("^Verify the Product in Cart$")
	public void verify_Cart() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_OR.SubTotal));
		String ProductCartPage = Amazon_OR.ProdcutName.getText();
		Assert.assertTrue(Amazon_OR.ProdcutName.isDisplayed());
		Assert.assertTrue("The product is not present in the Cart", ProductCartPage.contains("TV"));
	}
	
	@Then("^User closes the app$")
	public void user_closes_the_app() throws Throwable {

		driver.closeApp();
		
	}
	}
	
