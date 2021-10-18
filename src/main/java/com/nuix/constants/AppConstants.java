package com.nuix.constants;

import java.util.Hashtable;

import com.nuix.utils.PropertiesUtil;

public interface AppConstants 
{
	Hashtable<String, String> CONFIG_PROPERTIES = PropertiesUtil.getPropertiesAsHashtable("./resources/Config.properties");

	String TEST_DATA_FOLDER_PATH = CONFIG_PROPERTIES.get("test_Data_Folder_Path");
	String RESULTS_FOLDER_PATH = CONFIG_PROPERTIES.get("results_Folder_Path");
	
	String BLANK = "#BLANK#";
	
	//Selenium Test
	String CHROME_DRIVER = "webdriver.chrome.driver";
	String CHROME_DRIVER_PATH = CONFIG_PROPERTIES.get("chrome_Driver_Path");
	String APP_URL = CONFIG_PROPERTIES.get("app_url");

}
