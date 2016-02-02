package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class FileUtil {

	public static Properties readProperties(String filePath){
		
		Properties p = new Properties();
		try {
			InputStream in = FileUtil.class.getResourceAsStream(filePath);
			p.load(in);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}	
	
	
	public static void main(String args[]){
		String filePath = "/elementpath_OPERATE.properties";
		Properties p = readProperties(filePath);
		String value = p.getProperty("loginpage_username");
		System.out.println(value);
		getP("loginpage_loginbtn");
		
	}
	
	@Test
	public static String getP(String param){
		String filePath = "/elementpath_TRADE.properties";
		Properties p = readProperties(filePath);
		String pr = p.getProperty(param);
		System.out.println(param);
		System.out.println(pr);
		return pr;
	}
	
}
