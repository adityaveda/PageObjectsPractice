package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class MTAPageFactory {

	public static void main(String args[]){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.mta.info/");
		Home page = PageFactory.initElements(driver, Home.class);
		page.clickSchedules();
	}
}