package tests;

public class CheckSchedules extends TestBase{
	
	public static void main(String[] args) throws Exception{
		//add a gui to this and have all the tests be listed off in gui. also have html/pdf that
		//takes screenshots of everything and what is happening. along with a dig down of the step
		//and the problem
		homePage.goTo();
		homePage.clickScheduleButton();
		schedules.clickLirrLink();
		schedules.lirr.scheduleTrip("Syosset", "Penn Station", "7:30", "AM");
		
		schedules.metroNorth.goTo();
		schedules.metroNorth.clickEastHudson();
		schedules.metroNorth.eastHudson.scheduleTrip("Appalachian Trail", "Yonkers", "7:30", "AM");
	}
}