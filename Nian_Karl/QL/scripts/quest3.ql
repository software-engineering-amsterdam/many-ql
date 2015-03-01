form SalarySurvey{
	name: "What is your name?" Str
	name: "What is your name?" Int
	status: "How are you doing?" Str

	statusInt: "How are you doing?" Int(1+2)
	lastName: "What is your last name?" Str
	money: "How much do you earn?" Int
	satisfied: "Are you satisfied with this? " Bool
	playGames: "Do you like to play games?" Bool
	isBoolean: "Is this is just a boolean?" Bool
	lastQuestion: "Is this the last Question of the day?" Bool
	if(isNian){
		doesWork: "Hey, an Ifstatement Question" Bool
		name: "What is your name?" Int
		statusInt: "How are you doing?" Int
	} else {
		name: "What is your name?" Int
		statusInt: "How are you doing?" Int
		if (isNian) {
			name: "What is your name?" Int
		}

	}

	if(isNian){

	}
}
