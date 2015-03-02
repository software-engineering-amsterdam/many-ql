
form HouseSelling {
    
    question hasSoldHouse typeof boolean {
        hasSoldHouse : "Did you sell a house in 2015?";
        hasSoldHouse : false;
    }
    question hasRentHouse typeof boolean {
        hasRentHouse : "Did you bought a house in 2015?";
        hasRentHouse : false;
    }
    question hasMaintLoan typeof boolean {
    	hasMaintLoan : "Did you sell a house in 2014 ?";
    }
    
     if (hasSoldHouse == true){
    
    	question sellingPrice typeof int {
    		sellingPrice : "What was the selling price?";
    	}
    	question privateDebt typeof int {
    		privateDebt : "What was the value of the private debt?";
    	}
    	question valueResidue typeof int {
    		valueResidue : "Value residue:";
    		valueResidue : sellingPrice - privateDebt;
    	}
    }
    
    if (hasRentHouse == true){
    	question rentValue typeof int {
    		rentValue : "What was the rent value?";
    	}
    	question rentDuration typeof int {
    		rentDuration : "Duration of the agreement:";
    	}
    	question paid typeof decimal {
    		paid : "Total amount paid to date:";
    		paid : rentValue * rentDuration;
    	}
    }
    
    if (hasMaintLoan == true){
    	question loanValue typeof int {
    		loanValue : "What was the value of the loan?";
    	}
    	question interestValue typeof int {
    		interestValue : "What was the percentage of interest?";
    	}
    	question interestSum typeof decimal {
    		interestSum : "Interest value:";
    		interestSum : (loanValue * (interestValue / 100));
    	}
    }	

   
}
