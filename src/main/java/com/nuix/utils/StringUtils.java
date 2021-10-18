package com.nuix.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringUtils 
{
	@SuppressWarnings("unchecked")
	public static Map<String, String> getData(Object[] data) 
	{
		for(Object obj : data)
		{
			if(obj instanceof LinkedHashMap)
			{
				return (LinkedHashMap<String, String>)obj;
			}
		}
		
    	return null;
	}
}
