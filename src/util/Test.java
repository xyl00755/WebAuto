package util;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static String run(HashMap<String, String> params) {
		WebDriver dr = new FirefoxDriver();
		dr.get("http://www.amazon.com");
		String a = dr.findElement(By.xpath(".//*[@id='nav-logo']/a[1]/span[1]")).getText();
		System.out.println(a);
        return a;
	}
	
}
