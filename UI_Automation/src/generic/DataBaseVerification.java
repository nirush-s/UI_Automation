package generic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class DataBaseVerification
{
	public  void fetchinDataFromDBInToExcelActual (String sqlQuery,String xlName,String sheetName ) throws IOException, SQLException
	{
		try
		{
			//Setting up the data base connection
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://server_name;database=db_name;user=name;password=password");
	         if (conn != null)
	         {
                System.out.println("Connected");
	         }
	         Statement st = conn.createStatement();
	         ResultSet rs = st.executeQuery(sqlQuery);

	         
	        ResultSetMetaData data = rs.getMetaData();
	       
	        int columnsize = data.getColumnCount();
	      

	         @SuppressWarnings("resource")
	         XSSFWorkbook workbook1 = new XSSFWorkbook();
	         XSSFSheet sheet = workbook1.createSheet(sheetName);
	         XSSFRow rowhead = sheet.createRow((short) 0);
	         
	         //Setting Header style
	         CellStyle style1 = workbook1.createCellStyle();
	         style1.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
	 	     style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 	     style1.setBorderBottom(BorderStyle.THIN);
	 	     style1.setBorderLeft(BorderStyle.THIN);
	 	     style1.setBorderRight(BorderStyle.THIN);
	 	     style1.setBorderTop(BorderStyle.THIN);
	 	     XSSFFont font = workbook1.createFont();
	         font.setColor(IndexedColors.WHITE.getIndex());
	         font.setBold(true);
	         style1.setFont(font);
	         
	         //Setting Cell Style
	         CellStyle style2 = workbook1.createCellStyle();
	         style2.setBorderBottom(BorderStyle.THIN);
	 	     style2.setBorderLeft(BorderStyle.THIN);
	 	     style2.setBorderRight(BorderStyle.THIN);
	 	     style2.setBorderTop(BorderStyle.THIN);
             
	 	     //Creating excel header
	         for(int i=1;i<=columnsize;i++)
	         {
	        	 int j=i-1;
	             XSSFCell cell = rowhead.createCell((short) j);
	             cell.setCellValue(data.getColumnName(i));
	             cell.setCellStyle(style1);
	             int columnIndex = cell.getColumnIndex();
	             sheet.autoSizeColumn(columnIndex);
	          
	         }
	
	         //Fetching data from DB to excel
	         int index=1;
	         while (rs.next())
	         {
	        	 XSSFRow row = sheet.createRow((short) index);
	        	 
	        	 for(int i=1;i<=columnsize;i++)
		         {
		        	 int j=i-1;
		        	 XSSFCell cell = row.createCell((short) j);
		        	 cell.setCellValue(rs.getString(i));
		        	 cell.setCellStyle(style2);
		             int columnIndex = cell.getColumnIndex();
		             sheet.autoSizeColumn(columnIndex);
		        	 
		         }
                
		         index++;
	         }
	         
 
	         //Saving the excel
	         String path = "./ActualResult/"+xlName+".xlsx";
		     FileOutputStream fileOut;
		  
		      try 
		        {
		        	 fileOut = new FileOutputStream(path);
		             workbook1.write(fileOut);
		             fileOut.close();
		             System.out.println("File created successfully");
		        }
		        
		      catch(Exception e)
				{
		        	 System.out.println("Failed to create the file");
				}
		        conn.close();
		        
			}
			
	catch(Exception e)
			{
				 System.out.println("Failed to create the file");
			}
		}
	
	public String fetchinSingleValueDataFromDB (String sqlQuery)
	{
		String columnsValue=null;
		 ResultSet rs = null;
		try
		{
		
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://server_name;database=db_name;user=name;password=password");
	         if (conn != null)
	         {
                System.out.println("Connected");
	         }
	         
	         Statement st = conn.createStatement();
	          rs = st.executeQuery(sqlQuery);
	         
	         while(rs.next())
	         {
	        	 for(int i=1;i<=1;i++)
	        	 {
	        		 columnsValue=rs.getString(i);
	        	 }
		        
	         }
	         
	       conn.close();

		}
			
			catch(Exception e)
			{
				 System.out.println("failed to get the data");
			}
			
		return columnsValue;
	}
	public void validateSingleValueDataFromDB(String sqlQuery, String expectedValue, String pass,ExtentTest test)

	{
		String columnsValue=null;
		 ResultSet rs = null;
		try
		{
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://server_name;database=db_name;user=name;password=password");
	         if (conn != null)
	         {
               System.out.println("Connected");
	         }
	         Statement st = conn.createStatement();
	          rs = st.executeQuery(sqlQuery);
	         
	         while(rs.next())
	         {
	        	 for(int i=1;i<=1;i++)
	        	 {
	        		 columnsValue=rs.getString(i);
	        		
	        	 }
		        
	         }
	         
	         if (columnsValue.equals(expectedValue))
	         {
	    
	        	test.log(Status.PASS,MarkupHelper.createLabel( "Data Base Verification passed"+"  ActualValue: "+columnsValue+"  ExpectedValue: "+expectedValue, ExtentColor.GREEN));
	        	
	         }
	         else
	         {
	        	test.log(Status.FAIL,MarkupHelper.createLabel( "Data Base Verification failed"+"  ActualValue: "+columnsValue+"  ExpectedValue: "+expectedValue, ExtentColor.RED));
	        	
	        	// If we have to Pass the script, Send the Pass as input
	        	if (pass.equalsIgnoreCase("fail"))
	        	{
	        		Assert.fail("Data base Verification Failed");
	        	}
	        	
	         }
	       conn.close();

		}
			
			catch(Exception e)
			{
				 System.out.println("failed to get the data");
			}
	}

	public  void fetchinDataFromDBInToExcelExpected (String sqlQuery,String xlName,String sheetName ) throws IOException, SQLException
	{
		try
		{
			//Setting up the data base connection
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://server_name;database=db_name;user=name;password=password");
	         if (conn != null)
	         {
                System.out.println("Connected");
	         }
	         Statement st = conn.createStatement();
	         ResultSet rs = st.executeQuery(sqlQuery);

	         
	        ResultSetMetaData data = rs.getMetaData();
	       
	        int columnsize = data.getColumnCount();
	      

	         @SuppressWarnings("resource")
	         XSSFWorkbook workbook1 = new XSSFWorkbook();
	         XSSFSheet sheet = workbook1.createSheet(sheetName);
	         XSSFRow rowhead = sheet.createRow((short) 0);
	         
	         //Setting Header style
	         CellStyle style1 = workbook1.createCellStyle();
	         style1.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
	 	     style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 	     style1.setBorderBottom(BorderStyle.THIN);
	 	     style1.setBorderLeft(BorderStyle.THIN);
	 	     style1.setBorderRight(BorderStyle.THIN);
	 	     style1.setBorderTop(BorderStyle.THIN);
	 	     XSSFFont font = workbook1.createFont();
	         font.setColor(IndexedColors.WHITE.getIndex());
	         font.setBold(true);
	         style1.setFont(font);
	         
	         //Setting Cell Style
	         CellStyle style2 = workbook1.createCellStyle();
	         style2.setBorderBottom(BorderStyle.THIN);
	 	     style2.setBorderLeft(BorderStyle.THIN);
	 	     style2.setBorderRight(BorderStyle.THIN);
	 	     style2.setBorderTop(BorderStyle.THIN);
             
	 	     //Creating excel header
	         for(int i=1;i<=columnsize;i++)
	         {
	        	 int j=i-1;
	             XSSFCell cell = rowhead.createCell((short) j);
	             cell.setCellValue(data.getColumnName(i));
	             cell.setCellStyle(style1);
	             int columnIndex = cell.getColumnIndex();
	             sheet.autoSizeColumn(columnIndex);
	          
	         }
	
	         //Fetching data from DB to excel
	         int index=1;
	         while (rs.next())
	         {
	        	 XSSFRow row = sheet.createRow((short) index);
	        	 
	        	 for(int i=1;i<=columnsize;i++)
		         {
		        	 int j=i-1;
		        	 XSSFCell cell = row.createCell((short) j);
		        	 cell.setCellValue(rs.getString(i));
		        	 cell.setCellStyle(style2);
		             int columnIndex = cell.getColumnIndex();
		             sheet.autoSizeColumn(columnIndex);	 
		         }
                
		         index++;
	         }
	         
 
	         //Saving the excel
	         String path = "./ExpectedResult/"+xlName+".xlsx";
		        FileOutputStream fileOut;
		  
		        try 
		        {
		        	 fileOut = new FileOutputStream(path);
		             workbook1.write(fileOut);
		             fileOut.close();
		             System.out.println("File created successfully");
		        }
		        
		        catch(Exception e)
				{
		        	 System.out.println("Failed to create the file");
				}
		        conn.close();
		        
			}
			
			catch(Exception e)
			{
				 System.out.println("Failed to create the file");
			}
		}

}
