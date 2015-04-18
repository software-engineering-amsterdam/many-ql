form Box1HouseOwning
{ 
	hasSoldHouse boolean "Did you sell a house in 2010?"
	hasBoughtHouse number "Did you by a house in 2010?"
	hasMaintLoan text "Did you enter a loan for maintenance/reconstruction? Did you enter a loan for maintenance/reconstruction?"
	houseValue text "What is the value of your house?"
	
	
	if (hasSoldHouse <= 0) 
	{
		houseValue2 boolean "in if: Did you have a garage in 2010?"
	} 
	endif
	
	houseValue2 boolean "Did you have a garage in 2010?"
	
	if (hasBoughtHouse) 
	{
		houseValue2 boolean "in second if: Did you have a garage in 2010?"
		
		if ( ( 1 / 2 ) != 3) 
		{
			houseValue3 boolean "nested in second if: What was the value of your garage in 2010?"
		} 
		endif
		
	} 
	else 
	{
		houseValue2 boolean "in second else: Did you have a garage in 2010?"
	} 
	endif
	
	houseSatisfaction boolean "Were you happy in hour house in 2010?"
}
