
form HouseSelling {
    
    
    question boolean hasRentHouse ("Did you sell a house in 2015?") { 
	     hasRentHouse : false;
	}
	
	question boolean hasBoughtHouse ("Did you bought a house in 2015?");
	
	question integer hasSoldHouse ("Did you sell a house in 2014 ?");
    
     if (((hasSoldHouse + 9 == 4) && (hasBoughtHouse == true)) == false){
    	
    	question integer sellingPrice ("Did you sell a house in 2014 ?");
    	
    	question money privateDebt ("What was the value of the private debt?");
    	
    	question money valueResidue ("Value residue:") {
    		valueResidue : (hasSoldHouse - sellingPrice) * 100 + (hasSoldHouse / privateDebt);
    	}
    }
}
