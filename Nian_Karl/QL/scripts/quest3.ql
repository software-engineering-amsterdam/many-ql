form SalarySurvey{
	name: "What is your name?" Str
	status: "How are you doing?" Str

	statusInt: "How are you doing?" Int(1+2)
	lastName: "What is your last name?" Str
	money: "How much do you earn?" Int
	satisfied: "Are you satisfied with this? " Bool
	playGames: "Do you like to play games?" Bool
	isBoolean: "Is this just a boolean?" Bool
	lastQuestion: "Is this the last Question of the day?" Bool

	if((-isBoolean == lastName) == !name){
		doesWork: "Hey, an Ifstatement Question" Bool
	} else {
		statusInt: "How are you doing?" Int

		if ((isBoolean + lastName) < name) {
		}

	}

	if (isBoolean) {
		isInt: "Is this a Int?" Bool
	}

}
