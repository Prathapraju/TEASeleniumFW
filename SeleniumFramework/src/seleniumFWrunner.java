import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import us.tx.state.tea.seleniumfw.SeleniumWebDriver;
import us.tx.state.tea.seleniumfw.accessibility.AccessibilityAXEUtils;
import us.tx.state.tea.seleniumfw.teal.TEAL;
import us.tx.state.tea.seleniumfw.tsdsportal.TSDSPortal;
import us.tx.state.tea.seleniumfw.utils.PageUtils;

public class seleniumFWrunner {

	static String appName = "tsds";
	static String typeBrowser="CHROME";
	//static String typeBrowser="FIREFOX";
	//static String url = "https://tealint.tea.state.tx.us";
	static String url="https://tealtst.tea.state.tx.us";
	static String teaseURL = "https://tea4svwest.tea.state.tx.us/apps/app_list.asp";

	//static String driverLocation = "C:\\TEA\\WebDrivers\\chromedriver.exe";
	//static String driverLocation = "C:\\TEA\\WebDrivers\\geckodriver.exe";
	static String driverLocation = "C:\\Users\\praju\\Downloads\\chrome Driver\\chromedriver_win32\\chromedriver.exe";
	//static String tealUid = "multidistrict.peimsuser";
	//static String tealPwd = "h$|=+d6$1";
	static String tealUid = "TSDSRegression.UIDStAdmin";
	static String tealPwd = "Test!2345$";

	static String teaseUid = "Itadmin1";
	static String teasePwd = "Itadmin1";

	static String projecteGrants = "eGrants";
	static String projecteTSDSPEIMS = "PEIMS";

	static WebDriver driver = null;

	static Map<String, List<String>> menuSBmenus = new LinkedHashMap<String, List<String>>();

	private static final URL scriptUrl = seleniumFWrunner.class.getResource("/axe.min.js");

