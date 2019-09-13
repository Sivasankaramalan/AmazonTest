package Utility;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Sivasankaramalan G
 * To read the Properties files and returns the property value.
 * 
 */

public class ReadProperties {

	public Properties properties = new Properties();
	private File file;
	private int count = 0;

	public void readFile(File file) throws Exception {
		setFile(file);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(this.file));
		this.properties.load(bis);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	/**
	 * 
	 * @param property
	 * @return
	 */
	public String getValue(String property) {
		if (count > 0) {
			return this.properties.getProperty(count + property);

		} else {
			return this.properties.getProperty(property);
		}
	}

}
