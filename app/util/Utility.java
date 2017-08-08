package util;

import java.util.Date;

public class Utility {
	
	public static Date get_date(long unixtime){
		return new Date(unixtime*1000);
	}

}
