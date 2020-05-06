package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class PayoffDataProvider extends DataProviderGenerator {
	// Payoff Data Provider
		@DataProvider(name ="DataProvider_Payoff")
		public static Object[][] Payoff()
		{
			
			String excelName = "Payoff_ExcelModel";
			Object[][] PayoffData=objectGeneratorWithMultiSheet(excelName);
			return PayoffData; 
		
		}

}
