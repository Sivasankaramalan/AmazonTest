package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class Amazon_CartPage_OR extends desiredCapabilities{

	@FindBy(id =  "com.amazon.mShop.android.shopping:id/action_bar_cart_image")
	public static WebElement CartMenu;
	
	@FindBy(xpath ="//android.widget.Button[@text='Proceed to Buy']")
	public static WebElement ProceedToBuy;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'Subtotal')]")
	public static WebElement SubTotal;
	
	@FindBy(id ="com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_clear")
	public static WebElement ClearSearch;
	
	@FindBy(xpath ="//android.view.View[@text='Add a mobile phone number']")
	public static WebElement AddMobileNumber;
	
	@FindBy(xpath ="//android.widget.EditText[@index='1']")
	public static WebElement MobileNumberField;
	
	@FindBy(xpath ="//*[@text='Continue']")
	public static WebElement ContinueMoble;
	
	@FindBy(id ="android.view.View[@text='Enter a shipping address']")
	public static WebElement EnterShippingAddress;
	
}
