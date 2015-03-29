


form HouseSelling {
  
  	question string firstName ("Please enter your first name:");
  	
  	question string lastName ("Please enter your family name:");

	question boolean hasSoldHouse ("Did you sell a house in 2014 ?");  	
    
    question boolean hasRentHouse ("Did you rent a house in 2015?") { 
	     hasRentHouse : false;
	}
	
	question boolean hasBoughtHouse ("Did you bought a house in 2015?") {
		hasBoughtHouse : false;
	}
    
     if (hasSoldHouse == true && hasRentHouse == false && hasBoughtHouse == false){
    	
    	question money sellingPrice ("What was the selling price?"){
    		sellingPrice : 300 ;
    	}
    	
    	question integer depositInterestRate ("What is the bank deposit interest rate?");
    	
    	question money deposit ("Monthly interests of the deposit:"){
    		deposit : (sellingPrice * depositInterestRate) / 100;
    	}
    }
    
    if (hasSoldHouse == false && hasRentHouse == true && hasBoughtHouse == false){
    	
    	question money monthlyRent ("What was the monthly rent value?");
    	
    	question integer rentLenght ("What is the contract duration?");
    	
    	question money rentPaid ("Total amount of paid rent:"){
    		rentPaid : monthlyRent * rentLenght;
    	}
    }
    
    if (hasSoldHouse == false && hasRentHouse == false && hasBoughtHouse == true){
    	
    	question money housePrice ("What was the price of the house:");
    	
    	question integer houseSize ("What is the size of the house in m2?");
    	
    	question money pricePerM2 ("Price per m2 is equal to: "){
    		pricePerM2 : housePrice / houseSize;
    	}
    }
}
