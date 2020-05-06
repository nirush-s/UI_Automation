package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class ReceiptPostingDataProvider extends DataProviderGenerator {
	// Receipt Posting Data Provider
		@DataProvider(name ="DataProvider_ReceiptPosting")
		public static Object[][] ReceiptPosting()
		{
			
			String excelName = "ReceiptPosting_ExcelModel";
			Object[][] RP=objectGeneratorWithSingleSheet(excelName, "Receipt Posting");
			return RP; 
		
		}

}
