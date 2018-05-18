package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page{

	public HomePage(WebDriver driver){
		String URL = "http://www.mta.info";
		
		HashMap<String, String> homePageMap = new HashMap<String, String>();
		homePageMap.put("title", "MTA | Subway, Bus, Long Island Rail Road, Metro-North");
		homePageMap.put("schedule link", ".//*[@id='menu-399-1']/a");
		
		setPage(URL, homePageMap, driver);
	}
	
	public void clickScheduleButton() throws Exception{
		clickXPath("schedule link");
	}
}