package Utility;

import java.io.File;

/**
 * 
 * @author Sivasankaramalan
 * Utility Method to set the certain properties to DesiredCapabilities.
 * 
 */

public class SetProperties {

	
	// Create reference of ReadProperties class.
	
	public static ReadProperties appConfig;

	public SetProperties() {
		try {
			appConfig = new ReadProperties();

			
			/**
			 * Read Input's from AppConfig Properties file
			 */
			
			appConfig.readFile(new File(System.getProperty("user.dir")+ "/src/test/resources/PropertyFiles/appConfig.properties"));

//			appConfig.readFile(new File("/Amazon_Test/src/test/resources/PropertyFiles/appConfig.properties"));

			
			} 
		catch (Exception e) {
			
			e.printStackTrace();
			
			}
		}
}
