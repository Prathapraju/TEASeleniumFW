package us.tx.state.tea.seleniumfw.tsdsportal;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import us.tx.state.tea.seleniumfw.utils.ElementUtils;
import us.tx.state.tea.seleniumfw.utils.PageUtils;

public class TSDSPortal {	
	
	static public void selectOrg(WebDriver driver, String orgId)
	{
		new Select(driver.findElement(By.id("orgList"))).selectByValue(orgId);
        driver.findElement(By.id("goButton")).click();
	}
	
	static public void goPEIMSTab(WebDriver driver)
	{		
		driver.findElement(By.xpath("//*[@href='PEIMS']")).click();
	}

	static public void openApplication(final WebDriver driver, String appname, String title)
	{
		ElementUtils.waitForElement(driver, By.partialLinkText(appname), 30).click();
		PageUtils.waitForNewWindowLoad(driver, title);		
	}
	
	public static void exitTSDS(WebDriver driver) {
		driver.findElement(By.linkText("Exit")).click();
	}
	
	public static void exitApplication(WebDriver driver) {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    driver.findElement(By.linkText("Exit")).click();
	    driver.switchTo().window(tabs2.get(0));
	}
	
    public static String getSelectedOrgID(WebDriver driver) {
   	 return new Select(driver.findElement(By.id("orgList"))).getFirstSelectedOption().getAttribute("value");
   }
   
   public static String getSelectedOrgName(WebDriver driver) {
   	String org = new Select(driver.findElement(By.id("orgList"))).getFirstSelectedOption().getText();
   	String orgname = org.substring(0, org.indexOf("("));
   	return orgname;
   }
   
   public static void webServiceTest(WebDriver driver) {
   	driver.findElement(By.linkText("Edit My User Information")).click();
   	driver.switchTo().frame("myProfile-frame");
   	ElementUtils.waitForElement(driver, By.id("clickUid"), 20).click();
   	ElementUtils.waitForElement(driver, By.id("ssn"), 20).sendKeys("402151961");
   	Select yearselect = new Select(driver.findElement(By.id("yearofbirth")));
   	yearselect.selectByValue("1961");
   	Select genderselect = new Select(driver.findElement(By.id("gender")));
   	genderselect.selectByValue("M");
   	driver.findElement(By.id("uidSubmit")).click();
   	String uniqueidmessage = ElementUtils.waitForElement(driver, By.id("uniqidMessage"), 20).getText();
   	Assert.assertTrue(uniqueidmessage.contains("Located a match. Your Uniq-ID value is"));
   	driver.findElement(By.id("uidOkCancel")).click();
   	driver.switchTo().defaultContent();
   	ElementUtils.waitForElement(driver, By.xpath("//*[@id='tabs-nav']/li[2]/span"), 20).click();
   }
}
