package com.danlu.testcases;

import java.util.Set;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

@Listeners({ com.danlu.demo_assert.AssertionListener.class })
public class TestIDE {
	private WebDriver driver;
	// private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		// System.setProperty("webdriver.firefox.bin", "c:\\Program Files
		// (x86)\\Mozilla Firefox\\firefox.exe");

		driver = new FirefoxDriver();

		driver.get("https://www.baidu.com/");

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.id("kw")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("kw")).sendKeys("163邮箱");
		Thread.sleep(1000);
		driver.findElement(By.id("su")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='1']/h3/a[1]")).click();
		// driver.switchTo().window("163网易免费邮--中文邮箱第一品牌");
		// switchToWindow(driver, "adfa");
		// switchToWindow(driver, "163网易免费邮--中文邮箱第一品牌");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='idInput']")).sendKeys("123456");
	}

	// @After
	public void tearDown() throws Exception {
		driver.quit();
		// String verificationErrorString = verificationErrors.toString();
		// if (!"".equals(verificationErrorString)) {
		// fail(verificationErrorString);
		// }

	}

	public boolean switchToWindow(WebDriver driver, String windowTitle) {

		boolean flag = false;
		try {
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String s : handles) {
				if (s.equals(currentHandle))
					continue;
				else {
					driver.switchTo().window(s);
					if (driver.getTitle().equals(windowTitle)) {
						flag = true;
						System.out.println("Switch to window: " + windowTitle + " successfully!");
						break;
					} else
						continue;
				}
			}
		} catch (NoSuchWindowException e) {

			System.out.println(e.fillInStackTrace());
			System.out.println("Window: " + windowTitle + " cound not found!");
			System.out.println(e.getMessage());
			flag = false;
		}
		return flag;
	}
}
