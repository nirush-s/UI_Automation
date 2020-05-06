package dataBaseConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;

import generic.DataBaseVerification;
import generic.ExcelComparator;

public class FetchClassificationDetails
{

	public void fetchExpectedClassificationDetails(Map<String,String> map) throws IOException, SQLException 
	{
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelExpected(map.get("ExpectedIncomeScheduleQuery"), map.get("ExpectedIncomeScheduleExcelName"), "IncomeScheduleValues");
	}

	
	
	// To fetch Actual IncomeSchedule from DB
	// User has to just mention the Actual excel file name. This code will run the below mentioned query and fetch actual values. Lease sequence number is getting fetched from Script
	
	public void fetchActualClassificationDetails(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
	{
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelActual
		("select SalesTypeTestPV,SalesTypeTestYield,DirectFinanceTestPV,DirectFinanceTestYield from LeaseTransaction_ClassificationTest where LeaseTransactionID \r\n" + 
				"in ( select LeaseTransactionID from LeaseTransaction_profile where LessorDefinedUniqueID =" + "'" +LeaseSequenceNumber + "'" + ") and isactive = 1", map.get("ActualClassificationDetailsExcelName")+"-"+LeaseSequenceNumber, "Classification Details");

	}
	
	
	
	// To fetch Actual IncomeSchedule from DB and comapre it with Expected Excel values
	// User has to just mention the Actual excel file name. This code will run the below mentioned query and fetch actual values. Lease sequence number is getting fetched from Script

	public void fetchandCompareActualClassificationDetails(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
	{
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelActual
		("select SalesTypeTestPV,SalesTypeTestYield,DirectFinanceTestPV,DirectFinanceTestYield from LeaseTransaction_ClassificationTest where LeaseTransactionID \r\n" + 
				"in ( select LeaseTransactionID from LeaseTransaction_profile where LessorDefinedUniqueID =" + "'" +LeaseSequenceNumber + "'" + ") and isactive = 1", map.get("ActualClassificationDetailsExcelName")+"-"+LeaseSequenceNumber, "Classification Details");

		// Excel Comaprision
		ExcelComparator excelcomparator =  new ExcelComparator();
		excelcomparator.compareTwoExcel(map.get("ExpectedClassificationDetailsExcelName") ,map.get("ActualClassificationDetailsExcelName")+"-"+LeaseSequenceNumber, "pass", test);	
	}
	
	
}
