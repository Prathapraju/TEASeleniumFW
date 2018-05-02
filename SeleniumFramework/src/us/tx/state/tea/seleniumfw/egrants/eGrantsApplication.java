package us.tx.state.tea.seleniumfw.egrants;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import us.tx.state.tea.seleniumfw.utils.ElementUtils;
import us.tx.state.tea.seleniumfw.utils.PageUtils;

public class eGrantsApplication {

	static long wait_time = 5;

	public static long getWait_time() {
		return wait_time;
	}

	public static void setWait_time(long wait_time) {
		eGrantsApplication.wait_time = wait_time;
	}

	static public void loginLocaleGrants(WebDriver driver, String url, String uid, String pwd)
	{
		driver.get(url);

		driver.navigate().refresh();
		PageUtils.wait(driver,2);

		ElementUtils.waitForElement(driver, By.xpath("//input[@name=\"Username\"]"), 60).clear();
		ElementUtils.waitForElement(driver, By.xpath("//input[@name=\"Username\"]"), 60).sendKeys(uid);
		ElementUtils.waitForElement(driver, By.xpath("//input[@name=\"Password\"]"), 60).clear();
		ElementUtils.waitForElement(driver, By.xpath("//input[@name=\"Password\"]"), 60).sendKeys(pwd);

		ElementUtils.waitForElement(driver, By.xpath("//input[@id=\"Submit1\"]"), 60).sendKeys(Keys.ENTER);	

		PageUtils.wait(driver,wait_time);
	}

	static public void searchGranteeProfileByDistrict(WebDriver driver, String district)
	{		
		PageUtils.wait(driver,1);

		ElementUtils.waitForElement(driver, By.xpath("//input[@id=\"SearchByCdn\"]"), 60).clear();
		ElementUtils.waitForElement(driver, By.xpath("//input[@id=\"SearchByCdn\"]"), 60).sendKeys(district);
		ElementUtils.waitForElement(driver, By.xpath("//*[@class=\"btnGo\"]"), 60).click();	

		PageUtils.wait(driver,wait_time);
	}

