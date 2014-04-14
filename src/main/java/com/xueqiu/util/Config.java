package com.xueqiu.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

	private static Properties props = new Properties(); 

    static{
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key){
		return props.getProperty(key);
	}
}
