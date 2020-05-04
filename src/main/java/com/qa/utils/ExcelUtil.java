package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import com.qa.utils.Constants;



import java.io.File;


public class ExcelUtil {
	
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int rowNum,colCount,i,j;
	Object[][] data=null;
	WebDriver driver;
	String shName;
	String firstName,lastName,company,street1,street2,city,state,postalcode,telephone;
	
	
	public ExcelUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	

	/*
	 * public XSSFSheet getSheet(String name) { for (XSSFSheet sheet : sheets) { if
	 * (name.equalsIgnoreCase(sheet.getSheetName())) { return sheet; } } return
	 * null; }
	 */
	 
	 
	public  Object[][] getTestdata(String sheetName)
	{
		 System.out.println(12);
		 shName=sheetName;
		 System.out.println(shName);
		try {
			 fis = new FileInputStream(Constants.TEST_DATA_PATH);
			 workbook = new XSSFWorkbook(fis);
			 sheet = workbook.getSheet(shName);
			}
			
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		row=sheet.getRow(1);
		cell=row.getCell(0);
		rowNum=sheet.getLastRowNum();
		colCount=row.getLastCellNum();
		String[][] str=new String[rowNum][colCount];
		
		
		Iterator<Row> rowIterator = sheet.iterator();
		int i=0,j=0;
		/*
		 * while (rowIterator.hasNext()) {
		 * 
		 * Row row = rowIterator.next(); Iterator<Cell> cellIterator =
		 * row.cellIterator();
		 * 
		 * while (cellIterator.hasNext()) { Cell cell1 = cellIterator.next(); //
		 * System.out.println(cell1.getStringCellValue());
		 * str[i][j]=cell1.getStringCellValue(); System.out.println( str[i][j]); j=j+1;
		 * 
		 * } i=i+1; }
		 */	
           for ( i=1;i<=rowNum;i++) 
		   {			 
			   for( j=0;j<colCount;j++) 
			   {
				   String val=(sheet.getRow(i).getCell(j)).toString();
				   System.out.println(val);
					str[i-1][j]=val;
				
			   }
			   }
				  
			/*		System.out.println(cell1.getCellType());
				  switch(cell1.getCellType()) 
				   {
				   	  case Cell.CELL_TYPE_STRING:System.out.print(cell.getStringCellValue());
				   					str[i-1][j]=cell.getStringCellValue();		
					  				break;
					  
					  case Cell.CELL_TYPE_BOOLEAN: System.out.print(cell.getBooleanCellValue()); 
						  			str[i-1][j]=String.valueOf(cell.getBooleanCellValue());
						  			break;
			  
					  case Cell.CELL_TYPE_NUMERIC: System.out.print(cell.getNumericCellValue());
					  				str[i-1][j]=String.valueOf(cell.getNumericCellValue());
					  				break;
					  default:	System.out.print(cell.getStringCellValue());
					  			str[i-1][j]=cell.getStringCellValue();		
					  			break;
				  
				   } 
				  System.out.print(" - ");
				 
				  
			  } System.out.println(); 
			}*/
				
		   Object[][] data= str;
			 return data;
           	
	}
}

