package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExcelComparator
{
	public XSSFWorkbook workbook1;
	public XSSFWorkbook workbook2;
	public  CellStyle style;
	public  Font font;
	public FileInputStream expectedResult;
	public FileInputStream actualResult ;
	public String actualFile;
	public String sheet1_value;
	public String sheet2_value;

	public  void compareTwoExcel(String expectedResultExcelName,String actualResultExcelName, String pass,ExtentTest test) throws IOException 
	{
		 // get input excel files
         expectedResult = new FileInputStream(new File( "./ExpectedResult/"+expectedResultExcelName+".xlsx"));
         actualResult = new FileInputStream(new File(  "./ActualResult/"+actualResultExcelName+".xlsx"));
         this.actualFile=actualResultExcelName;
         
         System.out.println("Input Excel files are fetched");
         
        // Create Workbook instance holding reference to .xlsx file
         workbook1 = new XSSFWorkbook(expectedResult);
         workbook2 = new XSSFWorkbook(actualResult);
        
        //color
        
	    style = workbook2.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    font = workbook2.createFont();
        font.setColor(IndexedColors.RED.getIndex());
        font.setItalic(true);
        style.setFont(font);

        // Get first/desired sheet from the workbook
        XSSFSheet sheet1 = workbook1.getSheetAt(0);
        XSSFSheet sheet2 = workbook2.getSheetAt(0);

        System.out.println("Actual Comparision Starts");
        
        // Compare sheets
        if(compareTwoSheets(sheet1, sheet2)==true) 
        {
        	test.log(Status.PASS, MarkupHelper.createLabel( "Data Base Verification PASSED Actual and Expected excel sheet are same", ExtentColor.GREEN));
            System.out.println("\n\nThe two excel sheets are Equal");
          
        } 
        else 
        {
        	test.log(Status.FAIL,  MarkupHelper.createLabel( "Data Base Verification FAILED. "+" Please find the result excel in the path: "+"./ActualResult/"+actualResultExcelName, ExtentColor.RED));
            System.out.println("\n\nThe two excel sheets are Not Equal");
           
            if(pass.equalsIgnoreCase("Fail"))
            {
            	 Assert.fail();
            }
           
        }
        
        //close files
        workbook1.close();
        workbook2.close();
        expectedResult.close();
        actualResult.close();

    
	}

	public  boolean compareTwoSheets(XSSFSheet sheet1, XSSFSheet sheet2) throws IOException 
	{
		boolean status=true;
		int numberofRows_Sheet1 = sheet1.getPhysicalNumberOfRows();
		int numberofRows_Sheet2 = sheet2.getPhysicalNumberOfRows();
		
		
		if (numberofRows_Sheet1==numberofRows_Sheet2)
		{
			int firstRow = sheet1.getFirstRowNum();
			int lastRow = sheet1.getLastRowNum();
			
			
			for (int i=firstRow+1;i<=lastRow;i++)
			{
				XSSFRow sheet1_row = sheet1.getRow(i);
				XSSFRow sheet2_row = sheet2.getRow(i);
				
				if(compareTwoRows(sheet1_row,sheet2_row)==false)
				{
					System.out.println("       Row "+i+" - is not Equal in both the sheets");
					status=false;
					
				}
				
				else
				{
					System.out.println("        Row "+i+" - is  Equal in both the sheets");
					
				}
			}
		}
		else
		{
			System.out.println("Number of rows mismatching in both the sheets");
			System.out.println("Expected number of rows "+numberofRows_Sheet1);
			System.out.println("Actual number of rows "+numberofRows_Sheet2);
			status=false;
		}
		return status;

	}

	private boolean compareTwoRows(XSSFRow sheet1_row, XSSFRow sheet2_row) throws IOException
	{
		
		boolean status=true;
//		int numberOfCells_Sheet1 = sheet1_row.getPhysicalNumberOfCells();
//		int numberOfCells_Sheet2 = sheet2_row.getPhysicalNumberOfCells();
		
//		if(numberOfCells_Sheet1 != numberOfCells_Sheet2)
//		{
//			System.out.println("Number of cells mismatching in both the sheets");
//			System.out.println("Expected number of cells "+numberOfCells_Sheet1);
//			System.out.println("Actual number of cells "+numberOfCells_Sheet2);
//			
//			status=false;
//		}
		
		
		
			int  firstcell = sheet1_row.getFirstCellNum();
			int lastcell = sheet2_row.getLastCellNum();
			
			
			
			for (int i=firstcell;i<lastcell;i++)
			{
				 XSSFCell sheet1_cell = sheet1_row.getCell(i);
				 XSSFCell sheet2_cell = sheet2_row.getCell(i);
				 
				 
				 
				 
					 if(compareTwoCells(sheet1_cell,sheet2_cell,sheet2_row)==false)
						{
						 
						 if(sheet2_cell==null)
						 {
							 XSSFCell cell = sheet2_row.createCell(i); 
							 cell.setCellStyle(style);
							 cell.setCellStyle(style);
							 setComment(cell, "Expected value= "+sheet1_value);
							 System.out.println("cell "+i+" - is not Equal in both the sheets");
							 status=false;
						 }
						
						 else
						 {
							 sheet2_cell.setCellStyle(style);
							 setComment(sheet2_cell, "Expected value= "+sheet1_value);
							 System.out.println("cell "+i+" - is not Equal in both the sheets");
							 status=false;
						 }
							
							
						}
						
					else
						{
//							System.out.println("cell "+i+" - is  Equal in both the sheets");
						}	
			}
			
			actualResult.close();
	        FileOutputStream outFile =new FileOutputStream(new File("./ActualResult/"+actualFile+".xlsx"));
	        workbook2.write(outFile);
	        outFile.close();
		
		return status;
	}

	private boolean compareTwoCells(XSSFCell sheet1_cell, XSSFCell sheet2_cell,XSSFRow sheet2_row) throws IOException
	{
		boolean status=true;
		  sheet1_value=getCellvalue(sheet1_cell);
		  sheet2_value=getCellvalue(sheet2_cell);
		 
		 if (sheet1_value.equals(sheet2_value)==false) 
		 {
			 System.out.println("Expected value= "+sheet1_value);
			 System.out.println("Actual value= "+sheet2_value);
			 
			 status= false;
		 }
		 
		 else 
		 {
			 
		 }
		return status;
	}

	private String getCellvalue(XSSFCell sheet1_cell)
	{
		String value=null;
		try
		{
			value =sheet1_cell.getStringCellValue();
			
		}
		catch(Exception e)
		{
			try
			{
				value = String.valueOf((double)sheet1_cell.getNumericCellValue());
				System.out.println(value);
			}
			

			catch(Exception e1)
			{
//				System.out.println("No record found at given cell");
				value="";
			}
		}
		
		return value;
	}
	
	public void setComment (XSSFCell cell,String message)
	{
		
      Drawing<?> drawing = cell.getSheet().createDrawingPatriarch();
      CreationHelper factory = cell.getSheet().getWorkbook().getCreationHelper();
      ClientAnchor anchor = factory.createClientAnchor();
      anchor.setCol1(cell.getColumnIndex());
      anchor.setCol2(cell.getColumnIndex() + 1);
      anchor.setRow1(cell.getRowIndex());
      anchor.setRow2(cell.getRowIndex() + 3);

      Comment comment = drawing.createCellComment(anchor);
      RichTextString str = factory.createRichTextString(message);
      comment.setVisible(Boolean.FALSE);
      comment.setString(str);

      cell.setCellComment(comment);
	}
	
}


