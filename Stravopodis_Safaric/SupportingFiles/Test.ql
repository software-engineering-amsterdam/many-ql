
form HouseSelling {
    
    question hasSoldHouse typeof boolean {
        hasSoldHouse = "Did you sell a house in 2015?";
        hasSoldHouse = false;
    }
    question hasRentHouse typeof boolean {
        hasRentHouse = "Did you bought a house in 2015?";
        hasRentHouse = 9482.23 + 2323.23 - 2323;
    }
    question hasMaintLoan typeof boolean {
    	hasMaintLoan = "Did you sell a house in 2014 ?";
    	hasMaintLoan = true;
    }	

    if (true == false){
    	question sellingPrice typeof decimal {
    		sellingPrice = "What was the selling price?";
    	}
    	question privateDebt typeof decimal {
    		privateDebt = "Private debt value:";
    	}
    	question valueResidue typeof decimal {
    		valueResidue = "Value residue:";
    		//valueResidue = sellingPrice - privateDebt;
    	}
    }
}
