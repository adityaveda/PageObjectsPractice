package tests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class Home{
	
	private String title = "MTA | Subway, Bus, Long Island Rail Road, Metro-North";
	
	@FindBy(id="superfish-1")
	private WebElement bannerOfLinks;
	
	public void clickSchedules(){
		bannerOfLinks.findElement(By.linkText("Maps")).click();
	}
}


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