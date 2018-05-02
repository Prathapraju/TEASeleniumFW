package us.tx.state.tea.seleniumfw.accessibility;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.deque.axe.AXE;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import us.tx.state.tea.seleniumfw.accessibility.model.SeleniunFWAxeNode;
import us.tx.state.tea.seleniumfw.accessibility.model.SeleniunFWAxeValidation;


public class AccessibilityAXEUtils {
	

	static public JSONObject runAccessibilityAXE(WebDriver driver, URL scriptUrl)
	{
		JSONObject responseJSON = new AXE.Builder(driver, scriptUrl)
				.options("{ configure: { reporter: 'v2' }, runOnly: { tag: ['wcag2a', 'wcag2aa', 'section508','experimental','best-practice'] }, xpath: { enabled: true } }")
				.analyze();

		return responseJSON;
	}

	static public void writeAccessibilityResults(final String fileLocation, final String project, final String fileName, final JSONObject output)
	{
		AXE.writeResults(fileLocation + project + "-" + fileName + "_passes", output.getJSONArray("passes"));
		AXE.writeResults(fileLocation + project + "-" + fileName + "_violations", output.getJSONArray("violations"));
		AXE.writeResults(fileLocation + project + "-" + fileName + "_inapplicable", output.getJSONArray("inapplicable"));
		AXE.writeResults(fileLocation + project + "-" + fileName + "_incomplete", output.getJSONArray("incomplete"));
	}

	@SuppressWarnings("deprecation")
	public static void decorateElements(WebDriver driver, JSONObject results) throws JsonParseException, JsonMappingException, JSONException, IOException {

		List<SeleniunFWAxeValidation> listOfErrors = AccessibilityMapAxeJSONToModel.getListofValidations(results.getJSONArray("violations"));

		String color = null;
		for (SeleniunFWAxeValidation result : listOfErrors) {
			switch (result.getImpact()) {
			case "critical":
				color = "red";
				break;
			case "serious":
				color = "orange";
				break;

			case "moderate":
				color="yellow";
				break;
			case "minor":
				color="blue";
				break;
			default:
				break;
			}
			List<SeleniunFWAxeNode> nodes = result.getNodes();
			for (SeleniunFWAxeNode node : nodes) {
				WebElement elem = driver.findElement(By.xpath("/" + node.getXpath().get(0)));
				// draw a border around the found element
				if (driver instanceof JavascriptExecutor) {
					((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid "+color+"'", elem);
					((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('title', '"+result.getHelp()+ "')", elem);	
				}
			}			
		}



	}

}
