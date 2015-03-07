form SalarySurvey{
	age: "How old are you?" Int
	isMarried: "Are you married?" Bool	
	if(age == 25){
		employeeNr1: "What is your employee number?" Int
	}else{
		howAreYou: "How Are you ?" Str
	}
	myAge: "Hello?" Int
	
	// problem dude, it doesn't give a error the whole program just crashes at the typechecker. Run to see.
	if(nomnom == 10){
		employeeNr1: "What is your employee number?" Int
	}
}
