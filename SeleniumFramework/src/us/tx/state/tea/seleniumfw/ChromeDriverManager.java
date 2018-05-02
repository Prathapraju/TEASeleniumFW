/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.tx.state.tea.seleniumfw;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ChromeDriverManager extends DriverManager {
    //ChromeDriver version 2.31
    private ChromeDriverService chService;
    protected Logger log = Logger.getLogger(this.getClass().getName());
    public static final String baseDir = System.getProperties().get("basedir") + "\\src\\test";
    public static final String resPath = "\\resources"; 
    public static final String Path_FileDownload = "\\resources\\downloads\\";
    
    @Override
    public void startService() {
        if (chService == null) {
            try {
                chService = new ChromeDriverService.Builder()
                        .usingAnyFreePort()
                        .usingDriverExecutable(new File(baseDir + resPath + "\\chromedriver.exe"))
                        .build();
                chService.start(); 
               
            }
            catch(IOException e) {
                log.error(e.getMessage());
            }
        } 
    }
    
    @Override
    public void startService(String basePath) {
        if (chService == null) {
            try {
                chService = new ChromeDriverService.Builder()
                        .usingAnyFreePort()
                        .usingDriverExecutable(new File(basePath + resPath + "\\chromedriver.exe"))
                        .build();
                chService.start(); 
               
            }
            catch(IOException e) {
                log.error(e.getMessage());
            }
        } 
    }
    
    @Override
    public void stopService() {
        if (chService != null && chService.isRunning())
            chService.stop();
    }
    
    @Override
    public void createRemoteDriver(String basePath) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver",new File(basePath + resPath + "\\chromedriver.exe").toString());
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("safebrowsing.enabled", "false");
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", basePath + Path_FileDownload);
        chromePrefs.put("disable-extensions", "true");
        chromePrefs.put("pdfjs.disabled", true);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("plugins.plugins_disabled", new String[] {
        	    "Adobe Flash Player",
        	    "Chrome PDF Viewer"
        	});
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL("http://tea4svviper:4444/wd/hub"), cap);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @Override
    public void createDriver(String basePath) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver",new File(basePath + resPath + "\\chromedriver.exe").toString());
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("safebrowsing.enabled", "false");
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", basePath + Path_FileDownload);
        chromePrefs.put("disable-extensions", "true");
        chromePrefs.put("pdfjs.disabled", true);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("plugins.plugins_disabled", new String[] {
        	    "Adobe Flash Player",
        	    "Chrome PDF Viewer"
        	});
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(cap);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @Override
    public void createRemoteDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver",new File(baseDir + resPath + "\\chromedriver.exe").toString());
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("safebrowsing.enabled", "false");
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", baseDir + Path_FileDownload);
        chromePrefs.put("disable-extensions", "true");
        chromePrefs.put("pdfjs.disabled", true);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("plugins.plugins_disabled", new String[] {
        	    "Adobe Flash Player",
        	    "Chrome PDF Viewer"
        	});
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL("http://tea4svviper:4444/wd/hub"), cap);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @Override
    public void createDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver",new File(baseDir + resPath + "\\chromedriver.exe").toString());
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("safebrowsing.enabled", "false");
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", baseDir + Path_FileDownload);
        chromePrefs.put("disable-extensions", "true");
        chromePrefs.put("pdfjs.disabled", true);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("plugins.plugins_disabled", new String[] {
        	    "Adobe Flash Player",
        	    "Chrome PDF Viewer"
        	});
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(cap);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
}
