package us.tx.state.tea.seleniumfw.egrants;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import us.tx.state.tea.seleniumfw.utils.ElementUtils;

public class eGrantsApplicationCS7000 {

	public static WebElement getSchedulePartByName(WebDriver driver, String part)
	{
		WebElement internalElement = null;

		List<WebElement> allSpanChildElements = driver.findElements(By.xpath("//*[@class=\"schedulePart\"]//parent::*"));

		for (WebElement webElement : allSpanChildElements) {							
			if(webElement.getText().contains(part))
			{		
				internalElement = webElement;
				break;		
			}
		}

		return internalElement;
	}

	public static WebElement getSchedulePartSectionRowByContent(WebElement element, String section, String content)
	{	
		WebElement internalElement = null;

		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {
			if(webElement.getText().contains(section))
			{
				List<WebElement> allSpanChildElementsInternal = webElement.findElements(By.cssSelector("[class*=sectionRow]"));
				for (WebElement webElementInternal : allSpanChildElementsInternal) {	
					if(webElementInternal.getText().contains(content))
					{		
						internalElement = webElementInternal;
						break;		
					}
				}
			}

			if(null != internalElement)
				break;
		}

		return internalElement;
	}

	public static boolean checkCheckBoxSchedulePartSectionRowContent(WebElement element, String section, String content)
	{	
		boolean status = false;

		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {
			if(webElement.getText().contains(section))
			{
				List<WebElement> allSpanChildElementsInternal = webElement.findElements(By.cssSelector("[class*=sectionRow]"));
				for (WebElement webElementInternal : allSpanChildElementsInternal) {
					if(webElementInternal.getText().contains(content))
					{		
						try {							
							if (!webElementInternal.findElement(By.cssSelector("input[type='checkbox']")).isSelected())
							{
								webElementInternal.findElement(By.cssSelector("input[type='checkbox']")).click();														
								status=true;
								break;
							}		
						} catch (Exception e) {
							// TODO: handle exception
						}						
					}					
				}
			}

			if(status == true)
				break;
		}

		return status;
	}
	
	public static boolean checkCheckBoxSelectedSchedulePartSectionRowContent(WebElement element, String section, String content)
	{	
		boolean status = false;

		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {
			if(webElement.getText().contains(section))
			{
				List<WebElement> allSpanChildElementsInternal = webElement.findElements(By.cssSelector("[class*=sectionRow]"));
				for (WebElement webElementInternal : allSpanChildElementsInternal) {
					if(webElementInternal.getText().contains(content))
					{		
						try {
							if (webElementInternal.findElement(By.cssSelector("input[type='checkbox']")).isSelected())
							{							
								status=true;
								break;
							}									
						} catch (Exception e) {
							// TODO: handle exception
						}						
					}					
				}
			}

			if(status == true)
				break;
		}

		return status;
	}


	public static boolean checkAllCheckBoxSchedulePartSectionRow(WebElement element, String section)
	{	
		boolean status = false;

		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {
			if(webElement.getText().contains(section))
			{
				List<WebElement> allSpanChildElementsInternal = webElement.findElements(By.cssSelector("[class*=sectionRow]"));
				for (WebElement webElementInternal : allSpanChildElementsInternal) {
					try {
						if (!webElementInternal.findElement(By.cssSelector("input[type='checkbox']")).isSelected())
						{
							webElementInternal.findElement(By.cssSelector("input[type='checkbox']")).sendKeys(Keys.SPACE);
							status=true;								
						}
									
					} catch (Exception e) {

					}						
				}
			}

			if(status == true)
				break;
		}

		return status;
	}
	
	public static boolean checkAllCheckBoxSelectedSchedulePartSectionRow(WebElement element, String section)
	{	
		boolean status = true;

		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {
			if(webElement.getText().contains(section))
			{
				List<WebElement> allSpanChildElementsInternal = webElement.findElements(By.cssSelector("[class*=sectionRow]"));
				for (WebElement webElementInternal : allSpanChildElementsInternal) {
					try {
						if (!webElementInternal.findElement(By.cssSelector("input[type='checkbox']")).isSelected())
						{							
							status=false;								
						}
									
					} catch (Exception e) {
						// TODO: handle exception
					}						
				}
			}

			if(status == false)
				break;
		}

		return status;
	}
	
	public static boolean unCheckAllCheckBoxSchedulePartSectionRow(WebElement element, String section)
	{	
		boolean status = false;

		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {
			if(webElement.getText().contains(section))
			{
				List<WebElement> allSpanChildElementsInternal = webElement.findElements(By.cssSelector("[class*=sectionRow]"));
				for (WebElement webElementInternal : allSpanChildElementsInternal) {
					try {
						if (webElementInternal.findElement(By.cssSelector("input[type='checkbox']")).isSelected())
						{
							webElementInternal.findElement(By.cssSelector("input[type='checkbox']")).sendKeys(Keys.SPACE);
							status=true;								
						}
									
					} catch (Exception e) {
						// TODO: handle exception
					}						
				}
			}

			if(status == true)
				break;
		}

		return status;
	}

}
