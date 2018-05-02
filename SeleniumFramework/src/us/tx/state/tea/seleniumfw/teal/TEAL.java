package us.tx.state.tea.seleniumfw.teal;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import us.tx.state.tea.seleniumfw.utils.ElementUtils;

public class TEAL {

	static public void loginTEAL(WebDriver driver, String url, String uid, String pwd)
	{
		driver.get(url);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/form/div[1]/div/span[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/form/div[1]/div/span[2]/input")).sendKeys(uid);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/form/div[1]/div[2]/span[2]/input")).clear();
        byte[] bytepwd = Base64.decodeBase64(pwd.getBytes());
        //driver.findElement(By.id("password")).sendKeys(new String(bytepwd));
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        try {
        	ElementUtils.waitForElement(driver, By.id("submit"), 2).click();
        } catch (TimeoutException te) {
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}
	
    static  public void logout(WebDriver driver) {
    	driver.findElement(By.linkText("Logout")).click();
    }
    
    public static void accessMyApplicationAccounts(WebDriver driver) {
    	driver.findElement(By.linkText("My Application Accounts")).click();
    }
    
    public static void addAccess(WebDriver driver, String appname) {
    	driver.switchTo().frame(driver.findElement(By.id("myAccounts-frame")));
    	driver.findElement(By.id("requestAccount")).click();
    	Actions action = new Actions(driver);
		WebElement app = driver.findElement(By.linkText(appname));
		action.moveToElement(app).build().perform();
    	driver.findElement(By.linkText(appname)).click();
    	driver.findElement(By.id("addButton")).click();
    }
    
    public static void addOrgId(WebDriver driver, String orgid) throws InterruptedException {
    	driver.findElement(By.id("eOrgNameSel")).sendKeys(orgid);
    	Thread.sleep(1000);
    	driver.findElement(By.id("eOrgNameSel")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    
    public static void selectRole(WebDriver driver, String index) {
    	String selectid = "selectedRole" + index;
    	Actions action = new Actions(driver);
		WebElement app = driver.findElement(By.id(selectid));
		action.moveToElement(app).build().perform();
		app.click();
    	//driver.findElement(By.id(selectid)).click();
    }
	
    public static void enterRoleOrg(WebDriver driver, String role, String orgid) throws InterruptedException {
    	String selectid = role + "--reqorgid";
    	Actions action = new Actions(driver);
		WebElement app = driver.findElement(By.id(selectid));
		action.moveToElement(app).build().perform();
    	driver.findElement(By.id(selectid)).sendKeys(orgid);
    	Thread.sleep(1000);
    	driver.findElement(By.id(selectid)).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    
    public static void addAccessList(WebDriver driver) {
    	driver.findElement(By.id("addAccessListButton")).click();
    }
    
    public static void saveChanges(WebDriver driver) {
    	driver.findElement(By.id("submitButton")).click();
    	driver.switchTo().defaultContent();
    }
    
	static public void openPortalPage(WebDriver driver, String appname)
	{	
		accessApplicationByHref(driver, appname);
		//ElementUtils.waitForElement(driver, By.xpath("//*[@id=\"iamLinksAccordion\"]/div[2]/div[3]/a/i/i"), 60).click();
	}
	
	static public void accesslogin(WebDriver driver) {
    	driver.findElement(By.linkText("Log In")).click();
    }
	
	static public void accessApplicationByHref(WebDriver driver, String appname) {
    	//new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.id("shadowBox")));
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();
 
        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(appname) && anchor.getAttribute("href").contains("ApplicationServlet")) {
            	System.out.println(anchor.getAttribute("href").toString());
                anchor.click();
                break;
            }
        }
        
    }
	
	static public boolean addModifyAccessByHref(WebDriver driver, String appname) {
		boolean accessToModify = false;
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();
        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(appname) && anchor.getAttribute("href").contains("Edit Account")) {
            	System.out.println("Clicking anchor");
            	accessToModify = true;
                anchor.click();
                break;
            }
        }
        return accessToModify;
    }
	
	public static void removeAllAccess(WebDriver driver) throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.id("editTSDSPortalAccount-frame")));
		WebElement tableid = driver.findElement(By.id("assignedList"));
		List<WebElement> rows = tableid.findElements(By.tagName("tr"));
		for (int i = 1; i<rows.size(); i++) {
			rows.get(i).click();
			driver.findElement(By.id("removeButton")).click();
			if (ElementUtils.isElementExist("userRoleList", driver)) {
				WebElement roletableid = driver.findElement(By.id("userRoleList"));
				List<WebElement> rolerows = roletableid.findElements(By.tagName("tr"));
				for (int j = 1; j < rolerows.size(); j++) {
					rolerows.get(j).findElements(By.tagName("td")).get(0).findElement(By.tagName("input")).click();
				}
				driver.findElement(By.id("removeRoleButton")).click();
			}
			driver.switchTo().alert().accept();
		}
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
}
