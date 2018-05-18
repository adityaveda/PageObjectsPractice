package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Maps extends Page{
	
	public Maps(WebDriver driver){
		String URL = "http://web.mta.info/maps/";
		
		HashMap<String, String> mapsMap = new HashMap<String, String>();
		mapsMap.put("title", "mta.info | MTA Neighborhood Maps");
		mapsMap.put("subwaySystemLink", "Subway System");
		
		setPage(URL, mapsMap, driver);
	}
	
	public void clickSubwayMap(){
		clickLinkText("subwaySystemLink");
	}
}
