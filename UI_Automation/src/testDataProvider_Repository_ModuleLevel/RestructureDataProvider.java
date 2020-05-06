package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class RestructureDataProvider extends DataProviderGenerator {
	// Restructure Data Provider
		@DataProvider(name ="DataProvider_LeaseRestructure")
		public static Object[][] LeaseRestructure()
		{
			
			String excelName = "LeaseRestructure_ExcelModel";
			Object[][] restructuredata=objectGeneratorWithMultiSheet(excelName);
			return restructuredata; 
		
		}

}
