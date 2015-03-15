form ExampleBlock {

	question MyQuestion1 (text) "What is your name?";
	question MyQuestion2 (yesno) "Are you enrolled in the UvA Master Software Engineering?";
	question MyQuestion3 (number) "How old are you?";

	statement MyStatement99 (text, "319 Please") "Welcome to the dawn.";

	if (yes == no)
	{
		question question4 (yesno,"13241") "This should be typechecked";
	}
	else if (yes != no)
	{
	}
	else
	{
		// statement STATEMENT2 (number) "It will be";
	};
	else
	{
		
	};
}
