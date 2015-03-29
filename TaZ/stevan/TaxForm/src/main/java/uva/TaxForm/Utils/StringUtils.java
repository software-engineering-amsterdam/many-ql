package uva.TaxForm.Utils;

public class StringUtils {

	public static String repeat(String s, int times) {
		
	    if ( times <= 0 ) {
	    	return "";
	    }
	    else {
	    	return s + repeat(s, times-1);
	    }
	}
}
