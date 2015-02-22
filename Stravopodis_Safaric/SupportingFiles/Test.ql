
form HouseSelling {
    
    question hasSoldHouse typeof boolean {
        hasSoldHouse = "Did you sell a house in 2015?";
        hasSoldHouse = false;
    }
    question hasBoughtHouse typeof boolean {
        hasRentHouse = "Did you bought a house in 2015?";
        hasRentHouse = false;
    }
    question hasMaintLoan typeof boolean {
    	hasMaintLoan = "Did you enter a loan?";
    }	
    
    if (3 + 2){
    	question sellingPrice typeof decimal {
    		sellingPrice = "What was the selling price?";
    	}
    	question privateDebt typeof decimal {
    		privateDebt = "Private debts for the sold house: ";
    	}
    	question valueResidue typeof decimal {
    		valueResidue = "Value residue:";
    		valueResidue = (sellingPrice - privateDebt);
    	}
    }
}
