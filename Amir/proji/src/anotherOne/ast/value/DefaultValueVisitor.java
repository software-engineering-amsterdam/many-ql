package anotherOne.ast.value;

import anotherOne.ast.type.BoolType;
import anotherOne.ast.type.MoneyType;

public class DefaultValueVisitor <T>{
	
	public boolean visit (BoolType bool){ 
		return false;
	}
	
	public int visit (NumericalTypeValue num){
		return 0;
	}
	
	public int visit (MoneyType money){
		return 0;
	}
}
