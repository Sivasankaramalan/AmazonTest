package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class Amazon_SearchResultPage_OR extends desiredCapabilities{

	
	@FindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	public static WebElement HomeSearch;
	
	@FindBy(xpath ="//*/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
	public static WebElement SearchDropDown;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Results')]")
	public static WebElement ResultsCount;
}
