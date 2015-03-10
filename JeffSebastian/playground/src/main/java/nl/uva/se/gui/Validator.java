package nl.uva.se.gui;

import nl.uva.se.ast.statement.Question;

public class Validator {
	
	public boolean match(Question question, String oldValue, String newValue)
	{
		if(question.getType().getTypeName().equals("decimal")){
			if(!isNumeric(newValue)){
				return false;
			}
		}
		return true;
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

	public boolean match(Question question, Boolean oldValue, Boolean newValue) {
		// TODO Auto-generated method stub
		return false;
	}
}
