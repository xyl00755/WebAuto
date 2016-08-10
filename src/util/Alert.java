package util;

import java.util.HashMap;

public class Alert {

	// To click on the 'Cancel' button of the alert.
	public static void cancel(HashMap<String, String> params) {
		Browser.Driver.switchTo().alert().dismiss();
	}

	// To click on the 'OK' button of the alert.
	public static void accept(HashMap<String, String> params) {
		Browser.Driver.switchTo().alert().accept();
	}

	// To capture the alert message.
	public static void getText(HashMap<String, String> params) {
		Browser.Driver.switchTo().alert().getText();
	}

	// To send some data to alert box.
	public static void sendKeys(HashMap<String, String> params) {
		Browser.Driver.switchTo().alert().sendKeys(params.get("Text"));
	}

}
