package us.tx.state.tea.seleniumfw;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class InternetExplorerDriverManager extends DriverManager {
    private InternetExplorerDriverService ieService;
    protected Logger log = Logger.getLogger(this.getClass().getName());
    public static final String baseDir = System.getProperties().get("basedir") + "\\src\\test";
    public static final String resPath = "\\resources"; 
    
    @Override
    public void startService() {
        if (ieService == null) {
            try {
                ieService = new InternetExplorerDriverService.Builder().usingDriverExecutable(new File(baseDir + resPath + "\\IEDriverServer.exe"))
                    .usingAnyFreePort()
                    .build();
                    
                ieService.start();
            }
            catch(IOException e) {
                log.error(e.getMessage());
            }
        }
    }
    
    @Override
    public void startService(String basePath) {
        if (ieService == null) {
            try {
                ieService = new InternetExplorerDriverService.Builder().usingDriverExecutable(new File(basePath + resPath + "\\IEDriverServer.exe"))
                    .usingAnyFreePort()
                    .build();
                    
                ieService.start();
            }
            catch(IOException e) {
                log.error(e.getMessage());
            }
        }
    }
    
    @Override
    public void stopService() {
        if (ieService != null && ieService.isRunning())
            ieService.stop();
    }
    
    public void createDriver() {
        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setCapability("EnableNativeEvents", false);          //Disable native events
        dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);  // Clear cache
        //dc.setCapability("nativeEvents",false);
        //dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        dc.setCapability("ignoreZoomSetting",true);             //Ignore Zoom level settings
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  // Issue with downloading the report
        dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        System.setProperty("webdriver.ie.driver", new File(baseDir + resPath + "\\IEDriverServer.exe").getAbsolutePath());
        driver = new InternetExplorerDriver(ieService,dc);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));  //Set zoom level to 100%
    }

	@Override
	protected void createRemoteDriver() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setCapability("EnableNativeEvents", false);          //Disable native events
        dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);  // Clear cache
        //dc.setCapability("nativeEvents",false);
        //dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        dc.setCapability("ignoreZoomSetting",true);             //Ignore Zoom level settings
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  // Issue with downloading the report
        dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        System.setProperty("webdriver.ie.driver", new File(baseDir + resPath + "\\IEDriverServer.exe").getAbsolutePath());
        driver = new RemoteWebDriver(new URL("http://tea4svviper:4444/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));  //
		
	}
	@Override
	protected void createDriver(String basePath) throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setCapability("EnableNativeEvents", false);          //Disable native events
        dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);  // Clear cache
        //dc.setCapability("nativeEvents",false);
        //dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        dc.setCapability("ignoreZoomSetting",true);             //Ignore Zoom level settings
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  // Issue with downloading the report
        dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        System.setProperty("webdriver.ie.driver", new File(basePath + resPath + "\\IEDriverServer.exe").getAbsolutePath());
        driver = new InternetExplorerDriver(ieService,dc);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));  //Set zoom level to 100%
		
	}
	@Override
	protected void createRemoteDriver(String basePath) throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setCapability("EnableNativeEvents", false);          //Disable native events
        dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);  // Clear cache
        //dc.setCapability("nativeEvents",false);
        //dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        dc.setCapability("ignoreZoomSetting",true);             //Ignore Zoom level settings
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  // Issue with downloading the report
        dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        System.setProperty("webdriver.ie.driver", new File(basePath + resPath + "\\IEDriverServer.exe").getAbsolutePath());
        driver = new RemoteWebDriver(new URL("http://tea4svviper:4444/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));  //Set zoom level to 100%
	}
    
}
