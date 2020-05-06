package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class LeaseExtensionAR_IR_STDataProvider extends DataProviderGenerator {
	
	// Lease Extension AR+IncomeRecognition Data Provider
	@DataProvider(name ="DataProvider_LeaseExtensionAR+IncomeRecognition+SalesTax")
	public static Object[][] leaseExtensionAR_IR_STDataProvider()
	{
		
		String excelName = "LeaseExtensionAR_IR_ST_ExcelModel";
		Object[][] LeaseExtensionAR_IncomeRecognition_ST=objectGeneratorWithMultiSheet(excelName);
		return LeaseExtensionAR_IncomeRecognition_ST; 
	
	}

}
