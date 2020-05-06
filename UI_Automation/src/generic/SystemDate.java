package generic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemDate {


	public static String currentDate()
	{
		SimpleDateFormat simpledateformat= new SimpleDateFormat("M-dd-yyyy:mm:ss aa");
		String date=simpledateformat.format(new Date());
		return date;
	
	}                  
	
	public static String systemDate()
	{
		SimpleDateFormat simpledateformat= new SimpleDateFormat("M-dd-yyyy:mm:ss aa");
		String d=simpledateformat.format(new Date());
		String date=d.toString().replace(":", "-");
		return date;
	
	}    
	
	public static String systemDateWithoutTime()
	{
		SimpleDateFormat simpledateformat= new SimpleDateFormat("MM-dd-yyyy");
		String d=simpledateformat.format(new Date());
		String date=d.toString().replace(":", "-");
		return date;
	
	}    

}
