form ExampleBlock {

	question MyQuestion1 (text) "What is your name?";
	question MyQuestion2 (yesno) "Are you enrolled in the UvA Master Software Engineering?";
	question MyQuestion3 (number) "How old are you?";

	if(MyQuestion2 == yes) {
	//if(yes == yes) {
		statement MyStatement10 (text, MyQuestion1) "319 Please?";
		statement MyStatement99 (text, "-> Welcome to the dawn.") "319 Please?";
	};
}
