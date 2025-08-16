package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	public ConfigReader() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\A M\\Eclipse-workSpace\\NullClassAmazonProject\\src\\main\\java\\config\\config.properties");
			prop = new Properties();
			prop.load(fis);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Loading the config File" + e.getMessage());

		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);

	}

}
