package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Schedules extends Page{

	public LongIslandRR lirr;
	public MetroNorth metroNorth;
	
	public Schedules(WebDriver driver){
		String URL = "http://web.mta.info/maps/";
		
		lirr = new LongIslandRR(driver);
		metroNorth = new MetroNorth(driver);
		
		HashMap<String, String> scheduleMap = new HashMap<String, String>();
		scheduleMap.put("title", "Schedules | MTA");
		scheduleMap.put("lirrLink", "Long Island Rail Road");
		scheduleMap.put("metroLink", "Metro-North Railroad");
		scheduleMap.put("statenLink", "Staten Island Railway (PDF)");
		
		setPage(URL, scheduleMap, driver);
	}
	
	public void clickLirrLink(){
		clickLinkText("lirrLink");
	}
	
	public void clickMetroLink(){
		clickLinkText("metroLink");
	}
	
	public void clickStatenLink(){
		clickLinkText("statenLink");
	}
	
	public class LongIslandRR extends Page{
		
		public LongIslandRR(WebDriver driver){
			String URL = "http://lirr42.mta.info/";
			
			HashMap<String, String> lirrMap = new HashMap<String, String>();
			lirrMap.put("title", "MTA LIRR - Schedules & Fares");
			lirrMap.put("fromDropDown", ".//*[@id='FromStation ']");
			lirrMap.put("toDropDown", ".//*[@id='ToStation '] ");
			lirrMap.put("timeButton", "RequestTime");
			lirrMap.put("ampmButton", "RequestAMPM");
			lirrMap.put("schedulesButton", "schedules");
			lirrMap.put("Syosset", "114");
			lirrMap.put("Penn Station", "92");
			lirrMap.put("timeDropDown", ".//*[@id='RequestTime']");
			lirrMap.put("7:30", "26");
			lirrMap.put("AMPMDropDown", ".//*[@id='RequestAMPM']");
			lirrMap.put("AM", "0");
			
			setPage(URL, lirrMap, driver);
		}
		
		public void scheduleTrip(String from, String to, String time, String AMPM){
			selectFromDropDown("fromDropDown", from);
			selectFromDropDown("toDropDown", to);
			selectFromDropDown("timeDropDown", time);
			selectFromDropDown("AMPMDropDown", AMPM);
		}
	}
	
	public class MetroNorth extends Page{
		
		public EastHudson eastHudson;
		
		public MetroNorth(WebDriver driver){
			String URL = "http://web.mta.info/mnr/html/planning/schedules/";
		
			eastHudson = new EastHudson(driver);
			
			HashMap<String, String> metroMap = new HashMap<String, String>();
			metroMap.put("title", "MNR Schedules");
			metroMap.put("eastHudsonMap", ".//*[@id='contentbox']/div[1]/table/tbody/tr/td/map/area[1]");
			
			setPage(URL, metroMap, driver);
		}
		
		public void clickEastHudson(){
			clickXPath("eastHudsonMap");
		}
		
		public class EastHudson extends Page{
			
			public EastHudson(WebDriver driver){
				String URL = "http://as0.mta.info/mnr/schedules/sched_form.cfm";
				
				HashMap<String, String> metroMap = new HashMap<String, String>();
				metroMap.put("eastHudsonMap", ".//*[@id='contentbox']/div[1]/table/tbody/tr/td/map/area[1]");
				metroMap.put("fromDropDown", ".//*[@id='orig_station']");
				metroMap.put("toDropDown", ".//*[@id='dest_station']");
				metroMap.put("timeDropDown", ".//*[@id='Time_id']");
				metroMap.put("AMPMDropDown", ".//*[@id='frmindex']/table/tbody/tr[6]/td/select[2]");
				metroMap.put("Appalachian Trail", "1");
				metroMap.put("Yonkers", "113");
				metroMap.put("7:30", "1");
				metroMap.put("AM", "0");
				
				setPage(URL, metroMap, driver);
			}
			
			public void scheduleTrip(String from, String to, String time, String AMPM){
				selectFromDropDown("fromDropDown", from);
				selectFromDropDown("toDropDown", to);
				selectFromDropDown("timeDropDown", time);
				selectFromDropDown("AMPMDropDown", AMPM);
			}
		}
	}
}
