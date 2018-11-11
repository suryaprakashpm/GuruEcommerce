package liveECommercesiteTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Driverlocation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		InputStream inputStream = new FileInputStream("config.properties");
		properties.load(inputStream);
		String driverPath = properties.getProperty("driverlocation");
		System.out.println(driverPath);
	}

}
