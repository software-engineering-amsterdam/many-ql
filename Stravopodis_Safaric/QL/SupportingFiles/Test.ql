
// Observable pattern
// Symbol table from QL in QLS
// How to present Issue from QL type checker
// Type Checker QL - Check it - show the classes from value - supportingTypes() getType() 
// public abstract GenericValue<?> initialTypeValue(); in Type.java

/*
	for instance
	@Override
	public NumberValue initialTypeValue() {
		return new NumberValue(0);
	}

*/

form HouseSelling {
  
    
    question boolean hasRentHouse ("Did you rent a house in 2015?") { 
	     hasRentHouse : true;
	}
	
	question boolean hasBoughtHouse ("Did you bought a house in 2015?") {
		hasBoughtHouse : false;
	}
	
	question boolean hasSoldHouse ("Did you sell a house in 2014 ?");
    
     if (hasSoldHouse == true && hasRentHouse == true && hasBoughtHouse == true){
    	
    	question string firstName ("Please enter your first name:");
    	
    	question string lastName ("Please enter your last name:");
    	
    	question integer sellingPrice ("What was the selling price?"){
    		sellingPrice : 300;
    	}
    	
    	question money privateDebt ("What was the value of the private debt?");
    	
    	question money valueResidue ("Value residue:") {
    		valueResidue : (sellingPrice * privateDebt) / 100;
    	}
    }
}
