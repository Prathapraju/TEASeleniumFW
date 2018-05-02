/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.tx.state.tea.seleniumfw;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class FirefoxDriverManager extends DriverManager {
    //Using Firefox version 54.0 and geckodriver 16.0 32 bit
    public static final String baseDir = System.getProperties().get("basedir") + "\\src\\test";
    public static final String resPath = "\\resources";
    public static final String Path_FileDownload = "\\resources\\downloads\\";
    
    @Override
    public void startService() {
       //Not needed for firefox
    }
    
    @Override
    public void stopService() {
       //Not needed for firefox
    }
    
    @Override
    public void createDriver() {
        FirefoxProfile profile = new FirefoxProfile();
        System.setProperty("webdriver.gecko.driver", new File(baseDir + resPath + "/geckodriver.exe").getAbsolutePath());
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        profile.setAcceptUntrustedCertificates(false);
        profile.setAssumeUntrustedCertificateIssuer(true);
        profile.setPreference("browser.download.dir", baseDir + Path_FileDownload);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        profile.setPreference("browser.helperApps.neverAsk.openFile","application/pdf");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf"); 
        profile.setPreference("pdfjs.disabled", true );
        dc.setCapability("marionette", true);
        dc.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(dc);
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1920, 1080)); // Work around for now. Will fix for FF 55.0
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

	@Override
	protected void startService(String baseDir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createRemoteDriver() throws MalformedURLException {
        FirefoxProfile profile = new FirefoxProfile();
        System.setProperty("webdriver.gecko.driver", new File(baseDir + resPath + "/geckodriver.exe").getAbsolutePath());
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        profile.setAcceptUntrustedCertificates(false);
        profile.setAssumeUntrustedCertificateIssuer(true);
        profile.setPreference("browser.download.dir", baseDir + Path_FileDownload);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        profile.setPreference("browser.helperApps.neverAsk.openFile","application/pdf");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf"); 
        profile.setPreference("pdfjs.disabled", true );
        dc.setCapability("marionette", true);
        dc.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new RemoteWebDriver(new URL("http://tea4svviper:4444/wd/hub"), dc);
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1920, 1080)); // Work around for now. Will fix for FF 55.0
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Override
	protected void createDriver(String basePath) throws MalformedURLException {
        FirefoxProfile profile = new FirefoxProfile();
        System.setProperty("webdriver.gecko.driver", new File(basePath + resPath + "/geckodriver.exe").getAbsolutePath());
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        profile.setAcceptUntrustedCertificates(false);
        profile.setAssumeUntrustedCertificateIssuer(true);
        profile.setPreference("browser.download.dir", basePath + Path_FileDownload);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        profile.setPreference("browser.helperApps.neverAsk.openFile","application/pdf");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf"); 
        profile.setPreference("pdfjs.disabled", true );
        dc.setCapability("marionette", true);
        dc.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(dc);
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1920, 1080)); // Work around for now. Will fix for FF 55.0
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Override
	protected void createRemoteDriver(String basePath) throws MalformedURLException {
        FirefoxProfile profile = new FirefoxProfile();
        System.setProperty("webdriver.gecko.driver", new File(basePath + resPath + "/geckodriver.exe").getAbsolutePath());
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        profile.setAcceptUntrustedCertificates(false);
        profile.setAssumeUntrustedCertificateIssuer(true);
        profile.setPreference("browser.download.dir", basePath + Path_FileDownload);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        profile.setPreference("browser.helperApps.neverAsk.openFile","application/pdf");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf"); 
        profile.setPreference("pdfjs.disabled", true );
        dc.setCapability("marionette", true);
        dc.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new RemoteWebDriver(new URL("http://tea4svviper:4444/wd/hub"), dc);
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1920, 1080)); // Work around for now. Will fix for FF 55.0
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
}
