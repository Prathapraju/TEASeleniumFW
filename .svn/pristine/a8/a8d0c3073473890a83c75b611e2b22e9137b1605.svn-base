package us.tx.state.tea.seleniumfw.utils;

import java.io.IOException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import us.tx.state.tea.seleniumfw.accessibility.AccessibilityAXEUtils;

public class AccessibilityUtils {
//	public static void run508AccessibilityTest(WebDriver driver, URL scriptUrl, String project) throws JsonParseException, JsonMappingException, JSONException, IOException, InterruptedException
//	{
//		JSONObject responseJSON = AccessibilityAXEUtils.runAccessibilityAXE(driver, scriptUrl);
//
//		AccessibilityAXEUtils.writeAccessibilityResults("C:\\TEA\\AccessibilityScreenShots\\", project, driver.getTitle(), responseJSON);
//		AccessibilityAXEUtils.decorateElements(driver,responseJSON);		
//		PageUtils.getScreenShot(driver, "C:\\TEA\\AccessibilityScreenShots\\", project, driver.getTitle(), true);
//
//	}
//	
//	public static void run508AccessibilityTest(WebDriver driver, URL scriptUrl, String project, String filename) throws JsonParseException, JsonMappingException, JSONException, IOException, InterruptedException
//	{
//		JSONObject responseJSON = AccessibilityAXEUtils.runAccessibilityAXE(driver, scriptUrl);
//
//		AccessibilityAXEUtils.writeAccessibilityResults("C:\\TEA\\AccessibilityScreenShots\\", project, filename, responseJSON);
//		AccessibilityAXEUtils.decorateElements(driver,responseJSON);		
//		PageUtils.getScreenShot(driver, "C:\\TEA\\AccessibilityScreenShots\\", project, filename, true);
//
//	}
	
	public static void run508AccessibilityTest(WebDriver driver, URL scriptUrl, String location, String project, String filename) throws JsonParseException, JsonMappingException, JSONException, IOException, InterruptedException
	{
		JSONObject responseJSON = AccessibilityAXEUtils.runAccessibilityAXE(driver, scriptUrl);

		AccessibilityAXEUtils.writeAccessibilityResults(location, project, filename, responseJSON);
		AccessibilityAXEUtils.decorateElements(driver,responseJSON);		
		PageUtils.getScreenShot(driver, location, project, filename, true);

	}
}
