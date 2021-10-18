package com.nuix.utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.jayway.jsonpath.JsonPath;
import com.nuix.constants.AppConstants;

public class JsonUtils 
{
	@SuppressWarnings("unchecked")
	public static Object[][] readJson(String jsonFile, String rootTag) throws IOException
	{
		Object parsed = JsonPath.read(new File(jsonFile), rootTag);

		List<Object> parsedData = null;
		
		if (parsed instanceof List) 
		{
			parsedData = (List<Object>) parsed;
			
		} else 
		{
			parsedData = Arrays.asList(parsed);
		}
		
		Object object[][] = new Object[parsedData.size()][1];
		int index = 0;
		
		for (Object obj : parsedData) 
		{
			object[index][0] = obj;
			index++;
		}
		
		return object;
	}

	public static void main(String[] args) throws IOException 
	{
		Object[] parsedData = JsonUtils.readJson(AppConstants.TEST_DATA_FOLDER_PATH + "ExpediaAuthenticationTest.json", "$.expediaAuthenticationTest");
		System.out.println(parsedData);
	}
}
