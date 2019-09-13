package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class Amazon_ProductPage_OR extends desiredCapabilities{

	
	@FindBy(xpath ="//android.view.ViewGroup[@index='0']")
	public static WebElement RandomResult;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'TV')]")
	public static WebElement Name;
	
	@FindBy(id ="com.amazon.mShop.android.shopping:id/loc_ux_gps_auto_detect")
	public static WebElement UseMyCurrentLocarion;
	
	@FindBy(id ="com.android.packageinstaller:id/permission_allow_button")
	public static WebElement AllowPermission;
	
	@FindBy(xpath ="//android.widget.EditText[contains(@text,'rupees')]")
	public static WebElement Price;

	@FindBy(xpath ="//android.view.View[contains(@text,'Inches')]")
	public static WebElement Inches;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'TV')]")
	public static WebElement ProdcutName;
	
	@FindBy(xpath ="//*/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[13]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View")
	public static WebElement ProdcutDetails;
	
	@FindBy(xpath ="//android.view.View[@text='From the manufacturer']")
	public static WebElement FromTheManufacturer;
	
	@FindBy(xpath ="//android.widget.Button[@text='Add to Cart']")
	public static WebElement AddToCart;
	
	@FindBy(id ="atc-success")
	public static WebElement AddedToCart;
}
