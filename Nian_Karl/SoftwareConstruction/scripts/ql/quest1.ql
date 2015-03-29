form SalarySurvey{
	age: "How old are you?" Int
	num1: "Number1 is " Int
	num2: "Number2 is " Int
	isMarried: "Are you married?" Bool ( age == 5 )
	isMarried2: "Are you not married?" Int ( num1 + num2 )
	if(age == (num1 + num2)){
		employeeNr1: "What is your employee number?" Int
	}else{
		howAreYou: "How Are you ?" Str	
	}
}