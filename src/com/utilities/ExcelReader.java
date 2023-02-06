package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.genericfunctions.BrowserFunctions;
import com.genericfunctions.CommonEnumConstants;

public class ExcelReader {

	public static List<HashMap<String,String>> readExcelData(String filePath,String sheetName) throws IOException
	{
		List<HashMap<String,String>> mydata = new ArrayList<>();
		FileInputStream fs = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		System.out.println("Sheet Name: "+sheet);
		Row HeaderRow = sheet.getRow(0);
		for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
		{
			Row currentRow = sheet.getRow(i);
			HashMap<String, String> currentHash = new HashMap<String,String>();
			
			for(int j= 0;j<currentRow.getLastCellNum();j++)
			{
				Cell currentCell = currentRow.getCell(j);
				if(currentCell!=null)
					switch(currentCell.getCellType())
					{
					case Cell.CELL_TYPE_STRING:
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(),currentCell.getStringCellValue());
						break;
					}
			}
			mydata.add(currentHash);
		}
		fs.close();
		return mydata;
	}
	
	private static Object getStringCellValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<HashMap<String, String>> datadriven() throws IOException
	{
		List<HashMap<String, String>> arrayList_val = new ArrayList<>();
		List<HashMap<String, String>> datamap = ExcelReader.readExcelData(BrowserFunctions.USERDIR+CommonEnumConstants.EXCELFILEPATH.getValue(), "InputData");
		Iterator itr = datamap.iterator();
		while(itr.hasNext())
		{
			HashMap<String, String> keyVal=(HashMap<String, String>) itr.next();
			arrayList_val.add(keyVal);
		}
		return arrayList_val;
	}
	
	public static HashMap<String, String> getData() throws IOException
	{
		List<HashMap<String, String>> data = new ExcelReader().datadriven();
		HashMap<String, String> rc = null;
		Iterator EnterInterator = data.iterator();
		while(EnterInterator.hasNext())
		{
			rc=(HashMap<String, String>) EnterInterator.next();
			Iterator BlockIterator = rc.keySet().iterator();
		}
		return rc;
	}
}


