form SalarySurvey{
	age: "How old are you?" Int
	num1: "Number1 is " Int
	num2: "Number2 is " Int
	sum: "Sum is " Int(num1+num2)
	bool1: "age = 5 " Bool(age == 5)
	
	isMarried: "Are you married?" Bool	
	if(age == 25){
		employeeNr1: "What is your employee number?" Int
	}else{
		howAreYou: "How Are you ?" Str	
	}
}