package us.tx.state.tea.seleniumfw.egrants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import us.tx.state.tea.seleniumfw.utils.ElementUtils;
import us.tx.state.tea.seleniumfw.utils.ElementUtils.fieldType;

public class eGrantsApplicationSC5000 {


	
	public static void cleanAllElementsPage(WebDriver driver)
	{
		
		ElementUtils.cleanAllElementsPage(driver, By.xpath("//input[contains(@class,'NumberInput') and not(contains(@class,'input--disabled'))]"), fieldType.INPUTFIELD);
		ElementUtils.cleanAllElementsPage(driver, By.xpath("//input[@type='checkbox' and not(contains(@class,'input--disabled'))]"), fieldType.CHECKBOX);
		ElementUtils.cleanAllElementsPage(driver, By.xpath("//select[contains(@class,'width100') and not(contains(@class,'input--disabled'))]"), fieldType.SELECT);
									
	}
		
}
