package us.tx.state.tea.seleniumfw.egrants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import us.tx.state.tea.seleniumfw.utils.ElementUtils;

public class eGrantsApplicationLegacy {

	static public void searchGranteeProfileByDistrict(WebDriver driver, String district)
	{
		driver.findElement(By.xpath("//input[@id=\"searchGranteeProfile_countyDistrict\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"searchGranteeProfile_countyDistrict\"]")).sendKeys(district);
        driver.findElement(By.xpath("//input[@id=\"searchGranteeProfile_searchButton\"]")).click();
	}
	
	static public void openGrantApplicationNCLBConsolidatedFederalGrantApplication(WebDriver driver)
	{
		new Actions(driver).moveToElement(driver.findElement(By.partialLinkText("NCLB Consolidated Federal Grant Application"))).click().perform();
	}
	
	static public void openGrantApplicationSpecialEducationConsolidatedGrantApplication(WebDriver driver)
	{
		new Actions(driver).moveToElement(driver.findElement(By.partialLinkText("Special Education Consolidated Grant Application"))).click().perform();
	}
	
	// Grants Schedules
	static public void openScheduleById(WebDriver driver, String scheduleId)
	{
		new Actions(driver).moveToElement(driver.findElement(By.partialLinkText(scheduleId))).click().perform();
	}	
}
