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
	
	@FindBy(xpath = "//*/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.app.Dialog/android.view.View[2]")
	public static WebElement ClearButton;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Deliver')]")
	public static WebElement Devliver;
	
	@FindBy(id = "com.amazon.mShop.android.shopping:id/loc_ux_update_current_pin_code")
	public static WebElement useCurrentLocation;
	
	@FindBy(xpath = "//*[@text='Sign in for the best experience']")
	public static WebElement SigninForBestExperience;
	
	@FindBy(xpath = "//*/android.view.View[2]/android.view.View[3]/android.view.View[4]/android.view.View[6]/android.view.View")
	public static WebElement MoreMenu;
	
	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View[7]/android.view.View")
	public static WebElement ActionsBar;
	
	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View[8]/android.view.View")
	public static WebElement PayBar;
	
	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View[9]/android.view.View")
	public static WebElement HomeUtilsBar;
	
	//*/android.view.View[1]/android.view.View/android.view.View[10]/android.view.View
	
	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View[10]/android.view.View")
	public static WebElement OffersBar;
}
