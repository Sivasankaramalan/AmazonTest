package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class Amazon_OR extends desiredCapabilities{

	
//	@FindBy(id ="com.amazon.mShop.android.shopping:id/skip_sign_in_button")
//	public static WebElement SkipSignIn;
//	
//	@FindBy(id ="com.amazon.mShop.android.shopping:id/action_bar_home_logo")
//	public static WebElement AmazonLogo;
//	
//	@FindBy(id ="com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
//	public static WebElement HamburgerMenu;
	
//	@FindBy(id ="com.amazon.mShop.android.shopping:id/gno_greeting_text_view")
//	public static WebElement HelloSignIn;
	
//	@FindBy(xpath = "//android.widget.TextView[@text='Start shopping']")
//	public static WebElement startShopping;
	
//	@FindBy(xpath = "//*/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.app.Dialog/android.view.View[2]")
//	public static WebElement ClearButton;
	
//	@FindBy(xpath = "//android.widget.EditText[@index='1']")
//	public static WebElement MobileNumberOrEmail;
	
//	@FindBy(xpath = "//android.widget.Button[@text='Continue']")
//	public static WebElement Continue;
	
//	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Deliver')]")
//	public static WebElement Devliver;
	
//	@FindBy(id = "com.amazon.mShop.android.shopping:id/loc_ux_update_current_pin_code")
//	public static WebElement useCurrentLocation;
	
//	@FindBy(xpath = "//*[@text='Sign in for the best experience']")
//	public static WebElement SigninForBestExperience;
	
//	@FindBy(xpath = "//*/android.view.View[2]/android.view.View[3]/android.view.View[4]/android.view.View[6]/android.view.View")
//	public static WebElement MoreMenu;
	
//	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View[7]/android.view.View")
//	public static WebElement ActionsBar;
//	
//	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View[8]/android.view.View")
//	public static WebElement PayBar;
//	
//	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View[9]/android.view.View")
//	public static WebElement HomeUtilsBar;
//	
//	//*/android.view.View[1]/android.view.View/android.view.View[10]/android.view.View
//	
//	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View[10]/android.view.View")
//	public static WebElement OffersBar;
	
	
//	@FindBy(id = "gw-sign-in-button")
//	public static WebElement SignIn;
//	
//	@FindBy(xpath = "//*/android.view.View[1]/android.view.View[8]/android.view.View[2]/android.widget.EditText")
//	public static WebElement Password;
//	
//	@FindBy(xpath = "//android.widget.Button[@text='Login']")
//	public static WebElement Login;
	
//	@FindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
//	public static WebElement HomeSearch;
//	
//	@FindBy(xpath ="//*/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
//	public static WebElement SearchDropDown;
//	
//	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Results')]")
//	public static WebElement ResultsCount;
	
//	android.view.ViewGroup
	
//	@FindBy(xpath ="//android.view.ViewGroup[@index='0']")
//	public static WebElement RandomResult;
//	
//	@FindBy(xpath ="//android.widget.TextView[contains(@text,'TV')]")
//	public static WebElement Name;
//	
//	@FindBy(id ="com.amazon.mShop.android.shopping:id/loc_ux_gps_auto_detect")
//	public static WebElement UseMyCurrentLocarion;
//	
//	@FindBy(id ="com.android.packageinstaller:id/permission_allow_button")
//	public static WebElement AllowPermission;
//	
//	@FindBy(xpath ="//android.widget.EditText[contains(@text,'rupees')]")
//	public static WebElement Price;
//
//	@FindBy(xpath ="//android.widget.TextView[contains(@text,'65 Inches')]")
//	public static WebElement Inches;
//	
//	@FindBy(xpath ="//android.view.View[contains(@text,'TV')]")
//	public static WebElement ProdcutName;
//	
//	@FindBy(xpath ="//*/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[13]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View")
//	public static WebElement ProdcutDetails;
//	
//	@FindBy(xpath ="//android.view.View[@text='From the manufacturer']")
//	public static WebElement FromTheManufacturer;
//	
//	@FindBy(xpath ="//android.widget.Button[@text='Add to Cart']")
//	public static WebElement AddToCart;
//	
//	@FindBy(id ="atc-success")
//	public static WebElement AddedToCart;
	
//	@FindBy(id ="com.amazon.mShop.android.shopping:id/action_bar_cart_image")
//	public static WebElement CartMenu;
//	
//	@FindBy(xpath ="//android.widget.Button[@text='Proceed to Buy']")
//	public static WebElement ProceedToBuy;
//	
//	@FindBy(xpath ="//android.view.View[contains(@text,'Subtotal')]")
//	public static WebElement SubTotal;
//	
//	@FindBy(id ="com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_clear")
//	public static WebElement ClearSearch;
//	
//	@FindBy(xpath ="//android.view.View[@text='Add a mobile phone number']")
//	public static WebElement AddMobileNumber;
//	
//	@FindBy(xpath ="//*/android.view.View[4]/android.view.View[2]/android.widget.EditText")
//	public static WebElement MobileNumberField;
//	
//	@FindBy(xpath ="//*[@text='Continue']")
//	public static WebElement ContinueMoble;
//	
//	@FindBy(id ="android.view.View[@text='Enter a shipping address']")
//	public static WebElement EnterShippingAddress;
//	
//	@FindBy(id ="in.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text")
//	public static WebElement SearchDropDown;
//	
//	@FindBy(id ="in.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text")
//	public static WebElement SearchDropDown;
//	
//	@FindBy(id ="in.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text")
//	public static WebElement SearchDropDown;
//	
//	@FindBy(id ="in.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text")
//	public static WebElement SearchDropDown;
	
	
	
	
	
}
