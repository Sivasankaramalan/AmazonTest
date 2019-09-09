package PageObjects;

import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import Driver.desiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class CommonMethodsFunctions extends desiredCapabilities{

	public static void assertEquals(Object actual, Object expected, String message) {
		
		Assert.assertEquals(actual, expected, message);
	}
	public void scrollToText(String text, AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
	    	 MobileElement el = (MobileElement) ((FindsByAndroidUIAutomator) driver)
					    .findElementByAndroidUIAutomator("new UiScrollable("
					        + "new UiSelector().scrollable(true)).scrollIntoView("                      
					        + "new UiSelector().textContains(\""+text+"\"));");
			  el.click();
	}
	
//    public void ScrollUp() {
//   	 TouchAction action = new TouchAction(driver);
//		   action.longPress((WebElement) PointOption.point(393, 452));
//		   action.moveTo((WebElement) PointOption.point(385, 1000));
//		   action.release();
//		   action.perform();
//    }
	
	public void clickAction(WebElement element, AppiumDriver<MobileElement> driver) throws InterruptedException {
		Thread.sleep(2000);
		Actions builder = new Actions(driver);
        builder.moveToElement(element).click();
        builder.perform();
	}
	
	/**
	 * Switch to WebView context
	 * 
	 * @param driver
	 */
	public void switchToWebView(AppiumDriver<MobileElement> driver) {

		Set<String> availableContexts = driver.getContextHandles();
		System.out.println("Total No of Context Found = " + availableContexts.size());
		System.out.println("Available Contexts: " + availableContexts);
		for (String context : availableContexts) {
			System.out.println("context: " + context);
			if (context.contains("WEBVIEW")) {
				System.out.println("Switching to Context: " + context);
				driver.context(context);
				System.out.println("Switched to Context: " + context);
				break;
			} else {
				System.out.println("Expected context not found");
			}
		}
	}

	/**
	 * Switch to Native context
	 * 
	 * @param driver
	 */
	public void switchToNativeApp(AppiumDriver<MobileElement> driver) {
		driver.context("NATIVE_APP");
		System.out.println("Context switched to " + "NATIVE_APP");
	}
}
