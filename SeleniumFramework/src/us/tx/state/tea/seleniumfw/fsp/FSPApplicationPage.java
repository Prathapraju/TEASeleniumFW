package us.tx.state.tea.seleniumfw.fsp;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import us.tx.state.tea.seleniumfw.utils.*;

public class FSPApplicationPage {
	
	public static void accessLink(WebDriver driver, String linkname) {
		driver.findElement(By.linkText(linkname)).click();
		PageUtils.waitForPageToLoad(driver);
	}
	
	public static void accessNewPageByLink(WebDriver driver, String linkname, String title) {
		driver.findElement(By.linkText(linkname)).click();
		PageUtils.waitForNewWindowLoad(driver, title);
	}
	
	public static String getStatusMessage(WebDriver driver) {
		return driver.findElement(By.id("spanStatusMessage")).getText();
	}
	
	public static void accessApplication(WebDriver driver, String menu, String submenu) {
		Actions action = new Actions(driver);
		WebElement progmenu = driver.findElement(By.linkText(menu));
		action.moveToElement(progmenu).build().perform();
		driver.findElement(By.linkText(submenu)).click();
		PageUtils.waitForPageToLoad(driver);
	}
	
	public static void closeCurrentPage(WebDriver driver) {
		String currentWindowHandle = driver.getWindowHandle();
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.close();
		for (String window:windowHandles){
	        if (!window.equals(currentWindowHandle)){
	            driver.switchTo().window(window);
	        }
	    }
	}
	
	public static boolean doesLinkExist(WebDriver driver, String linkname) {
		return ElementUtils.IsPresentandDisplayed(driver, By.linkText(linkname));
	}
	
	public static int getErrorMessageCount(WebDriver driver) {
		return driver.findElement(By.className("failureMessage")).findElements(By.tagName("li")).size();
	}
	
	public static String getSpecificErrorMessage(WebDriver driver, int index) {
		return driver.findElement(By.className("failureMessage")).findElements(By.tagName("li")).get(index).getText();
	}
	
    public static String getVersion(WebDriver driver) {
    	return driver.findElement(By.id("teaFooterAppVersion")).getText();
    }
	
	public static void setCDN(WebDriver driver, String cdn) {
		ElementUtils.waitForElements(driver, By.id("ctl00_txtDistrictId"), 30).clear();
		driver.findElement(By.id("ctl00_txtDistrictId")).sendKeys(cdn);
	}
	
	public static void selectSchoolYear(WebDriver driver, String acadyr) {
		WebElement yearselectid = driver.findElement(By.id("ctl00_ddlYear"));
		Select yearselect = new Select(yearselectid);
		yearselect.selectByValue(acadyr);
	}
	
	public static void updateCDN(WebDriver driver) {
		WebElement ele = driver.findElement(By.id("ctl00_btnUpdate"));
		ele.click();
	}
	
	public static String getDistrictName(WebDriver driver) {
		return driver.findElement(By.id("ctl00_lblDistrictName")).getText();
	}
	
	public static void exitFSP(WebDriver driver) {
		driver.findElement(By.linkText("[Exit]")).click();
	}

	public static String getWarningMessage(WebDriver driver) {
		String warningmessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return warningmessage;
	}
	
	public static void acceptWarning(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

}