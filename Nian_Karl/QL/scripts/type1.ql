form FamilySurvey {
	name: "What is your name?" Str
	age: "How old are you?" Int
	age: "How old are you?" Int
	isMarried: "Are you married?" Bool
	if (true == false) {
	
	}
    
	if (isMarried) {
		hasChild: "Do you have a child?" Bool	
		age: "How old are you?" Int
		if (hasChild) {
			ageChild: "How old is your oldest child?" Int
			age: "How old are you?" Int
			ageDiff: "The difference between the age of you and your child is :" Int(4 + 2)
		} else {
			isPlan: "Are you plan to have a child?" Bool
			age: "How old are you?" Int
		}
	}
	
}