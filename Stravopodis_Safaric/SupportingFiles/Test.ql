
form HouseSelling {
    
    question hasSoldHouse typeof boolean {
        hasSoldHouse : "Did you sell a house in 2015?";
        hasSoldHouse : false;
    }
    question hasRentHouse typeof boolean {
        hasRentHouse : "Did you bought a house in 2015?";
        hasRentHouse : true;
    }
    question hasMaintLoan typeof boolean {
    	hasMaintLoan : "Did you sell a house in 2014 ?";
    }	

    if (hasMaintLoan == false && (hasRentHouse == true && hasSoldHouse == false)){
    	question sellingPrice typeof int {
    		sellingPrice : "What was the selling price?";
    		sellingPrice : 238283;
    		question sellingPrice2 typeof decimal {
    				sellingPrice2 : "What is the seeling price 2?";
    		}
    	}
    	question privateDebt typeof int {
    		privateDebt : "What was the value of the private debt?";
    	}
    	question valueResidue typeof int {
    		valueResidue : "What was the residue value?";
    		valueResidue : sellingPrice - privateDebt;
    	}
    }
}
