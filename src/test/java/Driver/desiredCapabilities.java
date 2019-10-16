/**
* 
*/
package Driver;

import static Utility.SetProperties.appConfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.Amazon_CartPage_OR;
import ObjectRepository.Amazon_HamburgerMenu_OR;
import ObjectRepository.Amazon_HomePage_OR;
import ObjectRepository.Amazon_LoginPage_OR;
import ObjectRepository.Amazon_ProductPage_OR;
import ObjectRepository.Amazon_SearchResultPage_OR;
import Utility.Log;
import Utility.SetProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * @author Sivasankaramalan
 *  
 * Desired Capabilities --> keys and values encoded in a JSON object, It's a way of telling the Appium Server which kind of session we are interested in.
 * Appium clients Sent's the capabilities to server when a new automation session is requested
 * 
 */

public class desiredCapabilities {
	public static AppiumDriver<MobileElement> driver;
	public static WebDriverWait wait;
	PropertyData prop = new PropertyData();	
	SetProperties setProperty = new SetProperties();
	
	
	private static AppiumDriverLocalService server;

	
	/**
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public void SetDesiredCapabilities() throws MalformedURLException, InterruptedException {
		
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/PropertyFiles/Configuration.properties");
		
		/**
		 *  @param : APP Platform
		 */

		if (prop.platformName.equalsIgnoreCase("Android")) {
			
			/**
			 * Start the Appium Service with AppiumDriverLocalService
			 * Check the method in details at the bottom of the Page
			 */
//			startAppiumServer();
			
			final DesiredCapabilities capabilities = new DesiredCapabilities();
			
			/**
			 * For launching the test without Installing the App leave below two lines and (App) capability as Commented 
			 **/
			
//			File app = new File(System.getProperty("user.dir") + "/App/Amazon_shopping.apk");
//			capabilities.setCapability("app", app.getAbsolutePath());

    		Log.info("Set The Desired value for the Test Device in App.Config file");
    		
    		String ANDROID_DEVICE_SOCKET = appConfig.getValue("appPackage") + "_devtools_remote";            

    		capabilities.setCapability("platformName", appConfig.getValue("Platform"));
    		capabilities.setCapability("platformVersion",appConfig.getValue("androidVersion"));
    		
    		capabilities.setCapability("deviceName",appConfig.getValue("deviceName") );
    		capabilities.setCapability("udid", appConfig.getValue("udid")); 
    		capabilities.setCapability("appPackage", appConfig.getValue("appPackage"));
    		capabilities.setCapability("appActivity", appConfig.getValue("appActivity"));

    		capabilities.setCapability("automationName", appConfig.getValue("automationName"));
    		
    		capabilities.setCapability("instrumentApp", true);
			capabilities.setCapability("noReset", false);
    		capabilities.setCapability("androidDeviceSocket", ANDROID_DEVICE_SOCKET);
    		capabilities.setCapability("newCommandTimeout", 150);
    		
//    		 Starting the Appium Desktop on IP :127.0.0.1  and Port : 4723
    		driver =  new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    		
//    		driver =  new AndroidDriver<MobileElement>(server.getUrl(), capabilities);
    		
    		wait = new WebDriverWait(driver, 30);
    		System.out.println("Initialize: "+driver);
    		
    		PageFactory.initElements(driver, Amazon_CartPage_OR.class);
    		PageFactory.initElements(driver, Amazon_ProductPage_OR.class);
    		PageFactory.initElements(driver, Amazon_HamburgerMenu_OR.class);
    		PageFactory.initElements(driver, Amazon_HomePage_OR.class);
    		PageFactory.initElements(driver, Amazon_LoginPage_OR.class);
    		PageFactory.initElements(driver, Amazon_SearchResultPage_OR.class);

		}
		else {
			System.out.println("Expected Platform not specified");
		}
		
	}
	/**
	 * Starting the Appium Server through Code using AppiumServiceBuilder
	 * 
	 */
	public static void startAppiumServer() {
		
		
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		
//         Use any port, in case the default 4723 is already taken (May be by another Appium server)
//         serviceBuilder.usingAnyFreePort();
        
        serviceBuilder.withIPAddress("127.0.0.1");
        serviceBuilder.usingPort(4723);
        
        // Tell serviceBuilder where node is installed. Or set this path in an environment variable named NODE_PATH
        serviceBuilder.usingDriverExecutable(new File("/usr/local/bin/node"));
        
        // Tell serviceBuilder where Appium is installed. Or set this path in an environment variable named APPIUM_PATH
        serviceBuilder.withAppiumJS(new File("/usr/local/bin/appium"));

        HashMap<String, String> environment = new HashMap();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        serviceBuilder.withEnvironment(environment);

        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
	}
	/**
	 * Stop's the Appium Server and Close the Connection
	 */
	public static void stopAppiumServer() {
        server.stop();
    }
	/**
	 * 
	 * @return : driver
	 */
	public AppiumDriver<MobileElement> getAndroidDriver() {
		return driver;
	}
	/**
	 * 
	 * @return : wait
	 */
	public WebDriverWait getWebDriverWait() {
		return wait;
	}
}
