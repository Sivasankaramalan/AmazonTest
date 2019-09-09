package Driver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},		
features = {"/Users/sivasankaramalan/Desktop/Amazon_Test/src/test/resources/features/AmazonTestFeatureOne.feature"},
//tags= {"~@Sanity","@Regression"},
//tags= {"@Notes"},
monochrome = true
 )
public class Runner {
	
	@BeforeClass
	public static void setup() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("target/cucumber-reports/"+timeStamp.replace(":","_").replace(".","_")+".html");
	}
	

	@AfterClass
	public static void writeExtentReport() {
		 
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/target/extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    
	  }
	}

