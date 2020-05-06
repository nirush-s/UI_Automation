package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class LeaseAssumptionDataProvider extends DataProviderGenerator  {
	
	// Assumption Data Provider
		@DataProvider(name ="DataProvider_Assumption")
		public static Object[][] Assumption()
		{
			
			String excelName = "LeaseAssumption_ExcelModel";
			Object[][] Assumption=objectGeneratorWithMultiSheet(excelName);
			return Assumption; 
		
		}

}
