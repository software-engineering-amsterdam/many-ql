
form HouseSelling {
    
    question hasSoldHouse typeof boolean {
        hasSoldHouse : "Did you sell a house in 2015?";
        hasSoldHouse : false;
    }
    question hasRentHouse typeof boolean {
        hasRentHouse : "Did you bought a house in 2015?";
    }
    question hasMaintLoan typeof boolean {
    	hasMaintLoan : "Did you sell a house in 2014 ?";
    }
    
     if (hasSoldHouse == true){
    	question sellingPrice typeof money {
    		sellingPrice : "Did you sell a house in 2014 ?";
    	}
    	question privateDebt typeof integer {
    		privateDebt : "What was the value of the private debt?";
    	}
    	question valueResidue typeof money {
    		valueResidue : "Value residue:";
    		valueResidue : sellingPrice - privateDebt;
    	}	
    }
}
