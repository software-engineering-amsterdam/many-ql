form Box1HouseOwning
{ 
	if (-3 <= 0) 
	{
		houseValue2 boolean "in if: Did you have a garage in 2010?"
	} 
	endif
	
	houseValue2 boolean "Did you have a garage in 2011?"
	
	if (1 + 2 < 0) 
	{
		houseValue2 boolean "in second if: Did you have a garage in 2010?"
				
	}
	else
	{
		elseQuestion boolean "elseQuestion?"
		
		if (1 + 2 < 0)
		{
			elseQuestion boolean "else question should not show 1."
		}
		elseif( 1+2 == 3)
		{
			elseQuestion boolean "else question should SHOW"
			
			if (!houseValue2)
			{	
				test number "this is a test question?"
			}
			endif
			
			
			elseif(houseValue2)
			{
			}
			else
			{
			}
		}
		elseif (1+2 > 3)
		{
			elseQuestion boolean "else question should not show 2."
		}
		else
		{
			elseQuestion boolean "else question should not show 3."
		}
		endif
		
	}
	endif
	
	houseSatisfaction boolean "Were you happy in hour house in 2010?"

}
