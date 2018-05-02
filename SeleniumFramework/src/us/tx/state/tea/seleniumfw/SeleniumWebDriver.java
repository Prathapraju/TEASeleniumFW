package us.tx.state.tea.seleniumfw;

public enum SeleniumWebDriver {
	CHROME("webdriver.chrome.driver",""),
	IE("webdriver.ie.driver",""),
	FIREFOX("webdriver.gecko.driver",""),
	EDGE("webdriver.edge.driver","");
	

	private String url;
	private String type;

	SeleniumWebDriver(String type, String url) {
		this.type = type;
        this.url = url;
    }

	public String getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}
    
}
