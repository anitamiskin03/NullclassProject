package pages;

import java.time.LocalTime;
import java.time.ZoneId;

public class TimeValidator {
	
	    public static boolean isWithinAllowedTimeWindow(int s, int e) {
	        LocalTime now = LocalTime.now(ZoneId.of("Asia/Kolkata"));
	        LocalTime start = LocalTime.of(s, 0); 
	        LocalTime end = LocalTime.of(e, 0);   
	        return !now.isBefore(start) && !now.isAfter(end);
	    }

		
		
		
	    
	    
	

}