	public static void main(String[] args) throws JsonParseException, JsonMappingException, JSONException, IOException, InterruptedException {		

		Map<String, Object> audit_report = null;

		menuSBmenus.put("Data Promotions", new ArrayList<>(Arrays.asList("Promote Loaded Data", "Monitor Data Promotions")));
		menuSBmenus.put("Validations", new ArrayList<>(Arrays.asList("Validate Submission Data", "Monitor Data Validations ","Validation Rules Count")));
		menuSBmenus.put("Access Data", new ArrayList<>(Arrays.asList("Data Element Summary", "Search Submission Data", "Search Student Roster","Retrieve Submission Data","Monitor Submission Retrievals")));

		//https://tealint.tea.state.tx.us
		//multidistrict.peimsuser
		//h$|=+d6$

		switch (typeBrowser) {
		case "CHROME":
			System.setProperty(SeleniumWebDriver.CHROME.getType(),driverLocation);
			driver = new ChromeDriver();
			break;

		case "FIREFOX":
			System.setProperty(SeleniumWebDriver.FIREFOX.getType(),driverLocation);
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
		try {


			driver.manage().window().maximize();

			//http://lcastano.tea.state.tx.us/TEA.eGrantsApp.Web/

			//projecteGrants = "eGrantsApplication";
			//eGrantsApplication.loginLocaleGrants(driver, "http://tea4svdusky.tea.state.tx.us/TEA.eGrantsApp.Web/", teaseUid, teasePwd);
			//eGrantsApplication.loginLocaleGrants(driver, "http://ajaramil.tea.state.tx.us/TEA.eGrantsApp.Web/", teaseUid, teasePwd);
			//eGrantsApplication.setWait_time(3);
			////		
			////		run508AccessibilityTest();
			////		
			//eGrantsApplication.searchGranteeProfileByDistrict(driver, "061902");
			
			//menuSBmenus.put("Compliance Reports:New", new ArrayList<>(Arrays.asList("")));
			//menuSBmenus.put("Grants:New", new ArrayList<>(Arrays.asList("All Grants", "Start a Grant","Draft Grants","Negotiation of Grants", "Submitted Grants", "Awarded Grants")));
			//menuSBmenus.put("Special Collections:New", new ArrayList<>(Arrays.asList("")));
			//menuSBmenus.put("Document Library:New", new ArrayList<>(Arrays.asList("")));
			//menuSBmenus.put("Competitive Scoring:New", new ArrayList<>(Arrays.asList("")));
			//menuSBmenus.put("Manage eGrants:Legacy", new ArrayList<>(Arrays.asList("TEA Calendar", "New Form/Template","Template Definition","Manage Forms", "Data Import", "Report Admin Add", 
			//								"Report Admin Relationship", "Generate Data Elements", "Grant Application Administration", "Allocation Setup", "Documentation Setup", 
			//								"Form Relationship Setup", "Eligible Applicant Setup")));
			//menuSBmenus.put("Reports:New", new ArrayList<>(Arrays.asList("")));

			
//			for (String menu : menuSBmenus.keySet()) {				
//				for (String sbmenu : menuSBmenus.get(menu)) {
//
//					try {
//				
//						eGrantsApplication.selectMenuOption(driver, menu.split(":")[0], sbmenu);
//
//						if("Legacy".equalsIgnoreCase(menu.split(":")[1])) {
//							PageUtils.clickBackButton(driver);
//						}
//						//run508AccessibilityTest();
//
//					} catch (Exception e) {
//						// TODO: handle exception
//						System.out.println(menu + "\"" + sbmenu +" not available " + e.getMessage());
//					}
//				}
//			}
//			
			//eGrantsApplication.selectMenuOption(driver, "Grants" ,"All Grants");

			//eGrantsApplication.openGrantByName(driver, "2017-2018 ESSA Consolidated Federal Grant Application");

			//eGrantsApplication.openItemGrantApplicationTableofContent(driver, "ESSA Consolidated Federal Grant Application");

			//List<String> listOfSchedules = new ArrayList<String>(Arrays.asList("GS2100","GS2300","PS3001","PS3099","PS3101","PS3104","PS3106","PS3109","PS3400"));
			//"PS3102","PS3107",
			
//			for (String schedule : listOfSchedules) {
//				System.out.println(schedule);
//				if(eGrantsApplication.openScheduleById(driver, schedule))
//					run508AccessibilityTest("ESSA" + schedule);	
//				else
//					System.out.println("Page not working");
//				
//				PageUtils.clickBackButton(driver);
//			}

			//eGrantsApplication.selectMenuOption(driver, "Special Collections",null);

			//		projecteGrants = "eGrantsLegacyApplication";		
			//		TEASE.loginTEASE(driver, teaseURL, teaseUid, teasePwd);
			//		TEASE.openeGrantsDevPage(driver);
			//		eGrantsApplicationLegacy.searchGranteeProfileByDistrict(driver, "061902");
			//		
			//		// Grant
			//		
			//		eGrantsApplicationLegacy.openGrantApplicationNCLBConsolidatedFederalGrantApplication(driver);
			//	
			//		run508AccessibilityTest();
			//		
			//		// Grant Schedules
			//		
			//		List<String> listOfSchedules = new ArrayList<String>(Arrays.asList("GS2100","GS2300","PS3101","PS3104","PS3105","PS3106","PS3107","PS3108","PS3109","PS3211","PS3221","PS3231","PS3241","PS3400"));
			//		
			//		// Run full Grant accessibility test
			//		
			//		for (String schedule : listOfSchedules) {
			//			eGrantsUtils.openScheduleById(driver, schedule);
			//			run508AccessibilityTest();			
			//			PageUtils.clickBackButton(driver);
			//		}


					TEAL.loginTEAL(driver, url, tealUid,tealPwd);
			//		
			//		
					TEAL.openPortalPage(driver, appName);
			//		
					TSDSPortal.selectOrg(driver, "079907");
					TSDSPortal.goPEIMSTab(driver);
					TSDSPortal.openApplication(driver, "PEIMS", "TSDS: PEIMS");
			//		
			//		run508AccessibilityTest();
			////			
//					for (String menu : menuSBmenus.keySet()) {
//						for (String sbmenu : menuSBmenus.get(menu)) {
//											
//							try {
//								TSDSPeims.selectMenuOption(driver, menu, sbmenu);
//									
//			//					run508AccessibilityTest();
//			//		
//							} catch (Exception e) {
//								// TODO: handle exception
//								System.out.println(menu + "\"" + sbmenu +" not available " + e.getMessage());
//							}
//						}
//					}
			//		
					
			//TSDSPeims.changePEIMSCollection(driver, collectionId, sync);
			
			

			//driver.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("TEST Failed: " + e.getMessage());
			//driver.close();
		}

	}

	private static void run508AccessibilityTest() throws JsonParseException, JsonMappingException, JSONException, IOException, InterruptedException
	{
		JSONObject responseJSON = AccessibilityAXEUtils.runAccessibilityAXE(driver, scriptUrl);

		AccessibilityAXEUtils.writeAccessibilityResults("C:\\TEA\\AccessibilityScreenShots\\", projecteGrants, driver.getTitle(), responseJSON);
		AccessibilityAXEUtils.decorateElements(driver,responseJSON);		
		PageUtils.getScreenShot(driver, "C:\\TEA\\AccessibilityScreenShots\\", projecteGrants, driver.getTitle(), true);

	}
	
	private static void run508AccessibilityTest(String filename) throws JsonParseException, JsonMappingException, JSONException, IOException, InterruptedException
	{
		JSONObject responseJSON = AccessibilityAXEUtils.runAccessibilityAXE(driver, scriptUrl);

		AccessibilityAXEUtils.writeAccessibilityResults("C:\\TEA\\AccessibilityScreenShots\\", projecteGrants, filename, responseJSON);
		AccessibilityAXEUtils.decorateElements(driver,responseJSON);		
		PageUtils.getScreenShot(driver, "C:\\TEA\\AccessibilityScreenShots\\", projecteGrants, filename, true);

	}

}