	static public void clickButton(WebDriver driver, String path)
	{
		Actions act = new Actions(driver);

		WebElement  menuElement = driver.findElement(By.xpath(path));		
		act.moveToElement(menuElement).build().perform();

		if( driver instanceof InternetExplorerDriver || driver instanceof EdgeDriver) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", menuElement); 
		}
		else
		{
			act.click().build().perform();		
		}


	}

	static public void clickButtonElement(WebDriver driver, WebElement element, String path)
	{
		Actions act = new Actions(driver);

		WebElement  menuElement = element.findElement(By.xpath(path));		
		act.moveToElement(menuElement).build().perform();

		if( driver instanceof InternetExplorerDriver || driver instanceof EdgeDriver) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", menuElement); 
		}
		else
		{
			act.click().build().perform();		
		}
	}

	static public void selectMenuHome(WebDriver driver)
	{
		driver.navigate().refresh();
		PageUtils.wait(driver,2);

		Actions act = new Actions(driver);

		WebElement  menuElement = driver.findElement(By.xpath("//img[@alt='Home']"));		
		act.moveToElement(menuElement).build().perform();

		if( driver instanceof InternetExplorerDriver || driver instanceof EdgeDriver) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", menuElement); 
		}
		else
		{
			act.click().build().perform();		
		}
	}

	static public void selectMenuOption(WebDriver driver, String menuOption, String subMenuOption)
	{			

		driver.navigate().refresh();
		PageUtils.wait(driver,2);

		Actions act = new Actions(driver);

		if(null != subMenuOption && !"".contentEquals(subMenuOption))
		{
			WebElement  menuElement = ElementUtils.waitForElement(driver, By.xpath("//*[@id=\"menu\"]/ul//*/a[text()='" + menuOption + "']"), 60);
			act.moveToElement(menuElement).build().perform();

			WebElement  subMenuElement = ElementUtils.waitForElement(driver, By.xpath("//*[@id=\"menu\"]/ul//*/a[text()='" + subMenuOption + "']"), 60);

			if( driver instanceof InternetExplorerDriver || driver instanceof EdgeDriver) {
				act.moveToElement(subMenuElement).build().perform();
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", subMenuElement); 
			}
			else
			{
				act.moveToElement(subMenuElement).build().perform();
				act.click().build().perform();		
			}

		}
		else
		{
			WebElement  menuElement = ElementUtils.waitForElement(driver, By.xpath("//*[@id=\"menu\"]/ul//*/a[text()='" + menuOption + "']"), 60);

			if( driver instanceof InternetExplorerDriver || driver instanceof EdgeDriver) {
				act.moveToElement(menuElement).build().perform();
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", menuElement); 
			}
			else
			{
				act.moveToElement(menuElement).build().perform();
				act.click().build().perform();	
			}
		}

		act.release();

		PageUtils.wait(driver,wait_time);				
	}

	static public void openItemGrantApplicationTableContents(WebDriver driver, String item)
	{

		driver.navigate().refresh();
		PageUtils.wait(driver,2);

		WebElement tableElement = ElementUtils.waitForElement(driver, By.xpath("//a[contains(text(), '" + item + "') and not(contains(@href, 'aspx'))]"), 60);

		if( driver instanceof InternetExplorerDriver || driver instanceof EdgeDriver) {	
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", tableElement); 
		}
		else
		{
			tableElement.click();
		}	

		PageUtils.wait(driver,wait_time);			
	}

	//Open Grants
	static public void openGrantByName(WebDriver driver, String grantName)
	{
		driver.navigate().refresh();
		PageUtils.wait(driver,2);

		Actions act = new Actions(driver);

		WebElement  grantElement = ElementUtils.waitForElement(driver, By.partialLinkText(grantName), 60);

		if( driver instanceof InternetExplorerDriver || driver instanceof EdgeDriver) {
			act.moveToElement(grantElement).build().perform();
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", grantElement); 
		}
		else
		{
			act.moveToElement(grantElement).build().perform();
			act.click().build().perform();	
		}		

		PageUtils.wait(driver,wait_time);
	}

	// Grants Schedules
	static public boolean openScheduleById(WebDriver driver, String scheduleId)
	{

		driver.navigate().refresh();
		PageUtils.wait(driver,2);

		boolean status = false;

		Actions act = new Actions(driver);

		WebElement  scheduleIdElement = ElementUtils.waitForElement(driver, By.partialLinkText(scheduleId), 60);

		if( driver instanceof InternetExplorerDriver || driver instanceof EdgeDriver) {	
			act.moveToElement(scheduleIdElement).build().perform();
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", scheduleIdElement); 
		}
		else
		{
			act.moveToElement(scheduleIdElement).build().perform();
			act.click().build().perform();	
		}	


		if(PageUtils.isAlertPresent(driver))
			driver.switchTo().alert().accept();

		if(!driver.getPageSource().contains("Server Error in '/' Application."))
		{
			if(!driver.getPageSource().contains(".aspx"))
			{

				ElementUtils.waitForElement(driver, By.xpath("//*[@class=\"childIdentifier\"]"), 30);
			}

			status = true;

		}

		return status;
	}	

	//Open Grants
	static public void clickHyperLinkByText(WebDriver driver, String text)
	{
		driver.navigate().refresh();
		PageUtils.wait(driver,2);

		Actions act = new Actions(driver);

		WebElement  grantElement = ElementUtils.waitForElement(driver, By.partialLinkText(text), 60);

		if( driver instanceof InternetExplorerDriver || driver instanceof EdgeDriver) {
			act.moveToElement(grantElement).build().perform();
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", grantElement); 
		}
		else
		{
			act.moveToElement(grantElement).build().perform();
			act.click().build().perform();	
		}		

		PageUtils.wait(driver,wait_time);
	}

	static public boolean isScheduleErrorPanelVisible(WebDriver driver)
	{
		boolean status = false;

		WebElement  element = null;

		try {
			element = ElementUtils.waitForElement(driver, By.id("error-div"), 30);

			if(null != element)
				status = true;

		} catch (Exception e) {

		}

		return status;
	}

	static public WebElement getScheduleErrorPanel(WebDriver driver)
	{

		WebElement  element = null;

		try {
			element = ElementUtils.waitForElement(driver, By.id("error-results"), 30);		
		} catch (Exception e) {

		}

		return element;
	}

	static public boolean isErrorFormAlertVisible(WebDriver driver)
	{
		boolean status = false;
		WebElement  element = null;

		try {
			element = ElementUtils.waitForElement(driver, By.cssSelector("[class*=alert-background]"), 30);		

			if(null != element)
				status = true;
		} catch (Exception e) {

		}

		return status;
	}

	static public WebElement getErrorFormAlert(WebDriver driver)
	{

		WebElement  element = null;

		try {
			element = ElementUtils.waitForElement(driver, By.cssSelector("[class*=alert-background]"), 30);		
		} catch (Exception e) {

		}

		return element;
	}

	static public boolean isFormAlertShowingNoErrors(WebDriver driver)
	{
		boolean status = false;
		WebElement  element = null;

		try {
			element = ElementUtils.waitForElement(driver, By.cssSelector("[class*=alert-message]"), 30);		

			if(null != element && element.getText().contains("Congratulations, your data has been saved and your schedule has no errors or warnings."))
				status = true;
		} catch (Exception e) {

		}

		return status;
	}

	static public boolean isFormAlert(WebDriver driver)
	{
		boolean status = false;
		WebElement  element = null;

		try {
			element = ElementUtils.waitForElement(driver, By.cssSelector("[class*=alert-message]"), 30);		

			if(null != element)
				status = true;
		} catch (Exception e) {

		}

		return status;
	}



	static public boolean isFormAlert(WebDriver driver, int timeout)
	{
		boolean status = false;
		WebElement  element = null;

		try {
			element = ElementUtils.waitForElement(driver, By.cssSelector("[class*=alert-message]"), timeout);		

			if(null != element)
				status = true;
		} catch (Exception e) {

		}

		return status;
	}

	static public WebElement getFormAlert(WebDriver driver)
	{

		WebElement  element = null;

		try {
			element = ElementUtils.waitForElement(driver, By.cssSelector("[class*=alert-message]"), 30);		
		} catch (Exception e) {

		}

		return element;
	}

	static public boolean isFormatterFormAlert(WebDriver driver)
	{
		boolean status = false;
		WebElement  element = null;

		try {
			element = ElementUtils.waitForElement(driver, By.cssSelector("[class*=alert-message-formatted]"), 30);		

			if(null != element)
				status = true;
		} catch (Exception e) {

		}

		return status;
	}

	static public WebElement getFormattedFormAlert(WebDriver driver)
	{

		WebElement  element = null;

		try {
			element = ElementUtils.waitForElement(driver, By.cssSelector("[class*=alert-message-formatted]"), 30);		
		} catch (Exception e) {

		}

		return element;
	}

	static public boolean isButtonAvailableInElement(WebElement element, String buttonText)
	{
		boolean status = false;
		WebElement  buttonElement = null;

		try {
			buttonElement = element.findElement(By.xpath(buttonText));		

			if(null != buttonElement)
				status = true;
		} catch (Exception e) {

		}

		return status;
	}
}
