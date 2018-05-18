package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.HomePage;
import pages.Maps;
import pages.Schedules;

public abstract class TestBase {
	
	public static WebDriver driver = new FirefoxDriver();
	public static HomePage homePage = new HomePage(driver);
	public static Maps maps = new Maps(driver);
	public static Schedules schedules = new Schedules(driver);
	
	public static void closeDriver(){	
		driver.close();
	}
}
