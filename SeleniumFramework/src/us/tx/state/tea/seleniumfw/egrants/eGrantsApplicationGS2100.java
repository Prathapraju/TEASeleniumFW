package us.tx.state.tea.seleniumfw.egrants;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import us.tx.state.tea.seleniumfw.utils.ElementUtils;

public class eGrantsApplicationGS2100 {
	
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
	
	public static WebElement getSchedulePartSectionByName(WebElement element, String section)
	{
		WebElement internalElement = null;
		
		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));
		
		for (WebElement webElement : allSpanChildElements) {	
			List<WebElement> allSpanChildElementsInternal = webElement.findElements(By.xpath("*"));
			for (WebElement webElementInternal : allSpanChildElementsInternal) {	
				if(webElementInternal.getText().contains(section))
				{		
					internalElement = webElementInternal;
					break;		
				}
			}
			if(null != internalElement)
				break;
		}
		
		return internalElement;
	}
	
	public static boolean verifySchedulePartSectionFieldByName(WebElement element, String fieldName)
	{
		boolean found = false;
		
		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));
		
		for (WebElement webElement : allSpanChildElements) {							
			if(webElement.getText().contains(fieldName))
			{		
				found = true;
				break;		
			}
		}
		
		
		return found;
	}
	
	public static boolean verifySchedulePartSectionFieldValue(WebElement element, String value)
	{
		boolean found = false;
		
		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));
		
		for (WebElement webElement : allSpanChildElements) {							
			if(webElement.getText().contains(value))
			{		
				found = true;
				break;		
			}
		}
		
		
		return found;
	}
	
	public static WebElement getSchedulePartSectionFieldByName(WebElement element, String fieldName)
	{	
		WebElement internalElement = null;
		
		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));
		
		for (WebElement webElement : allSpanChildElements) {	
			List<WebElement> allSpanChildElementsInternal = webElement.findElements(By.cssSelector("[class*=sectionHeaderContent]"));
			for (WebElement webElementInternal : allSpanChildElementsInternal) {	
				if(webElementInternal.getText().contains(fieldName))
				{		
					internalElement = webElementInternal;
					break;		
				}
			}
			if(null != internalElement)
				break;
		}
		
		return internalElement;
	}
	
}
