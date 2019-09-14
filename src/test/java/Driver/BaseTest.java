package Driver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class BaseTest extends desiredCapabilities {
	
   
	
@Before
public void beforeHookfunction() throws MalformedURLException, InterruptedException{
        
	Reporter.assignAuthor(" Sivasankaramalan Gunasekarasivam ");

	    SetDesiredCapabilities();
    }
 
    @After(order = 0)
    public void afterHookfunction() {
        System.out.println("test completed");
        driver.quit();
        stopAppiumServer();

    }
    
    @After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				/**
				 *  This takes a screenshot from the driver at save it to the specified location
				 *  Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				 */
				
				TakesScreenshot scrShot =((TakesScreenshot)driver);
                File sourcePath = scrShot.getScreenshotAs(OutputType.FILE);
                 
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				
				/**
				 * Copy taken screenshot from source location to destination location
				 */
				Files.copy(sourcePath, destinationPath);   

				/**
				 * This attach the specified screenshot to the test
				 */
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
		}
	}

}