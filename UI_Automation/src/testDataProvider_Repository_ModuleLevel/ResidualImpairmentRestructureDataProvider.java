package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class ResidualImpairmentRestructureDataProvider extends DataProviderGenerator  {
	
	// ResidualImpairmentRestructure Data Provider
		@DataProvider(name ="DataProvider_ResidualImpairmentRestructure")
		public static Object[][] LeaseResidualImpairmentRestructure()
		{
			
			String excelName = "ResidualImpairmentRestructure_ExcelModel";
			Object[][] ResidualImpairmentRestructuredata=objectGeneratorWithMultiSheet(excelName);
			return ResidualImpairmentRestructuredata; 
		
		}

}
