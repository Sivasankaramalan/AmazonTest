package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class Amazon_ProductPage_OR extends desiredCapabilities{

	
	@FindBy(xpath ="//android.view.ViewGroup[@index='0']")
	public static WebElement RandomResult;
	
	@FindBy(xpath ="//*[@resource-id='title_feature_div']")
	public static WebElement Name;
	
	@FindBy(id =  "com.amazon.mShop.android.shopping:id/loc_ux_gps_auto_detect")
	public static WebElement UseMyCurrentLocarion;
	
	@FindBy(id =  "com.android.packageinstaller:id/permission_allow_button")
	public static WebElement AllowPermission;
	
	@FindBy(xpath ="//*[@resource-id='atfRedesign_priceblock_priceToPay']")
	public static WebElement Price;

	@FindBy(id ="com.amazon.mShop.android.shopping:id/glow_subnav_label")
	public static WebElement Inches;
	
	@FindBy(xpath ="//*[@resource-id='title_feature_div']")
	public static WebElement ProdcutName;
	
	@FindBy(xpath ="//android.view.View[@text='FREE Delivery']")
	public static WebElement ProdcutDetails;
	
	@FindBy(xpath ="//android.view.View[@text='From the manufacturer']")
	public static WebElement FromTheManufacturer;
	
	@FindBy(xpath ="//*[@resource-id='add-to-cart-button']")
	public static WebElement AddToCart;
	
	@FindBy(id ="com.amazon.mShop.android.shopping:id/atc-success")
	public static WebElement AddedToCart;
}
