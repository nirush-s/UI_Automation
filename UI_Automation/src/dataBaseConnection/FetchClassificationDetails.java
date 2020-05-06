package dataBaseConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;

import generic.DataBaseVerification;
import generic.ExcelComparator;

public class FetchClassificationDetails
{

	public void fetchExpectedDetails(Map<String,String> map) throws IOException, SQLException 
	{
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelExpected(map.get("ExpectedQuery"), map.get("ExpectedExcelName"), "Values");
	}

	
	
	// To fetch Actual Data from DB
	// User has to just mention the Actual excel file name. This code will run the below mentioned query and fetch actual values.
	
	public void fetchActualDetails(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
	{
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelActual
		("Query", map.get("ActualExcelName"), "ExcelSheetName");

	}
	
	
	
	// To fetch Actual Data from DB and compare it with Expected Excel values
	// User has to just mention the Actual excel file name. This code will run the below mentioned query and fetch actual values.

	public void fetchandCompareActualDetails(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
	{
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelActual
		("Query", map.get("ActualExcelName"), "ExcelSheetName");

		// Excel Comaprision
		ExcelComparator excelcomparator =  new ExcelComparator();
		excelcomparator.compareTwoExcel(map.get("ExpectedExcelName") ,map.get("ActualExcelName"), "pass", test);	
	}
	
	
}
