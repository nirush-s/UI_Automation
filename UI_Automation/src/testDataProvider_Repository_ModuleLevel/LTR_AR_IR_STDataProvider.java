package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class LTR_AR_IR_STDataProvider extends DataProviderGenerator {
	// LTR-AR+IncomeRecognition Data Provider
		@DataProvider(name ="DataProvider_LTR-AR+IncomeRecognition+SalesTax")
		public static Object[][] lTR_AR_IR_STDataProvider()
		{
			
			String excelName = "LTRtoAR_IR_ST_ExcelModel";
			Object[][] lTRtoAR_IncomeRecognition_ST=objectGeneratorWithMultiSheet(excelName);
			return lTRtoAR_IncomeRecognition_ST; 
		
		}

}
