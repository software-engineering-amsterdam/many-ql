package nl.uva.se.gui;

public class Validator {
	
	public boolean match(String oldValue, String newValue)
	{
		return false;
		/*if(type==Type.DECIMAL){
			return isNumeric(newValue);
		}else{
			return true;
		}*/
	}
	
	public boolean isNumeric( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
}
