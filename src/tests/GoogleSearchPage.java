package tests;

import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
 /*   // Here's the element	
	private WebElement Subway;
	
	public void clickFares(){
		Subway.click();
	}
}*/
    private WebElement q;

    public void searchFor(String text) {
        // And here we use it. Note that it looks like we've
        // not properly instantiated it yet....
        q.sendKeys(text);
        q.submit();
    }
}