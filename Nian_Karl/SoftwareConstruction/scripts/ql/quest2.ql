form SalarySurvey{
	name: "Your name pls" Str
	lastName: "Your last name pls" Str
	myAge: "How old are you?" Int
	bothNames: "Both names" Int (name + lastName)
	gotMom: "Do you have a mom?" Bool
	if(gotMom){
		momAge: "What age is ur mom?" Int
		diffAge: "Different age" Int (myAge - momAge)	
	}
}
