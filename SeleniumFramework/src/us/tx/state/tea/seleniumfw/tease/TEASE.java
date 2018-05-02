package us.tx.state.tea.seleniumfw.tease;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import us.tx.state.tea.seleniumfw.utils.ElementUtils;

public class TEASE {
	
	static public void loginTEASE(WebDriver driver, String url, String uid, String pwd)
	{
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@name=\"Username\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"Username\"]")).sendKeys(uid);
        driver.findElement(By.xpath("//input[@name=\"Password\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"Password\"]")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@id=\"Submit1\"]")).click();  
				
	}
	
	static public void openeGrantsDevPage(WebDriver driver)
	{
		ElementUtils.waitForElement(driver, By.xpath("//a[text()[contains(.,'eGrants_DEV')]]"), 60).click();
	}
	
	public void accessApp(WebDriver driver, String appname) {
		ElementUtils.waitForElement(driver, By.partialLinkText(appname), 60).click();
        try {
        	ElementUtils.waitForElement(driver, By.name("Assent"), 2).click();
        } catch (TimeoutException te) {
        }	
	}
	
	public void logout(WebDriver driver) {
		driver.findElement(By.id("Button6")).click();
		driver.findElement(By.id("Submit1")).click();
	}
	
	public boolean verifyTEASEAccess(WebDriver driver) {
		return driver.findElement(By.partialLinkText("RFT - Residential Facility Tracking")).isEnabled();
	}
}
