package us.tx.state.tea.seleniumfw.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtils {
	
	protected Logger log = Logger.getLogger(this.getClass().getName());
	
	public Properties loadProperitiesFrom(String path)
	{
		Properties configProp = null;
					
		try {
			final FileInputStream in = new FileInputStream( path );
			
			configProp = new Properties();
			configProp.load(in);
		} catch (IOException e) {
			log.error("Error loading the properties",e);
			e.printStackTrace();
		}
		
		return configProp;
	}

}
