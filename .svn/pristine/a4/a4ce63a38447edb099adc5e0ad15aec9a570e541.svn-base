package us.tx.state.tea.seleniumfw.fsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FSPProgramInfoPage {
	public WebDriver driver;
	
	public FSPProgramInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void updateCalenderData(String appname) {
		WebElement tableid = driver.findElement(By.id("ctl00_Body_announcementsGridView"));
		for(WebElement row: tableid.findElements(By.tagName("tr"))) {
			if(row.getText().contains(appname)) {
				WebElement linkname = row.findElement(By.linkText("Edit"));
				linkname.click();
			}
		}
		(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return driver.getTitle().equals("Foundation School Program");   
            }
            });
		driver.findElement(By.id("ctl00$Body$TxtDisplayDate")).clear();
		driver.findElement(By.id("ctl00$Body$TxtDisplayDate")).sendKeys("");
		driver.findElement(By.id("ctl00$Body$TxtExpireDate")).clear();
		driver.findElement(By.id("ctl00$Body$TxtExpireDate")).sendKeys("");
		driver.findElement(By.id("ctl00_Body_BtnAddAnnouncement")).click();
	}
}
