package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class Page {
	
	public String URL;
	public HashMap<String, String> xpathMap;
	public static WebDriver driver;
	
	public void setPage(String URL, HashMap<String, String> xpathMap, WebDriver driver){
		this.URL = URL; 
		this.xpathMap = xpathMap;
		Page.driver = driver;
	}

	public void verifyPage(String key) throws Exception{
		if (!driver.getTitle().equals(xpathMap.get(key)))
			throw new Exception(key + " not found");
	}
	
	public void goTo(){
		try{
			driver.get(URL);
			if (!driver.getTitle().equals(xpathMap.get("title")))
				throw new Exception(URL + " not found");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickID(String ID){
		try{
			driver.findElement(By.id(xpathMap.get(ID))).click();
		}
		catch(Exception e){
			System.out.println("Could not find " + ID + ". Continuing test");
		}
	}
	
	public void clickXPath(String XPATH){
		/* clicks inputed XPath. catches exception if not found*/
		try{
			driver.findElement(By.xpath(xpathMap.get(XPATH))).click();
		}
		catch(Exception e){
			System.out.println("Could not find " + XPATH + ". Continuing test");
		}
	}
	
	public void clickLinkText(String LINK){
		/* click link text. catches exception if not found */
		try{
			driver.findElement(By.linkText(xpathMap.get(LINK))).click();
		}
		catch(Exception e){
			System.out.println("Could not find " + LINK + ". Continuing test");
		}
	}
	
	public void clickName(String NAME){
		/* click link text. catches exception if not found */
		try{
			driver.findElement(By.name(xpathMap.get(NAME))).click();
		}
		catch(Exception e){
			System.out.println("Could not find " + NAME + ". Continuing test");
		}
	}
	
	public void selectFromDropDown(String dropDown, String item){
		try{
			WebElement dropDownListBox = driver.findElement(By.xpath(xpathMap.get(dropDown)));
			Select clickThis = new Select(dropDownListBox);
			int index = Integer.parseInt(xpathMap.get(item));
			clickThis.selectByIndex(index);
		}
		catch(Exception e){
			System.out.println("Could not find " + item + " in " + dropDown + ". Continuing test");
		}
	}
}