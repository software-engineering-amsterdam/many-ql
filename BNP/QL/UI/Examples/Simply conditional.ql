form ExampleBlock {

	question MyQuestion1 (text) "What is your name?";
	question MyQuestion2 (yesno) "Are you enrolled in the UvA Master Software Engineering?";
	question MyQuestion3 (number) "How old are you?";

	if(MyQuestion2 == yes) {
		statement MyStatement99 (text, "319 Please") "Welcome to the dawn.";
	};
}
