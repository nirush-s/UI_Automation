package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class NBVImpairmentRestructureDataProvider extends DataProviderGenerator  {
	// NBVImpairmentRestructure Data Provider
		@DataProvider(name ="DataProvider_NBVImpairmentRestructure")
		public static Object[][] LeaseNBVImpairmentRestructure()
		{
			
			String excelName = "NBVImpairmentRestructure_ExcelModel";
			Object[][] NBVImpairmentRestructuredata=objectGeneratorWithMultiSheet(excelName);
			return NBVImpairmentRestructuredata; 
		
		}

}
