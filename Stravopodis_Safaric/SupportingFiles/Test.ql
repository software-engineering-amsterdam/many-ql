
form HouseSelling {
    
    question hasSoldHouse typeof boolean {
    	decimal hasSoldHouse = 250000;
        hasSoldHouse = "Did you sell a house in 2015?";
        hasSoldHouse = false;
    }
    question hasSoldHouse typeof decimal {
        hasRentHouse = "Did you bought a house in 2015?";
        hasRentHouse = false;
    }
    question hasMaintLoan typeof boolean {
    	hasMaintLoan = true;
    }	
    
    if ( hasSoldHouse == false){
    	question sellingPrice typeof decimal {
    		sellingPrice = "What was the selling price?";
    	}
    	question privateDebt typeof decimal {
    		privateDebt = "Private debts for the sold house: ";
    	}
    	question valueResidue typeof decimal {
    		valueResidue = "Value residue:";
    		valueResidue = 1000 - (282 / 100) * 23;
    	}
    }
}
