package test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAutomation {

	@Test
	public void Test1() {
		System.out.println("Test 1 Executed");
	}

	@Test
	public void Test2() {
		System.out.println("Test 2 Executed");
	}

	@Test
	public void Test3() {
		System.out.println("Test 3 Executed");
	}

	@Test
	public void Test4() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		// WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com/");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equals("Google")) {
			System.out.println("PASS");
			System.out.println(System.getProperty("user.dir"));

			//takeSnapShot(driver, System.getProperty("user.dir") + "\\test-output\\H1.png");
			takeSnapShot(driver, "C:\\Users\\balam\\git\\Azure_Automation\\Azure_Automation\\H1.png");
			assertTrue(true);
		} else {
			System.out.println("FAIL");
			assertTrue(false);
		}
	}

	public void takeSnapShot(WebDriver webdriver, String fileWithPath) {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
