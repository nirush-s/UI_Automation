package dataBaseConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;

import generic.DataBaseVerification;
import generic.ExcelComparator;

public class FetchGLDetails 
{

/*	// To fetch Expected PrimeYield from DB
	// If user provides the Query in Input excel, this code will fetch the PrimeYield values from DB
	public void fetchExpectedGLDetails(Map<String,String> map) throws IOException, SQLException 
	{
		DataBaseVerification databaseverification = new DataBaseVerification();	
		databaseverification.fetchinDataFromDBInToExcelExpected(map.get("ExpectedGLDetailsQuery"), map.get("ExpectedPrimeYieldExcelName"), "YieldValues");	
	}*/

	// To fetch GL Details from DB
	// User has to just mention the Actual excel file name. This code will run the below mentioned query and fetch actual values. Lease sequence number is getting fetched from Script
	public void fetchActualGLDetails(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
	{
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelActual("select EntityType, SubTransactionType, EntryItem, Amount, IsReversalEntry, IsDebit, EntityTypeID from GLJournalView where EntityType ='Lease' and EntityID in (Select LeaseID from Lease_Profile where  SequenceNumber =" + "'" +LeaseSequenceNumber + "'" + ")", map.get("ActualGLDetailsExcelName")+"-"+LeaseSequenceNumber, "GLDetails");
	}
	
	// To fetch Actual GL Details from DB and comapre it with Expected Excel values
	// User has to just mention the Actual excel file name. This code will run the below mentioned query and fetch actual values. Lease sequence number is getting fetched from Script
	public void fetchandCompareGLDetails(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
	{
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelActual("select EntityType, SubTransactionType, EntryItem, Amount, IsReversalEntry, IsDebit, EntityTypeID from GLJournalView where EntityType ='Lease' and EntityID in (Select LeaseID from Lease_Profile where  SequenceNumber =" + "'" +LeaseSequenceNumber + "'" + ")", map.get("ActualGLDetailsExcelName")+"-"+LeaseSequenceNumber, "GLDetails");

		// Excel Comaprision
		ExcelComparator excelcomparator =  new ExcelComparator();
		excelcomparator.compareTwoExcel(map.get("ExpectedGLDetailsExcelName") , map.get("ActualGLDetailsExcelName"), "pass", test);
	}
	
	
}
