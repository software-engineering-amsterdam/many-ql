


form HouseSelling {
  
    
    question boolean hasRentHouse ("Did you rent a house in 2015?") { 
	     hasRentHouse : true;
	}
	
	question boolean hasBoughtHouse ("Did you bought a house in 2015?") {
		hasBoughtHouse : false;
	}
	
	question boolean hasSoldHouse ("Did you sell a house in 2014 ?");
    
     if (hasSoldHouse == true){
    	
    	question integer sellingPrice ("What was the selling price?"){
    		sellingPrice : 300 ;
    	}
    	
    	question money privateDebt ("What was the value of the private debt?");
    	
    	question money valueResidue ("Value residue:") {
    		valueResidue : sellingPrice - privateDebt;
    	}
    	
    }
}
