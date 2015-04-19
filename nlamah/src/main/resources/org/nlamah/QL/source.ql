form Box1HouseOwning
{ 
	if (1 + 2 < 0)
		{
			elseQuestion boolean "else question should not show 1."
		}
		elseif( 1+2 == 3)
		{
			elseQuestion boolean "else question should SHOW"
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
