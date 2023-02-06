package com.objectrepository;

import java.io.FileInputStream;

import com.genericfunctions.BrowserFunctions;
import com.genericfunctions.CommonEnumConstants;
import com.genericfunctions.LoadPropertyfile;

public class Objects {
public static Objects obj;
public static void getOR() throws Exception
{
	FileInputStream objfile = new FileInputStream(BrowserFunctions.USERDIR+CommonEnumConstants.OBJECTREPOSITORYPATH.getValue());
	LoadPropertyfile.pro_obj.load(objfile);
}
}
