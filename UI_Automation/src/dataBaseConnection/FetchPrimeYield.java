package dataBaseConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;

import generic.DataBaseVerification;
import generic.ExcelComparator;

public class FetchPrimeYield 
{

			// To fetch Expected PrimeYield from DB
			// If user provides the Query in Input excel, this code will fetch the PrimeYield values from DB
			public void fetchExpectedPrimeYield(Map<String,String> map) throws IOException, SQLException 
			{
				DataBaseVerification databaseverification = new DataBaseVerification();	
				databaseverification.fetchinDataFromDBInToExcelExpected(map.get("ExpectedPrimeYieldQuery"), map.get("ExpectedPrimeYieldExcelName"), "YieldValues");	
			}

			// To fetch Actual PrimeYield from DB
			// User has to just mention the Actual excel file name. This code will run the below mentioned query and fetch actual values. Lease sequence number is getting fetched from Script
			public void fetchActualPrimeYield(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
			{
				DataBaseVerification databaseverification = new DataBaseVerification();
				databaseverification.fetchinDataFromDBInToExcelActual("Select CustomerYield, PrimeYield, IDCYield from Lease_Yield where LeaseID in (Select LeaseID from Lease_Profile where  SequenceNumber =" + "'" +LeaseSequenceNumber + "'" + ")", map.get("ActualPrimeYieldExcelName")+"-"+LeaseSequenceNumber, "YieldValues");
			}
			
			// To fetch Actual PrimeYield from DB and comapre it with Expected Excel values
			// User has to just mention the Actual excel file name. This code will run the below mentioned query and fetch actual values. Lease sequence number is getting fetched from Script
			public void fetchandCompareActualPrimeYield(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
			{
				DataBaseVerification databaseverification = new DataBaseVerification();
				databaseverification.fetchinDataFromDBInToExcelActual("Select CustomerYield, PrimeYield, IDCYield from Lease_Yield where LeaseID in (Select LeaseID from Lease_Profile where  SequenceNumber =" + "'" +LeaseSequenceNumber + "'" + ")", map.get("ActualPrimeYieldExcelName")+"-"+LeaseSequenceNumber, "YieldValues");
		
				// Excel Comaprision
				ExcelComparator excelcomparator =  new ExcelComparator();
				excelcomparator.compareTwoExcel(map.get("ExpectedPrimeYieldExcelName") , map.get("ActualPrimeYieldExcelName"), "pass", test);
			}
			
			
			
		// The below code will do the same functionality mentioned above, but this is to fetch prime yield of Restructured Leases	
			
			public void fetchExpectedRestructuredPrimeYield(Map<String,String> map) throws IOException, SQLException 
			{
				DataBaseVerification databaseverification = new DataBaseVerification();	
				databaseverification.fetchinDataFromDBInToExcelExpected(map.get("ExpectedYieldQuery"), map.get("ExpectedPrimeYieldExcelName"), "YieldValues");	
			}
			
			public void fetchandCompareActualRestructuredPrimeYield(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
			{
				DataBaseVerification databaseverification = new DataBaseVerification();
				databaseverification.fetchinDataFromDBInToExcelActual("Select CustomerYield, PrimeYield, IDCYield from Lease_Yield where LeaseID in (Select LeaseID from Lease_Profile where  SequenceNumber =" + "'" +LeaseSequenceNumber + "'" + ") and isactive=1 and StepNumber= 2", map.get("ActualPrimeYieldExcelName")+"-"+LeaseSequenceNumber, "YieldValues");
		
				ExcelComparator excelcomparator =  new ExcelComparator();
				excelcomparator.compareTwoExcel(map.get("ExpectedPrimeYieldExcelName") , map.get("ActualPrimeYieldExcelName"), "pass", test);
			}
			
			public void fetchActuaRestructuredlPrimeYield(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
			{
				DataBaseVerification databaseverification = new DataBaseVerification();
				databaseverification.fetchinDataFromDBInToExcelActual("Select CustomerYield, PrimeYield, IDCYield from Lease_Yield where LeaseID in (Select LeaseID from Lease_Profile where  SequenceNumber =" + "'" +LeaseSequenceNumber + "'" + ") and isactive=1 and StepNumber= 2", map.get("ActualPrimeYieldExcelName")+"-"+LeaseSequenceNumber, "YieldValues");
			}
			
}
