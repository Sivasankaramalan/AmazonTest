/**
* 
*/
package Driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.Amazon_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author Siva
 *
 */
//@Parameters({"port","device"})
public class desiredCapabilities {
	public static AppiumDriver<MobileElement> driver;
	public static WebDriverWait wait;
	PropertyData prop = new PropertyData();


	public void SetDesiredCapabilities() throws MalformedURLException, InterruptedException {

		if (prop.platformName.equalsIgnoreCase("Android")) {
			
			
			File app = new File(System.getProperty("user.dir") + "/src/main/java/Amazon_shopping.apk");
//			final File appDir = new File("/Users/sivasankaramalan/Desktop/Healthify/");
//    	    final File app = new File(appDir,"HealthifyMe-basic-release-4.apk");
			
    		final DesiredCapabilities capabilities = new DesiredCapabilities();
    		
    		String ANDROID_DEVICE_SOCKET = "com.amazon.mShop.android.shopping" + "_devtools_remote";            

    		capabilities.setCapability("platformName", "Android");
    		capabilities.setCapability("platformVersion", "9");
    		
    		capabilities.setCapability("deviceName", "OnePlus 5T");
    		capabilities.setCapability("udid", "bd121d35"); 
    		
    		capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
    		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");

    		capabilities.setCapability("automationName", "uiautomator2");
    		capabilities.setCapability("app", app.getAbsolutePath());
    		
    		capabilities.setCapability("instrumentApp", true);
			capabilities.setCapability("fastReset", true);
    		capabilities.setCapability("androidDeviceSocket", ANDROID_DEVICE_SOCKET);
    		
    		
    		driver =  new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    		
    		wait = new WebDriverWait(driver, 20);
    		System.out.println("Initialize: "+driver);
    		
    		PageFactory.initElements(driver, Amazon_OR.class);


		} 
	}

	public AppiumDriver<MobileElement> getAndroidDriver() {
		return driver;
	}

	public WebDriverWait getWebDriverWait() {
		return wait;
	}
}
