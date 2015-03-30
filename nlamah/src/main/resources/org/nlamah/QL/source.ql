form Box1HouseOwning { 

	hasSoldHouse boolean "Did you sell a house in 2010?"
	hasBoughtHouse boolean "Did you by a house in 2010?"
	hasMaintLoan boolean "Did you enter a loan for maintenance/reconstruction?"
	
	houseValue money "What is the value of your house?"
	
	if ( houseValue ) {
	
		houseValue2 boolean "Did you have a garage in 2010?"
	} endif
	
	houseValue2 boolean "Did you have a garage in 2010?"
	
	if ( houseValue ) {
		houseValue2 boolean "Did you have a garage in 2010?"
		
		if ( houseValue2 ) {
			houseValue3 money "What was the value of your garage in 2010?"
		} endif
		
	} else {
		houseValue2 boolean "Did you have a garage in 2010?"
	} endif
	
	houseSatisfaction boolean "Were you happy in hour house in 2010?"
}