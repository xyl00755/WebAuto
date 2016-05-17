package util;

import java.util.HashMap;

import common.Elements;
import util.Browser;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class GetElementSize {

	public static Dimension run(HashMap<String, String> params){
		WebElement element = Elements.find(params,Browser.Driver); 
        return element.getSize();
	}
}
