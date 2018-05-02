/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.tx.state.tea.seleniumfw;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void startService();
    protected abstract void startService(String baseDir);
    protected abstract void stopService();
    protected abstract void createDriver() throws MalformedURLException;
    protected abstract void createRemoteDriver()  throws MalformedURLException;
    protected abstract void createDriver(String baseDir) throws MalformedURLException;
    protected abstract void createRemoteDriver(String baseDir)  throws MalformedURLException;
    
    public void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
    public WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            startService();
            createDriver();
        }
        return driver;
    }
    
    public WebDriver getDriver(String baseDir) throws MalformedURLException {
        if (driver == null) {
        	startService(baseDir);
            createDriver(baseDir);
        }
        return driver;
    }
    
    public WebDriver getRemoteDriver() throws MalformedURLException {
        if (driver == null) {
            startService();
            createRemoteDriver();
        }
        return driver;
    }
    
    public WebDriver getRemoteDriver(String baseDir) throws MalformedURLException {
        if (driver == null) {
            startService(baseDir);
            createRemoteDriver(baseDir);
        }
        return driver;
    }
    
}
