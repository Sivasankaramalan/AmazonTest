package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class Amazon_HomePage_OR extends desiredCapabilities{

	
	@FindBy(id ="com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	public static WebElement SkipSignIn;
	
	@FindBy(id ="com.amazon.mShop.android.shopping:id/action_bar_home_logo")
	public static WebElement AmazonLogo;
	
	@FindBy(id ="com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
	public static WebElement HamburgerMenu;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Start shopping']")
	public static WebElement startShopping;
	
	@FindBy(id = "com.amazon.mShop.android.shopping:id/rs_clear_text_button_accessibility")
	public static WebElement ClearButton;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Deliver')]")
	public static WebElement Devliver;
	
	@FindBy(id = "com.amazon.mShop.android.shopping:id/loc_ux_update_current_pin_code")
	public static WebElement useCurrentLocation;
	
	@FindBy(xpath = "//*[@text='Sign in for the best experience']")
	public static WebElement SigninForBestExperience;
	
}
