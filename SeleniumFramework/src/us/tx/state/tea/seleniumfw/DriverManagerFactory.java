package us.tx.state.tea.seleniumfw;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType type) {
        DriverManager driverManager;
        
        switch(type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new InternetExplorerDriverManager();
                break;
        }
        return driverManager;
    }
}
