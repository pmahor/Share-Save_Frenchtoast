package com.immply.readproperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadProperties {
	static FileInputStream in;
	static Properties prop;


	public static Properties Read(){
		try {
			in = new FileInputStream("D:\\Pankaj BACKUP\\Selenium\\Workspace\\Share_And_Save(French Toast)\\Configure.Properties");
			prop = new Properties();
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	} 

}










