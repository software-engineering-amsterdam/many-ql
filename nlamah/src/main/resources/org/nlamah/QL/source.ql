form test
{
	question1 number "1. How many houses did you own in 2015" 
	question2 text "What was your status in 2015"
	
	if (question2 == "divorced")
	{
		question3 boolean "Was this the first divorce in your life?"
		
		if (question3 == yes)
		{
			question4 text "What is the reason of your divorce?"
		}
		elseif (question1 > 2)
		{
			question5 boolean "Do you have more than one house because you divorced more than once?"
		}
		else
		{
			question6 number "How many houses would you like to own?"
		}
	}
	
	question7 number "7. The amount of tax you have to pay over all your houses:" = question1 * 2000 - 28 / 2 
}