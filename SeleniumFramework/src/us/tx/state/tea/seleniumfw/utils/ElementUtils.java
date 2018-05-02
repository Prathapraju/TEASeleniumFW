package us.tx.state.tea.seleniumfw.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementUtils {

	public enum fieldType {
		INPUTFIELD,
		CHECKBOX,
		SELECT;
	}

	//Lambda loop function
	public static Consumer<WebElement> cleanInputElements = new Consumer<WebElement>() {
		public void accept(WebElement element) {
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
		}	 
	};

	public static Consumer<WebElement> cleanCheckboxeElements = new Consumer<WebElement>() {
		public void accept(WebElement element) {
			if (element.isSelected())
			{
				element.sendKeys(Keys.SPACE);											
			}
		}
	};

	public static Consumer<WebElement> cleanDropdownElements = new Consumer<WebElement>() {
		public void accept(WebElement element) {
			Select selectElement = new Select(element);
			selectElement.selectByIndex(0);
		}
	};


	public static boolean isElementExist(String id, WebDriver driver) {
		boolean exists = false;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			driver.findElement(By.id(id));
			exists = true;

		}
		catch (NoSuchElementException e) {}
		return exists;
	} 

	public static WebElement waitForElement(WebDriver driver,By by, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}

	public static List<WebElement> waitForElements(WebDriver driver,By by, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));			
		return elements;
	}

	public static boolean verifyElementType(WebElement element, String type)
	{
		boolean status = false;

		try {
			element.findElement(By.tagName(type));
			status = true;
		} catch (Exception e) {

		}

		return status;
	}
	
	public static boolean IsPresentandDisplayed(WebDriver driver, By by) {
    	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    	try {
    		driver.findElement(by);
    	} catch (NoSuchElementException e) {
    		return false;
    	}
    	return driver.findElement(by).isDisplayed();
    }

	public static boolean isElementTypeAvailable(WebElement element, String tag, String type)
	{
		boolean status = false;

		try {
			element.findElement(By.cssSelector(tag + "[type='"+type+"']"));
			status = true;
		} catch (Exception e) {

		}

		return status;
	}

	public static void cleanTextField(WebElement element, String id)
	{
		element.findElement(By.xpath("//*[contains(@id,'"+id+"')]")).sendKeys(Keys.CONTROL + "a");
		element.findElement(By.xpath("//*[contains(@id,'"+id+"')]")).sendKeys(Keys.DELETE);
	}

	public static boolean isLinkExist(String id, WebDriver driver) {
		boolean exists = false;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			driver.findElement(By.linkText(id));
			exists = true;

		}
		catch (NoSuchElementException e) {}
		return exists;
	} 

	public static void cleanAllElementsPage(WebDriver driver, By xPath, fieldType type)
	{

		List<WebElement> allInternalChildElements = null;

		allInternalChildElements = driver.findElements(xPath);

		// Clean Fields
		if(null!=allInternalChildElements && allInternalChildElements.size() > 0)
		{
			switch (type) {
			case INPUTFIELD:
				allInternalChildElements.forEach(cleanInputElements);	
				break;

			case CHECKBOX:
				allInternalChildElements.forEach(cleanCheckboxeElements);	
				break;

			case SELECT:
				allInternalChildElements.forEach(cleanDropdownElements);	
				break;

			default:
				break;
			}

		}
	}

	public static void setTextFieldData(WebElement element, String id, String value)
	{	
		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {	
			try {
				ElementUtils.cleanTextField(webElement,id);
				webElement.findElement(By.xpath("//*[contains(@id,'"+id+"')]")).sendKeys(value);				
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static String getTextFieldData(WebElement element, String id)
	{	
		String elementValue = null;
		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {	
			try {	
				elementValue = webElement.findElement(By.xpath("//*[contains(@id,'"+id+"')]")).getAttribute("value");				
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return elementValue;
	}

	public static void setSelectFieldDataByIndex(WebElement element, String id, int index)
	{	
		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {	
			try {
				Select selectElement = new Select(webElement.findElement(By.xpath("//*[contains(@id,'"+id+"')]")));
				selectElement.selectByIndex(index);			
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void setSelectFieldDataByValue(WebElement element, String id, String value)
	{	
		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {	
			try {
				Select selectElement = new Select(webElement.findElement(By.xpath("//*[contains(@id,'"+id+"')]")));
				selectElement.selectByValue(value);	

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void checkCheckboxField(WebElement element, String id)
	{	
		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {	
			try {
				if (!webElement.findElement(By.xpath("//*[contains(@id,'"+id+"')]")).isSelected())
				{
					webElement.findElement(By.xpath("//*[contains(@id,'"+id+"')]")).sendKeys(Keys.SPACE);														
					break;
				}		
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void unCheckCheckboxField(WebElement element, String id)
	{	
		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {	
			try {
				if (webElement.findElement(By.xpath("//*[contains(@id,'"+id+"')]")).isSelected())
				{
					webElement.findElement(By.xpath("//*[contains(@id,'"+id+"')]")).sendKeys(Keys.SPACE);														
					break;
				}		
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static boolean isCheckCheckboxFieldChecked(WebElement element, String id)
	{	
		boolean status = false;
		List<WebElement> allSpanChildElements = element.findElements(By.xpath("*"));

		for (WebElement webElement : allSpanChildElements) {	
			try {
				if (webElement.findElement(By.xpath("//*[contains(@id,'"+id+"')]")).isSelected())
				{
					status = true;													
					break;
				}		
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return status;
	}
	
    public static boolean isElementPresent(WebDriver driver, By by) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
         driver.findElement(by);
         return true;
        } catch (NoSuchElementException e) {
         return false;
        }
  }
	
	
	public static String cleanTextQuotes(String text)
	{
		return text.replace("‘","").replace("’","");
	}
	
	public static String cleanTextDollarSigns(String text)
	{
		return text.replace("$", "").replace(",", "");
	}
	
    public static boolean clickAndRetry(WebDriver driver, By by) throws Exception{
        boolean found = false;
        int cnt = 0;
        while(cnt < 3) {
            try {
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                driver.findElement(by).click();
                
                found = true;
            }
            catch(StaleElementReferenceException | NoSuchElementException e){break;}
            Thread.sleep(1000);
            cnt++;
        }
        return found;
    }
    
    public static void clickAnElementById(WebDriver driver, String id) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        ele.click();
    }
}

