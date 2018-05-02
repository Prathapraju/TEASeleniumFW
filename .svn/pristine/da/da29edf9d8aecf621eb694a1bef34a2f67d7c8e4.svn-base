package us.tx.state.tea.seleniumfw.tsdspeims;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import us.tx.state.tea.seleniumfw.utils.ElementUtils;

public class TSDSPeims {

	static public void changePEIMSYear(WebDriver driver, String acadYr, boolean sync)
	{
		new Select(driver.findElement(By.id("hdrAcadYearLst"))).selectByVisibleText(acadYr);
		if(!sync)
			ElementUtils.waitForElement(driver, By.id("goButton"), 60).click();
	}

	static public void changePEIMSCollection(WebDriver driver, String collectionId, boolean sync)
	{
		new Select(driver.findElement(By.xpath("//*[@id=\"hdrCollectionsLst\"]"))).selectByVisibleText(collectionId);
		if(!sync)
			ElementUtils.waitForElement(driver, By.id("goButton"), 60).click();
	}

	static public void changePEIMSSubmission(WebDriver driver, String submissionId, boolean sync)
	{
		new Select(driver.findElement(By.id("hdrSubmissionsLst"))).selectByVisibleText(submissionId);
		if(!sync)
			ElementUtils.waitForElement(driver, By.id("goButton"), 60).click();
	}	

	static public void clickGO(WebDriver driver)
	{
		ElementUtils.waitForElement(driver, By.id("goButton"), 60).click();
	}

	static public void selectMenuHome(WebDriver driver)
	{
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"nav\"]"));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"nav\"]/li[1]"))).click().build().perform();
	}

	static public void selectMenuOption(WebDriver driver, String menu, String subMenu)
	{
		//		
		//		WebElement  element = driver.findElement(By.xpath("//*[@id=\"nav\"]/*[@title=\""+menu+"\"]/ul/*/a[text()='"+subMenu+"']"));
		//		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//		executor.executeScript("arguments[0].click();", element);

		Actions act = new Actions(driver);

		if(null != subMenu && !"".contentEquals(subMenu))
		{
			WebElement  menuElement = driver.findElement(By.xpath("//*[@id=\"nav\"]/*[@title=\""+menu+"\"]"));		
			act.moveToElement(menuElement).build().perform();

			WebElement  subMenuElement = driver.findElement(By.xpath("//*[@id=\"nav\"]/*[@title=\""+menu+"\"]/ul/*/a[text()='"+subMenu+"']"));
			act.moveToElement(subMenuElement).build().perform();
			act.click().build().perform();	


		}
		else
		{
			WebElement  menuElement = driver.findElement(By.xpath("//*[@id=\"nav\"]/*[@title=\""+menu+"\"]"));		
			act.moveToElement(menuElement).build().perform();
			act.click().build().perform();
		}

		act.release();

		//PageUtils.wait(driver,wait_time);			
	}
}
