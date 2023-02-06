package com.genericfunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.entity.FrameworkEntities;

public class LoadPropertyfile 
{
	public static FrameworkEntities entity_obj;
	public static Properties pro_obj;
	static FileInputStream inputstream;
	
	public static FrameworkEntities loadconfigProperties()
	{
		pro_obj = new Properties();
		entity_obj = new FrameworkEntities();
		entity_obj.setPath(System.getProperty(CommonEnumConstants.USERDIRECTORY.getValue()));
		try {
			inputstream = new FileInputStream(entity_obj.getPath().toString()+"//"+"Config"+"//"+"config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pro_obj.load(inputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entity_obj.setBrowserName(pro_obj.getProperty("BROWSER"));
		entity_obj.setUrl(pro_obj.getProperty("URL"));
		return entity_obj;
	}
}
