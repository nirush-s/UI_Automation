package generic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	 private final String propertyFilePath= "config//Config.properties";
	 
	 
	 public ConfigReader(){
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 properties = new Properties();
	 try {
	 properties.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	
	 
	 public String getValueFromConfig(String key) {
		 String value = properties.getProperty(key);
		 if(value != null) return value;
		 else throw new RuntimeException("url not specified in the Configuration.properties file.");
		 }
}