package com.HRM;

import org.testng.annotations.Test;


 
	  import org.testng.annotations.Test;
	  import org.testng.annotations.DataProvider;
	  import org.testng.annotations.BeforeTest;

	  import java.io.File;
	  import java.io.FileNotFoundException;
	  import java.io.FileOutputStream;
	  import java.io.IOException;

	  import org.apache.poi.xssf.usermodel.XSSFCell;
	  import org.apache.poi.xssf.usermodel.XSSFRow;
	  import org.apache.poi.xssf.usermodel.XSSFSheet;
	  import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

	  public class SavedataHrm {
	  	File file;
	  	FileOutputStream fos;
	  	XSSFWorkbook wb;
	  	XSSFSheet sheet;
	  	XSSFRow row;
	  	XSSFCell cell;
	  	WebDriver driver;
	  	int index=0;
	    @Test(dataProvider = "logindata")
	    public void f(String sn, String up) {
	    sheet.createRow(index).createCell(0).setCellValue(sn);
	    sheet.getRow(index).createCell(1).setCellValue(up);
	   
	   
	   
	    index++;
	    }
	    

	    @DataProvider
	    public Object[][] logindata() {
	      return new Object[][] {
	      	
	      	new Object[] { "Ankita", "Dongre" },
	      	 new Object[] { "Nitin", "Meshram" },
	          new Object[] {"Pankaj","Dongre"},
	          new Object[] {"Ruchita","patil"},
	          new Object[] {"Admin","admin123"},
	          new Object[] {"Nilima","Patil"},
	          new Object[] {"ashwar","Dongre"},
	          new Object[] {"Admin","admin123"},
	        };
	      }
	      
	    @BeforeTest
	    public void beforeTest() throws FileNotFoundException {
	  	  file=new File("Excel sheet//HRMdata.xlsx");
	  	  fos=new FileOutputStream(file);
	  	  wb=new XSSFWorkbook();
	  	  sheet=wb.createSheet("data");
	  	  sheet.createRow(index).createCell(0).setCellValue("Username");
	  	  sheet.getRow(index).createCell(1).setCellValue("password");
	  	 
	  	  index++;
	    }

	    @AfterTest
	    public void afterTest() throws IOException {
	  	  wb.write(fos);
	  	  wb.close();
	  	  fos.close();
	    }
  }

