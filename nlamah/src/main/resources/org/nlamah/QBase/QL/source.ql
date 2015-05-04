form test
{
	question1 number "test"
	question2 text "test2"
	
	if (question2 == "hello")
	{
		question3 boolean "test3"
		
		if (question3 == yes)
		{
			question4 text "test4"
		}
		elseif (question1 > 2)
		{
			question5 text "test5"
		}
		else
		{
			question6 text "test6"
		}
		endif
	}
	endif
}