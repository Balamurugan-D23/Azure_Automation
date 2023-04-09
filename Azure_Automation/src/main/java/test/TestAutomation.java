package test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equals("Google")) {
			System.out.println("PASS");
			assertTrue(true);
		} else {
			System.out.println("FAIL");
			assertTrue(false);
		}
	}

}
