package dataBaseConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;

import generic.DataBaseVerification;

public class FetchLeaseRestructure 
{
	
	//To Fetch Lease Restructure values. The below query is customisable according to the Project
	
	public void fetchActualLeaseRestructure(Map <String, String> map, String LeaseSequenceNumber, ExtentTest test) throws IOException, SQLException
	{
		
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelActual("select LRestructureID,\r\n" + 
				"LeaseID,\r\n" + 
				"RestructureDate,\r\n" + 
				"PreRestructureLeaseNetBookValue,\r\n" + 
				"PostRestructureLeaseNetBookValue,\r\n" + 
				"PreRestructureNetBookValueCustomer,\r\n" + 
				"PostRestructureNetBookValueCustomer,\r\n" + 
				"PreRestructureIDCBalance,\r\n" + 
				"PostRestructureIDCBalance,\r\n" + 
				"PreRestructureResidualBalance,\r\n" + 
				"InventoryNetBookValueLossAmount,\r\n" + 
				"AccumulatedDepreciationAdjustment,\r\n" + 
				"IsActive,\r\n" + 
				"LastModifiedUserID,\r\n" + 
				"LastModifiedDate,\r\n" + 
				"InventoryNBVGain,\r\n" + 
				"NBVImpairment,\r\n" + 
				"AccumulatedIDCAdjustment,\r\n" + 
				"AccumulatedNBVImpairmentAdjustment,\r\n" + 
				"ResidualImpairment,\r\n" + 
				"IDCCostAdjustment,\r\n" + 
				"NBVImpairmentBeginBalance,\r\n" + 
				"NBVImpairmentEndBalance,\r\n" + 
				"ReceivableTypeId,\r\n" + 
				"RemovedResidualBookedAmount,\r\n" + 
				"AddedResidualBookedAmount,\r\n" + 
				"PostRestructureResidualBalance,\r\n" + 
				"ChangeInNBVAmount,\r\n" + 
				"ResidualIncomeBalance,\r\n" + 
				"InventoryTotalAmount,\r\n" + 
				"RestructureTypeID,\r\n" + 
				"IsTDR,\r\n" + 
				"TDRReasonID,\r\n" + 
				"PreRestructureUnrecoveredWriteDown,\r\n" + 
				"PostRestructureUnrecoveredWriteDown,\r\n" + 
				"DeferredRevenueAdjustment,\r\n" + 
				"JournalID,\r\n" + 
				"SourceID,\r\n" + 
				"IsPending,\r\n" + 
				"ReferenceRestructureID,\r\n" + 
				"SystemCalculatedPaymentAmount,\r\n" + 
				"FinanceSystemCalculatedPaymentAmount,\r\n" + 
				"FinancePreRestructureLeaseNetBookValue,\r\n" + 
				"FinancePostRestructureLeaseNetBookValue,\r\n" + 
				"FinancePreRestructureNetBookValueCustomer,\r\n" + 
				"FinancePostRestructureNetBookValueCustomer,\r\n" + 
				"FinancePreRestructureIDCBalance,\r\n" + 
				"FinancePostRestructureIDCBalance,\r\n" + 
				"FinancePreRestructureResidualBalance,\r\n" + 
				"FinanceInventoryNetBookValueLossAmount,\r\n" + 
				"FinanceResidualImpairment,\r\n" + 
				"FinanceIDCCostAdjustment,\r\n" + 
				"FinanceRemovedResidualBookedAmount,\r\n" + 
				"FinanceAddedResidualBookedAmount,\r\n" + 
				"FinancePostRestructureResidualBalance,\r\n" + 
				"FinanceChangeInNBVAmount,\r\n" + 
				"FinanceResidualIncomeBalance,\r\n" + 
				"FinanceInventoryTotalAmount,\r\n" + 
				"PreRestructureDeferredSellingProfitBalance,\r\n" + 
				"PostRestructureDeferredSellingProfitBalance\r\n" + 
				" from Lease_Restructure where LeaseId in (Select LeaseID from Lease_profile where Sequencenumber  =" + "'" +LeaseSequenceNumber+ "'" + ") and isactive=1", map.get("ActualLeaseRestructureExcelName")+"-"+LeaseSequenceNumber, "Lease Restructure Values");
		
	}

}
