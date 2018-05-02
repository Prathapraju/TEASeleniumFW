package us.tx.state.tea.seleniumfs.cems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CEMSApplicationPage {
	public WebDriver driver;
	
	public static void returnHome(WebDriver driver) {
		driver.findElement(By.linkText("Home")).click();
		(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().equals("CEMS Home");   
            }
            });
	}
	
	public static String getMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='successInfoValidationSummary']/ul/li")).getText();
	}
	
	public static void accessPage(WebDriver driver, String linkname, final String title) {
		driver.findElement(By.linkText(linkname)).click();
		(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().contains(title);   
            }
            });
	}
	

}
