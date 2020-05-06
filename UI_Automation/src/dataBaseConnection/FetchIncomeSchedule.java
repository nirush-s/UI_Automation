package dataBaseConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;

import generic.DataBaseVerification;
import generic.ExcelComparator;

public class FetchIncomeSchedule
{

			// To fetch Expected IncomeSchedule from DB
			// If user provides the Query in Input excel, this code will fetch the incomeSchedule values from DB
	
			public void fetchExpectedIncomeSchedule(Map<String,String> map) throws IOException, SQLException 
			{
				DataBaseVerification databaseverification = new DataBaseVerification();
				databaseverification.fetchinDataFromDBInToExcelExpected(map.get("ExpectedIncomeScheduleQuery"), map.get("ExpectedIncomeScheduleExcelName"), "IncomeScheduleValues");
			}

			
			
			// To fetch Actual IncomeSchedule from DB
			// User has to just mention the Actual excel file name. This code will run the below mentioned query and fetch actual values. Lease sequence number is getting fetched from Script
			
			public void fetchActualIncomeSchedule(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
			{
				DataBaseVerification databaseverification = new DataBaseVerification();
				databaseverification.fetchinDataFromDBInToExcelActual
				("select IncomeTerm,StepNumber,IncomeDate,LeasePaymentAmount,LessorBeginNetBookValue \r\n" + 
						"LessorEndNetBookValue,CustomerBeginNetBookValue,CustomerEndNetBookValue,PrimaryIncome,PrimaryIncomeBalance,IDCExpense,IDCExpenseBalance,ResidualIncome,\r\n" + 
						"ResidualIncomeBalance,MarkupIncome,MarkupIncomeBalance,InterestExpenseAmount,StraightLineInterestExpenseAmount,DeferredInterestExpenseAmount,CustomerPrimaryIncome,\r\n" + 
						"RentalIncome,DeferredRentalIncome,FloatRateAdjustmentAmount,InterestExpenceAdjustmentAmount,FloatRateChargeAmount,CumulativeFloatAdjustmentIncome,IsIDCCapitalizedToInvestment,\r\n" + 
						"DeferredSellingProfitIncome,DeferredSellingProfitBalance,IncomeWithoutProfit,FinanceLeasePaymentAmount,FinanceLessorBeginNetBookValue,FinanceLessorEndNetBookValue,\r\n" + 
						"FinanceCustomerBeginNetBookValue,FinanceCustomerEndNetBookValue,FinancePrimaryIncome,FinancePrimaryIncomeBalance,FinanceIDCExpense,FinanceIDCExpenseBalance,FinanceResidualIncome,\r\n" + 
						"FinanceResidualIncomeBalance,FinanceMarkupIncome,FinanceMarkupIncomeBalance,FinanceCustomerPrimaryIncome\r\n" + 
						"\r\n" + 
						"from Lease_IncomeSchedule where Leaseid in ( select LeaseId from Lease_profile where sequencenumber =" + "'" +LeaseSequenceNumber + "'" + ") and isactive = 1", map.get("ActualIncomeScheduleExcelName")+"-"+LeaseSequenceNumber, "IncomeScheduleValues");
		
			}
			
			
			
			// To fetch Actual IncomeSchedule from DB and comapre it with Expected Excel values
			// User has to just mention the Actual excel file name. This code will run the below mentioned query and fetch actual values. Lease sequence number is getting fetched from Script

			public void fetchandCompareActualIncomeSchedule(String LeaseSequenceNumber,Map<String,String> map, ExtentTest test) throws IOException, SQLException 
			{
				DataBaseVerification databaseverification = new DataBaseVerification();
				databaseverification.fetchinDataFromDBInToExcelActual
				("select IncomeTerm,StepNumber,IncomeDate,LeasePaymentAmount,LessorBeginNetBookValue \r\n" + 
						"LessorEndNetBookValue,CustomerBeginNetBookValue,CustomerEndNetBookValue,PrimaryIncome,PrimaryIncomeBalance,IDCExpense,IDCExpenseBalance,ResidualIncome,\r\n" + 
						"ResidualIncomeBalance,MarkupIncome,MarkupIncomeBalance,InterestExpenseAmount,StraightLineInterestExpenseAmount,DeferredInterestExpenseAmount,CustomerPrimaryIncome,\r\n" + 
						"RentalIncome,DeferredRentalIncome,FloatRateAdjustmentAmount,InterestExpenceAdjustmentAmount,FloatRateChargeAmount,CumulativeFloatAdjustmentIncome,IsIDCCapitalizedToInvestment,\r\n" + 
						"DeferredSellingProfitIncome,DeferredSellingProfitBalance,IncomeWithoutProfit,FinanceLeasePaymentAmount,FinanceLessorBeginNetBookValue,FinanceLessorEndNetBookValue,\r\n" + 
						"FinanceCustomerBeginNetBookValue,FinanceCustomerEndNetBookValue,FinancePrimaryIncome,FinancePrimaryIncomeBalance,FinanceIDCExpense,FinanceIDCExpenseBalance,FinanceResidualIncome,\r\n" + 
						"FinanceResidualIncomeBalance,FinanceMarkupIncome,FinanceMarkupIncomeBalance,FinanceCustomerPrimaryIncome\r\n" + 
						"\r\n" + 
						"from Lease_IncomeSchedule where Leaseid in ( select LeaseId from Lease_profile where sequencenumber =" + "'" +LeaseSequenceNumber + "'" + ") and isactive = 1", map.get("ActualIncomeScheduleResultExcelName")+"-"+LeaseSequenceNumber, "IncomeScheduleValues");

				// Excel Comaprision
				ExcelComparator excelcomparator =  new ExcelComparator();
				excelcomparator.compareTwoExcel(map.get("ExpectedIncomeScheduleExcelName") ,map.get("ActualIncomeScheduleExcelName")+"-"+LeaseSequenceNumber, "pass", test);	
			}
			
}
