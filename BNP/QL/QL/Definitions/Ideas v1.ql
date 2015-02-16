form FormName {
	
	question bool question1: "Did you sell a house in 2015" required
	
	question string question2: "Who are the new home owners of your old house?" optional
	
	question int question3: "Of how many people consists your family?" required
	
	question3 > 4 {
		
		question bool question4: "Do you have time for all these kids?" optional
		
	}
	
	question1? {
	
		question2 readonly
		
	}
	
	display: "Total amount:"
	-> question3 * 4
	   + 6
	   / 2
}

"question" [type] [id]: "<question text>" [attr]
"question" [type] [attr] [id]: "<question text>"


// idea:
form form1 ->
	...
|;



form [id] {
	
	[keyword] [id] ([type],[attr,]*) => ["question"|calculation];
	
	[keyword] [id] ([type],[attr,]*) ["question"|calculation];
	
	keyword = form|question|computed|display
	attr = required|optional|()
	
	//examples:
	
	question Q1 (int, required) => "What is the age of your dog?";
	question Q2 (text, required, hidden)
	=> "How many neighbours complain about the dogs?";
	
	computed A1 (money, "Label")
	=> Q1 * 12.50;
	
	// idea:
	form theFormName { }
	question Qx (text, required) "the question text";
	computed Cy (
	
	
	----------------------------
	
	[control statement] [operation] ? ... |;
	[control statement] [operation] ? ... [control statement] [operation] ... |;
	[control statement] [operation] ? ... [control statement] ... |;
	
	control statement = [op] ==|!=|>=|<=|&&|ii|<|>
	
	//examples:
	
	if A1 > 10.50 ?
		question Q4 (int, required) => "How many kids like the dog?";
	|;
	
	if A1 > 10.50 ?
		question Q4 (int, required) => "How many kids like the dog?";
	else A1 > 20.95 ?
		question Q5 (int) => "How much do you spend on dog food?";
	|;
	
	if A1 < 5 ?
		question Q6 (string, required) => "What is the name of the first dog?";
	else
		question Q6 (bool, readonly) => "Did you even own a dog?";
	|;
}
