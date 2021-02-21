package uk.kainos.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	public static String TEST_END_POINT_URL=readProperty("configuration.properties","GET_TEST_END_POINT_URL");
	public static String TEST_BAD_END_POINT_URL=readProperty("configuration.properties","GET_TEST_BAD_END_POINT_URL");
	public static String POST_END_POINT_URL=readProperty("configuration.properties","POST_END_POINT_URL");


	public static String readProperty(String configFileName, String key) {
		FileInputStream fis=null;
		Properties prop=null;
		try {
			fis=new FileInputStream("./src/test/resources/"+configFileName);
			prop=new Properties();
			prop.load(fis);
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop.getProperty(key);
	}
	
	

}
