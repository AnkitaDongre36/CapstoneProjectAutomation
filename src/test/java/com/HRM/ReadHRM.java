package com.HRM;

import org.testng.annotations.Test;


	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeTest;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.testng.annotations.AfterTest;

	public class ReadHRM {
		File file;
		FileInputStream fis;
		XSSFWorkbook wb;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
		
	  @Test
	  public void read() {
		  System.out.println ( sheet.getRow(0).getCell(0).getStringCellValue());
			 System.out.println  (sheet.getRow(0).getCell(1).getStringCellValue());
	  }
	  @Test
	  public void readdata()
	  {
		  int rdata= sheet.getPhysicalNumberOfRows();
			 int celln=sheet.getRow(0).getPhysicalNumberOfCells();
			 System.out.println(rdata);
			  for(int i=0;i<rdata;i++)
			  {
				  row=sheet.getRow(i);
				  for(int j=0;j<celln;j++)
				  {
					  cell=row.getCell(j);
					  System.out.println (cell.getStringCellValue());
					  
				  }
			  }
	  }
	  @BeforeTest
	  public void beforeTest() throws IOException {
		  file=new File("Excel sheet//HRMdata.xlsx");
		  fis=new FileInputStream(file);
		  wb= new XSSFWorkbook(fis);
		  sheet=wb.getSheet("data");
	  }

	  @AfterTest
	  public void afterTest() throws IOException {
		  wb.close();
		  fis.close();
	  }
  
}
