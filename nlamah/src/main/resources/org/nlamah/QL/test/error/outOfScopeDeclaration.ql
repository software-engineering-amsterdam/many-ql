form test
{
	question1 number "test1"
	
	if (question1)
	{
		question2 number "test2"
	}
	endif
	
	question3 boolean "test2" question2 + 200
}